package com.test.popupwindow;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.test.fupengpeng.testapp.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PopupWindowActivity extends AppCompatActivity implements SelectPicturePopupWindow.OnSelectedListener{
    ImageView imageView;
    private static String TAG = "PopupWindowActivity";
    private AlertDialog mAlertDialog;

    protected static final int REQUEST_STORAGE_READ_ACCESS_PERMISSION = 101;
    protected static final int REQUEST_STORAGE_WRITE_ACCESS_PERMISSION = 102;

    private static final int GALLERY_REQUEST_CODE = 0;    // 相册选图标记
    private static final int CAMERA_REQUEST_CODE = 1;    // 相机拍照标记

    // 拍照临时图片
    private String mTempPhotoPath;
    // 剪切后图像文件
    private Uri mDestinationUri;
    /**
     * 选择提示 PopupWindow
     */
    private SelectPicturePopupWindow mSelectPicturePopupWindow;


    /**
     * 图片选择的监听回调
     */
    private OnPictureSelectedListener mOnPictureSelectedListener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        imageView = (ImageView) findViewById(R.id.main_frag_picture_iv);

        mTempPhotoPath = Environment.getExternalStorageDirectory() + File.separator + "photo.jpeg";

        mSelectPicturePopupWindow = new SelectPicturePopupWindow(this);
        mSelectPicturePopupWindow.setOnSelectedListener(this);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSelectPicturePopupWindow.showPopupWindow(PopupWindowActivity.this);
            }
        });
        // 设置裁剪图片结果监听
        setOnPictureSelectedListener(new OnPictureSelectedListener() {
            @Override
            public void onPictureSelected(Uri fileUri, Bitmap bitmap) {
                Log.e(TAG, "MainFragment-------------------------------------onPictureSelected: " );
                imageView.setImageBitmap(bitmap);

                String filePath = fileUri.getEncodedPath();
                String imagePath = Uri.decode(filePath);
                Toast.makeText(PopupWindowActivity.this, "图片已经保存到:" + imagePath, Toast.LENGTH_LONG).show();
            }
        });
    }
    /**
     * 显示指定标题和信息的对话框
     *
     * @param title                         - 标题
     * @param message                       - 信息
     * @param onPositiveButtonClickListener - 肯定按钮监听
     * @param positiveText                  - 肯定按钮信息
     * @param onNegativeButtonClickListener - 否定按钮监听
     * @param negativeText                  - 否定按钮信息
     */
    protected void showAlertDialog(@Nullable String title, @Nullable String message,
                                   @Nullable DialogInterface.OnClickListener onPositiveButtonClickListener,
                                   @NonNull String positiveText,
                                   @Nullable DialogInterface.OnClickListener onNegativeButtonClickListener,
                                   @NonNull String negativeText) {
        Log.e(TAG, "BaseFragment------------------------------------------------------------------------showAlertDialog: " );
        AlertDialog.Builder builder = new AlertDialog.Builder(PopupWindowActivity.this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(positiveText, onPositiveButtonClickListener);
        builder.setNegativeButton(negativeText, onNegativeButtonClickListener);
        mAlertDialog = builder.show();
    }
    /**
     * 请求权限
     *
     * 如果权限被拒绝过，则提示用户需要权限
     */
    protected void requestPermission(final String permission, String rationale, final int requestCode) {
        Log.e(TAG, "BaseFragment------------------------------------------------------------------------requestPermission: " );
//        if (shouldShowRequestPermissionRationale(permission)) {
//            showAlertDialog(getString(R.string.permission_title_rationale), rationale,
//                    new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Log.e(TAG, "BaseFragment------------------------------------------------------------------------onClick: " );
//                            requestPermissions(new String[]{permission}, requestCode);
//                        }
//                    }, getString(R.string.label_ok), null, getString(R.string.label_cancel));
//        } else {
//            Log.e(TAG, "BaseFragment------------------------------------------------------------------------requestPermission: BaseFragment--------------------------------------" );
//            requestPermissions(new String[]{permission}, requestCode);
//        }
    }

    /**
     * 选择拍照或者相册按钮，执行对应的操作
     * @param v
     * @param position
     */
    @Override
    public void OnSelected(View v, int position) {
        switch (position) {
            case 0:
                // "拍照"按钮被点击了
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN // Permission was added in API Level 16
                        && ActivityCompat.checkSelfPermission(PopupWindowActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            getString(R.string.permission_write_storage_rationale),
                            REQUEST_STORAGE_WRITE_ACCESS_PERMISSION);
                } else {
                    mSelectPicturePopupWindow.dismissPopupWindow();
                    Intent takeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    //下面这句指定调用相机拍照后的照片存储的路径
                    takeIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(mTempPhotoPath)));
                    startActivityForResult(takeIntent, CAMERA_REQUEST_CODE);
                }
//                takePhoto();
                break;
            case 1:
                // "从相册选择"按钮被点击了
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN // Permission was added in API Level 16
                        && ActivityCompat.checkSelfPermission(PopupWindowActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    requestPermission(Manifest.permission.READ_EXTERNAL_STORAGE,
                            getString(R.string.permission_read_storage_rationale),
                            REQUEST_STORAGE_READ_ACCESS_PERMISSION);
                } else {
                    mSelectPicturePopupWindow.dismissPopupWindow();
                    Intent pickIntent = new Intent(Intent.ACTION_PICK, null);
                    // 如果限制上传到服务器的图片类型时可以直接写如："image/jpeg 、 image/png等的类型"
                    pickIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                    startActivityForResult(pickIntent, GALLERY_REQUEST_CODE);
                }
//                pickFromGallery();
                break;
            case 2:
                // "取消"按钮被点击了
                mSelectPicturePopupWindow.dismissPopupWindow();
                break;
        }
    }


    /**
     * 设置图片选择的回调监听
     *
     * @param l
     */
    public void setOnPictureSelectedListener(OnPictureSelectedListener l) {
        this.mOnPictureSelectedListener = l;
    }
    /**
     * 图片选择的回调接口
     */
    public interface OnPictureSelectedListener {
        /**
         * 图片选择的监听回调
         *
         * @param fileUri
         * @param bitmap
         */
        void onPictureSelected(Uri fileUri, Bitmap bitmap);
    }
    /**
     * 删除拍照临时文件
     */
    private void deleteTempPhotoFile() {
        File tempFile = new File(mTempPhotoPath);
        if (tempFile.exists() && tempFile.isFile()) {
            tempFile.delete();
        }
    }

    /**
     * 处理剪切成功的返回值
     *
     * @param result
     */
    private void handleCropResult(Intent result) {
        deleteTempPhotoFile();
        final Uri resultUri = UCrop.getOutput(result);
        if (null != resultUri && null != mOnPictureSelectedListener) {
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(PopupWindowActivity.this.getContentResolver(), resultUri);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mOnPictureSelectedListener.onPictureSelected(resultUri, bitmap);
        } else {
            Toast.makeText(PopupWindowActivity.this, "无法剪切选择图片", Toast.LENGTH_SHORT).show();
        }
    }
}

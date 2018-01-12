package com.fpp.androidtestapp.activity.impl.imageview;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.QuickContactBadge;
import android.widget.Toast;

import com.fpp.androidtestapp.R;
import com.fpp.androidtestapp.util.AppUtils;
import com.fpp.androidtestapp.util.LogUtils;
import com.fpp.androidtestapp.util.ToastUtils;
import com.fpp.androidtestapp.util.UIUtils;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author fupengpeng
 * @description ImageView及子类应用
 * @date 2018/1/8 0008 10:50
 */
public class ImageViewActivity extends AppCompatActivity {

    @BindView(R.id.badge)
    QuickContactBadge badge;
    @BindView(R.id.iv_activity_image_view)
    ImageView ivActivityImageView;
    @BindView(R.id.takePhone)
    Button takePhone;
    @BindView(R.id.choosePhone)
    Button choosePhone;

    @BindView(R.id.camera)
    Button camera;

    /**
     * 扫描二维码返回结果码
     */
    private static final int REQUEST_CODE = 10001;

    /**
     * 拍照权限申请码
     */
    private final int CAMERA_PHOTO_REQUEST_CODE = 9001;
    /**
     * 相册权限申请码(存储)
     */
    private final int PHOTO_ALBUM_REQUEST_CODE = 9002;
    /**
     * 相机权限申请码
     */
    private final int CAMERA_REQUEST_CODE = 9003;

    /**
     * 图片处理响应码
     */
    private final int PICTURE_PROCESSING_REQUEST_CODE = 9004;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view2);
        ButterKnife.bind(this);

        badge.assignContactFromPhone("15709203975", false);

        initview();


    }

    private void initview() {


    }


    @OnClick({R.id.takePhone, R.id.choosePhone, R.id.iv_activity_image_view,R.id.camera})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.camera:

                break;
            case R.id.takePhone:

                break;
            case R.id.choosePhone:

                break;
            case R.id.iv_activity_image_view:

                ToastUtils.showLong(this, "点击图片干嘛？？？");

                //弹出对话框
                final AlertDialog dialog = new AlertDialog.Builder(this).create();
                dialog.show();
                //自定义dialog的ui
                Window window = dialog.getWindow();
                View dialogView = View.inflate(this, R.layout.dialog_billing_select_image_select, null);
                LinearLayout llSelectCamera = (LinearLayout) dialogView.findViewById(R.id.ll_dialog_billing_select_camera);
                llSelectCamera.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void onClick(View v) {
                        checkSelfPermission(CAMERA_PHOTO_REQUEST_CODE);
                        dialog.dismiss();
                    }
                });

                LinearLayout llSelectPhotoAlbum = (LinearLayout) dialogView.findViewById(R.id.ll_dialog_billing_select_photo_album);
                llSelectPhotoAlbum.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checkSelfPermission(PHOTO_ALBUM_REQUEST_CODE);
                        dialog.dismiss();
                    }
                });
                window.setContentView(dialogView);
                break;
        }
    }


    /**
     * 检测用户是否拥有对应的权限
     * @param tag  调用方法标识
     */
    @TargetApi(Build.VERSION_CODES.M)
    public void checkSelfPermission(int tag){
        switch (tag){
            case CAMERA_PHOTO_REQUEST_CODE:
                //判断是否有相机和存储权限
                if ((ContextCompat.checkSelfPermission(ImageViewActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)||
                        (ContextCompat.checkSelfPermission(ImageViewActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)||
                        (ContextCompat.checkSelfPermission(ImageViewActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)){
                    //如果没有授权，则请求授权
                    ActivityCompat.requestPermissions(ImageViewActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, CAMERA_PHOTO_REQUEST_CODE);
                }else {
                    // TODO: 2018/1/12 0012 相机拍照 ----- 判断系统版本决定是否拍照（涉及Android7.0存储空间问题）
                    android7(CAMERA_PHOTO_REQUEST_CODE);
                }
                break;
            case PHOTO_ALBUM_REQUEST_CODE:

                // 判断有无存储空间权限
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !AppUtils.hasWriteExternalStoragePermission(ImageViewActivity.this, true)) {
                    // 申请权限
                    ImageViewActivity.this.requestPermissions(
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PHOTO_ALBUM_REQUEST_CODE);

                }else {
                    //有存储空间权限
                    // TODO: 2018/1/12 0012 相册 ----- 判断系统版本决定是否拍照（涉及Android7.0存储空间问题）
                    //从图库中获取资源
                    // Intent.ACTION_PICK 进入图库获取照片意图
//                    intent = new Intent(Intent.ACTION_PICK);
//                    android7(PHOTO_ALBUM_REQUEST_CODE);
//                    startActivityForResult(intent, PHOTO_ALBUM_REQUEST_CODE);

                    //从图库中获取资源
                    // Intent.ACTION_PICK 进入图库获取照片意图
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    //设置类型
                    intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                    startActivityForResult(intent, 3);
                }
                break;


        }
    }

    /**
     * 创建的图片保存文件
     */
    File filep;
    /**
     * 图片保存路径
     */
    Uri imageUri;
    // 处理后图片（用于显示和上传）
    Bitmap bitmap;

    /**
     * android 7.0 文件路径处理
     */
    public void android7(int tag){
        //获取系統版本
        int currentapiVersion = Build.VERSION.SDK_INT;
        switch (tag){
            case CAMERA_PHOTO_REQUEST_CODE:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (hasSdcard()) {
                    filep = new File(tempPhotoPath);
                    LogUtils.e("file = " + filep.toURI().toString());      //  file:/storage/emulated/0/Pictures/tks_temp_photo.jpeg
                    // 判断系统版本，根据是否大于24决定uri创建方式
                    if (currentapiVersion < 24) {
                        // 从文件中创建uri
                        imageUri = Uri.fromFile(filep);
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    } else {
                        //兼容android7.0 使用共享文件的形式
                        ContentValues contentValues = new ContentValues(1);
                        contentValues.put(MediaStore.Images.Media.DATA, filep.getAbsolutePath());
                        //检查是否有存储权限，以免崩溃
                        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                                != PackageManager.PERMISSION_GRANTED) {
                            //申请WRITE_EXTERNAL_STORAGE权限
                            Toast.makeText(this, "请开启存储权限", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        //intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        imageUri = FileProvider.getUriForFile(this, "com.fpp.androidtestapp.fileProvider", filep);
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    }
                    LogUtils.e("imageUri = " + imageUri.toString());
                }
                startActivityForResult(intent, CAMERA_PHOTO_REQUEST_CODE);
                break;

            case PHOTO_ALBUM_REQUEST_CODE:

                break;
        }



    }

    /**
     * 拍照临时图片
     */
    protected static final String tempPhotoPath = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_PICTURES) + File.separator + "tks_temp_photo.jpeg";
    /**
     * 裁剪临时图片
     */
    protected static final String tempCropPhotoPath = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_PICTURES) + File.separator + "tks_temp_crop_photo.jpeg";
    /**
     * 判断sdcard是否被挂载
     */
    public static boolean hasSdcard() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }

    /**
     * 权限申请返回结果
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case CAMERA_PHOTO_REQUEST_CODE:
                // TODO: 2018/1/12 0012 相机拍照 ----- 判断系统版本决定是否拍照（涉及Android7.0存储空间问题）
                android7(CAMERA_PHOTO_REQUEST_CODE);
                break;
            case PHOTO_ALBUM_REQUEST_CODE:
                // TODO: 2018/1/12 0012 相册 ----- 判断系统版本决定是否拍照（涉及Android7.0存储空间问题）
                //从图库中获取资源
                // Intent.ACTION_PICK 进入图库获取照片意图
//                intent = new Intent(Intent.ACTION_PICK);
//                android7(PHOTO_ALBUM_REQUEST_CODE);
//                startActivityForResult(intent, PHOTO_ALBUM_REQUEST_CODE);
                //从图库中获取资源
                // Intent.ACTION_PICK 进入图库获取照片意图
                Intent intent = new Intent(Intent.ACTION_PICK);
                //设置类型
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, PHOTO_ALBUM_REQUEST_CODE);
                break;

        }

    }

    /**
     * 调用系统应用返回结果
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtils.e("request = " + requestCode + "   result = " + resultCode);
        Bundle bundle;
        if (resultCode == RESULT_OK) {
            switch (requestCode){
                case CAMERA_PHOTO_REQUEST_CODE:
                    // TODO: 2018/1/12 0012 相机拍照返回结果
                    Uri mImageCaptureUri;
                    File filePhoto = new File(tempPhotoPath);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        //兼容android7.0 使用共享文件的形式
                        ContentValues contentValues = new ContentValues(1);
                        contentValues.put(MediaStore.Images.Media.DATA, filePhoto.getAbsolutePath());
                        //检查是否有存储权限，以免崩溃
                        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                                != PackageManager.PERMISSION_GRANTED) {
                            //申请WRITE_EXTERNAL_STORAGE权限
                            Toast.makeText(this, "请开启存储权限", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        mImageCaptureUri = FileProvider.getUriForFile(this, "com.fpp.androidtestapp.fileProvider", filePhoto);
                    } else {
                        mImageCaptureUri = Uri.fromFile(filePhoto);
                    }
                    pictureProcessing(mImageCaptureUri);
                    break;
                case PHOTO_ALBUM_REQUEST_CODE:
                    // TODO: 2018/1/12 0012 相册获取图片返回结果

                    pictureProcessing(imageUri);
                    break;

                case PICTURE_PROCESSING_REQUEST_CODE:
                    //图片处理返回结果
                    if (resultCode == RESULT_OK) {
                        try {
                            filep = new File(tempCropPhotoPath);
                            bitmap = BitmapFactory.decodeFile(filep.getAbsolutePath());
                            // 设置裁剪后的图片
                            ivActivityImageView.setImageBitmap(bitmap);
                        } catch (Exception e) {

                        }
                    }
                    break;
            }
        }
    }

    /**
     * 图片处理
     *
     * @param uri
     */
    public void pictureProcessing(Uri uri) {
        LogUtils.e("uri = " + uri.toString());
        //使用意图剪切照片
        Intent intent = new Intent();
        //设置要剪切的资源文件和类型
        intent.setDataAndType(uri, "image/*");
        //设置剪切
        intent.setAction("com.android.camera.action.CROP");
        //开启剪切
        intent.putExtra("crop", "true");
        //设置 裁剪框比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        //设置裁剪后输出的照片大小
        intent.putExtra("outputX", 600);
        intent.putExtra("outputY", 600);
        File file = new File(tempCropPhotoPath);
        LogUtils.e("tempCropPhotoPath = " + tempCropPhotoPath);
        LogUtils.e("urifile = " + file.toURI().toString());
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
        intent.putExtra("return-data", false);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        }
        //启动
        startActivityForResult(intent, PICTURE_PROCESSING_REQUEST_CODE);

    }









}

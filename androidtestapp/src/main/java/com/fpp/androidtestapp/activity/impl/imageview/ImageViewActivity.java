package com.fpp.androidtestapp.activity.impl.imageview;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ContentResolver;
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
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.QuickContactBadge;
import android.widget.Toast;

import com.fpp.androidtestapp.R;
import com.fpp.androidtestapp.util.ToastUtils;
import com.fpp.androidtestapp.util.UIUtils;

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


    private static final int CROP_PHOTO = 2;
    private static final int REQUEST_CODE_PICK_IMAGE = 3;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 6;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE2 = 7;
    @BindView(R.id.camera)
    Button camera;
    private File output;
    private Uri imageUri;


    private static final int NEED_CAMERA = 200;
    private static final int RESULT_PICK = 201;


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

    @OnClick(R.id.camera)
    public void onViewClicked() {


    }

    @OnClick({R.id.takePhone, R.id.choosePhone, R.id.iv_activity_image_view})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.takePhone:
                takePhone();
                break;
            case R.id.choosePhone:
                choosePhone();
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
//                        // 判断有无存储空间权限
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !AppUtils.hasWriteExternalStoragePermission(ImageViewActivity.this, true)) {
//                            // 申请权限
//                            ImageViewActivity.this.requestPermissions(
//                                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1);
//                            // 解释权限
//                            if (ImageViewActivity.this.shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//                                ToastUtils.showLong(ImageViewActivity.this, Consts.WaitDialogMessage.SET_EXTERNAL_STORAGE_PERMISSION);
//                            }
//                            return;
//                        }
//                        // 拍照
//                        //takePhoto();
////                        requestCameraPermission();
                        //检测是否有相机和读写文件权限
                        if (ContextCompat.checkSelfPermission(UIUtils.getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                                ||
                                ContextCompat.checkSelfPermission(UIUtils.getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                            ImageViewActivity.this.requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, NEED_CAMERA);
                        } else {
                            //打开相机获取图片
                            startCamera();
                        }
                        dialog.dismiss();
                    }
                });

                LinearLayout llSelectPhotoAlbum = (LinearLayout) dialogView.findViewById(R.id.ll_dialog_billing_select_photo_album);
                llSelectPhotoAlbum.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        // 判断有无存储空间权限
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !AppUtils.hasWriteExternalStoragePermission(ImageViewActivity.this, true)) {
//                            // 申请权限
//                            ImageViewActivity.this.requestPermissions(
//                                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
//                            // 解释权限
//                            if (ImageViewActivity.this.shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//                                ToastUtils.showLong(ImageViewActivity.this, Consts.WaitDialogMessage.SET_EXTERNAL_STORAGE_PERMISSION);
//                            }
//                            return;
//                        }
//                        // 从相册中选择
//                        // TODO: 2018/1/11 0011  相册
////                selectFromAlbum();

                        if (ContextCompat.checkSelfPermission(UIUtils.getContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                                != PackageManager.PERMISSION_GRANTED) {
                            ImageViewActivity.this.requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, RESULT_PICK);
                        } else {
                            //选择图片
                            startPickPhoto();
                        }
                        dialog.dismiss();
                    }
                });
                window.setContentView(dialogView);

                break;
        }
    }

    private void startPickPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "请选择图片"), RESULT_PICK);

    }

    File newFile;
    Uri contentUri;

    private void startCamera() {
        File imagePath = new File(Environment.getExternalStorageDirectory(), "images");
        if (!imagePath.exists()) imagePath.mkdirs();
        newFile = new File(imagePath, "point_image.jpg");

        //第二参数是在manifest.xml定义 provider的authorities属性
        contentUri = FileProvider.getUriForFile(UIUtils.getContext(), "com.example.administrator.im_demo.fileprovider", newFile);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //兼容版本处理，因为 intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION) 只在5.0以上的版本有效
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            ClipData clip = ClipData.newUri(ImageViewActivity.this.getContentResolver(), "A photo", contentUri);
            intent.setClipData(clip);
            intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        } else {
            List<ResolveInfo> resInfoList = ImageViewActivity.this.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
            for (ResolveInfo resolveInfo : resInfoList) {
                String packageName = resolveInfo.activityInfo.packageName;
                ImageViewActivity.this.grantUriPermission(packageName, contentUri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            }
        }
        intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);
        startActivityForResult(intent, NEED_CAMERA);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        switch (requestCode) {
            case NEED_CAMERA:
                // 如果权限被拒绝，grantResults 为空
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //打开相机获取图片
                    startCamera();
                } else {
                    Toast.makeText(UIUtils.getContext(), "需要相机和读写文件权限", Toast.LENGTH_SHORT).show();
                }
                break;
            case RESULT_PICK:
                // 如果权限被拒绝，grantResults 为空
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //选择图片
                    startPickPhoto();
                } else {
                    Toast.makeText(UIUtils.getContext(), "需要读取权限", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case NEED_CAMERA:
                ContentResolver contentProvider = ImageViewActivity.this.getContentResolver();
                ParcelFileDescriptor mInputPFD;
                try {
                    //获取contentProvider图片
                    mInputPFD = contentProvider.openFileDescriptor(contentUri, "r");
                    FileDescriptor fileDescriptor = mInputPFD.getFileDescriptor();
                    ivActivityImageView.setImageBitmap(BitmapFactory.decodeFileDescriptor(fileDescriptor));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            //选择照片
            case RESULT_PICK:
                try {
                    Uri uri = data.getData();
                    //打开圆形裁剪图界面
//                    String path = Utils.getRealFilePathFromUri( ImageViewActivity.this.getApplicationContext(), uri);
//                    Bitmap bitmaps = BitmapUtil.decodeSampledBitmap(path, 720, 1280);
                    Bitmap bit = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                    ivActivityImageView.setImageBitmap(bit);
                    /**
                     * 请求网络，将图片上传到服务器
                     */
                    //upLoadImg(path);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void takePhone() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE2);

        } else {
            takePhoto();
        }

    }

    public void choosePhone() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE2);

        } else {
            choosePhoto();
        }
    }

    /**
     * 拍照
     */
    void takePhoto() {
        /**
         * 最后一个参数是文件夹的名称，可以随便起
         */
        File file = new File(Environment.getExternalStorageDirectory(), "拍照");
        if (!file.exists()) {
            file.mkdir();
        }
        /**
         * 这里将时间作为不同照片的名称
         */
        output = new File(file, System.currentTimeMillis() + ".jpg");

        /**
         * 如果该文件夹已经存在，则删除它，否则创建一个
         */
        try {
            if (output.exists()) {
                output.delete();
            }
            output.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * 隐式打开拍照的Activity，并且传入CROP_PHOTO常量作为拍照结束后回调的标志
         */
        imageUri = Uri.fromFile(output);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(intent, CROP_PHOTO);

    }

    /**
     * 从相册选取图片
     */
    void choosePhoto() {
        /**
         * 打开选择图片的界面
         */
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");//相片类型
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);

    }



//    public void onActivityResult(int req, int res, Intent data) {
//        switch (req) {
//            /**
//             * 拍照的请求标志
//             */
//            case CROP_PHOTO:
//                if (res == RESULT_OK) {
//                    try {
//                        /**
//                         * 该uri就是照片文件夹对应的uri
//                         */
//                        Bitmap bit = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
//                        ivActivityImageView.setImageBitmap(bit);
//                    } catch (Exception e) {
//                        Toast.makeText(this, "程序崩溃", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Log.i("tag", "失败");
//                }
//
//                break;
//            /**
//             * 从相册中选取图片的请求标志
//             */
//
//            case REQUEST_CODE_PICK_IMAGE:
//                if (res == RESULT_OK) {
//                    try {
//                        /**
//                         * 该uri是上一个Activity返回的
//                         */
//                        Uri uri = data.getData();
//                        Bitmap bit = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
//                        ivActivityImageView.setImageBitmap(bit);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        Log.d("tag", e.getMessage());
//                        Toast.makeText(this, "程序崩溃", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Log.i("liang", "失败");
//                }
//
//                break;
//
//            default:
//                break;
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//
//        if (requestCode == MY_PERMISSIONS_REQUEST_CALL_PHONE) {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                takePhoto();
//            } else {
//                // Permission Denied
//                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
//            }
//        }
//
//
//        if (requestCode == MY_PERMISSIONS_REQUEST_CALL_PHONE2) {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                choosePhoto();
//            } else {
//                // Permission Denied
//                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
//            }
//        }
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }
}

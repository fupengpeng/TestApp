package com.fpp.androidtestapp.activity.impl.customimageview;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.fpp.androidtestapp.R;
import com.fpp.androidtestapp.customerview.ZQImageViewRoundOval;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author fupengpeng
 * @description 自定义圆形ImageView应用
 * @date 2018/1/8 0008 9:42
 */
public class ImageViewActivity extends AppCompatActivity {

    public static final int REQUEST_CAMERA = 20;


    //圆形图片
    @BindView(R.id.cicle)
    ZQImageViewRoundOval cicle;
    //圆角矩形图片
    @BindView(R.id.roundRect)
    ZQImageViewRoundOval roundRect;
    //椭圆图片
    @BindView(R.id.oval)
    ZQImageViewRoundOval oval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        ButterKnife.bind(this);

        initViews();
    }

    /**
     * 初始化Views
     */
    private void initViews() {

        roundRect.setType(ZQImageViewRoundOval.TYPE_ROUND);
        roundRect.setRoundRadius(20);//矩形凹行大小

        oval.setType(ZQImageViewRoundOval.TYPE_OVAL);
        oval.setRoundRadius(45);// 圆角大小

    }

    @OnClick({R.id.cicle, R.id.roundRect, R.id.oval})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cicle:
                File file=new File(Environment.getExternalStorageDirectory(), "/temp/"+System.currentTimeMillis() + ".jpg");
                if (!file.getParentFile().exists())file.getParentFile().mkdirs();
                Uri imageUri = Uri.fromFile(file);
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);//设置Action为拍照
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);//将拍取的照片保存到指定URI
                startActivityForResult(intent,1006);



                break;
            case R.id.roundRect:

                startActionCapture(this,new File(Environment.getExternalStorageDirectory(), "/tempp/"+System.currentTimeMillis() + ".jpg"),1);

                break;
            case R.id.oval:
                applyWritePermission();

                break;
        }
    }

    /**
     * 打开相机
     *
     * @param activity    Activity
     * @param file        File
     * @param requestCode result requestCode
     */
    public static void startActionCapture(Activity activity, File file, int requestCode) {
        if (activity == null) {
            return;
        }
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, getUriForFile(activity, file));
        activity.startActivityForResult(intent, requestCode);
    }

    private static Uri getUriForFile(Context context, File file) {
        if (context == null || file == null) {
            throw new NullPointerException();
        }
        Uri uri;
        if (Build.VERSION.SDK_INT >= 24) {
            uri = FileProvider.getUriForFile(context.getApplicationContext(), "TestApp.fileprovider", file);
        } else {
            uri = Uri.fromFile(file);
        }
        return uri;
    }





    public void applyWritePermission() {

        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};

        if (Build.VERSION.SDK_INT >= 23) {
            int check = ContextCompat.checkSelfPermission(this, permissions[0]);
            // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝
            if (check == PackageManager.PERMISSION_GRANTED) {
                //调用相机
                useCamera();
            } else {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        } else {
            useCamera();
        }
    }
    /**
     * 使用相机
     */
    File file;
    private void useCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/test/" + System.currentTimeMillis() + ".jpg");
        file.getParentFile().mkdirs();

        //改变Uri  com.fpp.androidtestapp.fileProvider注意和xml中的一致
        Uri uri = FileProvider.getUriForFile(this, "com.fpp.androidtestapp.fileProvider", file);
        //添加权限
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            useCamera();
        } else {
            // 没有获取 到权限，从新请求，或者关闭app
            Toast.makeText(this, "需要存储权限", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Log.e("TAG", "---------" + FileProvider.getUriForFile(this, "com.fpp.androidtestapp.fileProvider", file));
            oval.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
        }
    }


}

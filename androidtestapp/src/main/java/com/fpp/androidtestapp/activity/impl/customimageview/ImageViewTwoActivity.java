package com.fpp.androidtestapp.activity.impl.customimageview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fpp.androidtestapp.R;
import com.fpp.androidtestapp.customerview.RoundImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * @author fupengpeng
 * @description 自定义圆形ImageView，圆角ImageView.
 * @date 2018/1/8 0008 9:43
 */
public class ImageViewTwoActivity extends AppCompatActivity {

    @BindView(R.id.take_photo)
    RoundImageView takePhoto;
    @BindView(R.id.choose_photo)
    RoundImageView choosePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_two);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.take_photo, R.id.choose_photo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.take_photo:
                break;
            case R.id.choose_photo:
                break;
        }
    }
}

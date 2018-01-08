package com.fpp.androidtestapp.activity.impl.imageview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.QuickContactBadge;

import com.fpp.androidtestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author fupengpeng
 * @description ImageView及子类应用
 * @date 2018/1/8 0008 10:50
 */
public class ImageViewActivity extends AppCompatActivity {

    @BindView(R.id.badge)
    QuickContactBadge badge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view2);
        ButterKnife.bind(this);

        badge.assignContactFromPhone("15709203975",false);

    }
}

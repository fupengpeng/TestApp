package com.fpp.androidtestapp.activity.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.fpp.androidtestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author fupengpeng
 * @description 安卓知识点总结
 * @date 2017/12/21 0021 9:24
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv_title_activity_left)
    ImageView ivTitleActivityLeft;

    @BindView(R.id.tv_title_activity_left)
    TextView tvTitleActivityLeft;

    @BindView(R.id.tv_title_activity_title)
    TextView tvTitleActivityTitle;

    @BindView(R.id.tv_title_activity_right)
    TextView tvTitleActivityRight;

    @BindView(R.id.iv_title_activity_right)
    ImageView ivTitleActivityRight;

    @BindView(R.id.lv_activity_main)
    ListView lvActivityMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tvTitleActivityTitle.setText("安卓总结");


    }
}

package com.fpp.androidtestapp.activity.impl.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.fpp.androidtestapp.R;
import com.fpp.androidtestapp.util.ToastUtils;

public class IntentFourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_four);
    }

    public void overrideType(View source) {
        Intent intent = new Intent(this,IntentFourActivity.class);
        // 先设置Type属性
        intent.setType("abc/xyz");
        // 再设置Data属性，此时覆盖了之前设置的Type属性
        intent.setData(Uri.parse("zhi://www.fpp.com:8088/test"));
        ToastUtils.showLong(this,"intent = " + intent.toString());
    }
    public void overrideData(View source) {
        Intent intent = new Intent(this,IntentFourActivity.class);
        // 先设置Data属性
        intent.setData(Uri.parse("zhi://www.fpp.com:8088/test"));
        // 再设置Type属性，此时覆盖了之前设置的Data属性
        intent.setType("abc/xyz");
        ToastUtils.showLong(this,"intent = " + intent.toString());
    }
    public void dataAndType(View source) {
        Intent intent = new Intent(this,IntentFourActivity.class);
        // 同时设置Data属性和Type属性
        intent.setDataAndType(Uri.parse("zhi://www.fpp.com:8088/test"),"abc/xyz");
        ToastUtils.showLong(this,"intent = " + intent.toString());
    }

}

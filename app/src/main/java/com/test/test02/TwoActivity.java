package com.test.test02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.test.fupengpeng.testapp.R;

/**
 * Created by Administrator on 2017/4/18 0018.
 * 接收OneActivity传递过来的数据，并进行展示
 */

public class TwoActivity extends Activity{
    Button twoButton = null;
    TextView textView01 = null;
    TextView textView02 = null;
    String TAG = "TwoActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        twoButton = (Button) findViewById(R.id.two_activity_button01);
        textView01 = (TextView) findViewById(R.id.two_activity_text01);
        textView02 = (TextView) findViewById(R.id.two_activity_text02);
        init();
        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.two_activity_button01:
                        Intent intent = new Intent();
                        Log.e(TAG, "onClick: "+"跳轉至OneActivity");
                        intent.setClass(TwoActivity.this,OneActivity.class);
                        startActivity(intent);  //开始跳转
                        break;
                }
            }
        });

    }
    public void init(){
        Intent intent = this.getIntent();    //获得当前的Intent
        Bundle bundle = intent.getExtras();  //获得全部数据
        Log.e(TAG, "init: "+"接收传递过来的数据并展示");
        String value1 = bundle.getString("name");  //获得名为name的值
        textView01.setText(value1);
        String value2 = bundle.getString("xingbie");
        textView02.setText(value2);
    }
}

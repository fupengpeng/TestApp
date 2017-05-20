package com.test.test03;

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
 */

public class TwoActivity extends Activity{
    Button twoButton = null;
    TextView textView01 = null;
    TextView textView02 = null;
    String TAG = "TwoActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test03_two);
        twoButton = (Button) findViewById(R.id.two_activity_button01);
        textView01 = (TextView) findViewById(R.id.two_activity_text01);
        textView02 = (TextView) findViewById(R.id.two_activity_text02);
//        init();
        init02();
//        init03();

    }
    public void init02(){
        Intent intent = new Intent();  //创建一个Intent
        intent.putExtra("response", "值来自TwoActivity");
        setResult(300,intent);  //返回码为200
        finish();
    }
    public void init(){
        Intent intent = this.getIntent();    //获得当前的Intent
        Bundle bundle = intent.getExtras();  //获得全部数据
        String value1 = bundle.getString("name");  //获得名为name的值
        textView01.setText(value1);
        String value2 = bundle.getString("xingbie");
        textView02.setText(value2);
    }
    public void init03(){
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

}

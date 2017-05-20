package com.test.test02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.test.fupengpeng.testapp.R;

/**
 * Created by Administrator on 2017/4/18 0018.
 * 设置数据，准备传递给TwoActivity
 */

public class OneActivity extends Activity{
    TextView textView = null;
    String TAG = "OneActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        Log.e(TAG, "onCreate: "+"進入OneActivity");
        textView = (TextView) findViewById(R.id.one_activity_button01);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.one_activity_button01:
                        Intent intent = new Intent();
                        Log.e(TAG, "onClick: "+"跳轉至TwoActivity");
                        intent.setClass(OneActivity.this,TwoActivity.class);
                        intent.putExtra("name", "xiazdong");  //放入数据
                        intent.putExtra("xingbie","nan");
                        startActivity(intent);

                        break;
                }
            }
        });
    }
}

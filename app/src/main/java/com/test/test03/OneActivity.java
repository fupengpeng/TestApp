package com.test.test03;

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
 * 点击按钮之后，展示从TwoActivity获取到的数据
 *     根据请求码和返回码的标记来传递获取数据
 */

public class OneActivity extends Activity{
    TextView textView = null;
    TextView textView02 = null;
    String TAG = "OneActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test03_one);
        Log.e(TAG, "onCreate: "+"進入OneActivity");
        textView = (TextView) findViewById(R.id.one_activity_button01);
        textView02 = (TextView) findViewById(R.id.one_activity_button02);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.one_activity_button01:
                        Intent intent = new Intent();
                        intent.setClass(OneActivity.this,TwoActivity.class);

                        Bundle bundle = new Bundle();

                        //将网络请求获取到的分类对象传递给ScreenActivity用于展示数据
                        bundle.putSerializable("classification", "ff");
                        intent.putExtras(bundle);

                        startActivityForResult(intent, 500); //requestcode=100
                        break;
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==500&&resultCode==300){
            Bundle bundle = data.getExtras();
            String response = bundle.getString("response");
            textView02.setText(response);
        }

    }
}

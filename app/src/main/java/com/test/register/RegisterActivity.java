package com.test.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.test.fupengpeng.testapp.R;


/**
 * Created by Administrator on 2017/4/18 0018.
 */

public class RegisterActivity extends Activity {
    TextView textViewRegister01;
    Button buttonRegister01;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        textViewRegister01 = (TextView) findViewById(R.id.text_register_01);
        buttonRegister01 = (Button) findViewById(R.id.button_register_01);
        buttonRegister01.setOnClickListener(new MyClickListener());
        textViewRegister01.setOnClickListener(new MyClickListener());
    }
    class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button_register_01:
                    Toast.makeText(RegisterActivity.this, "点击注册按钮",Toast.LENGTH_LONG).show();
                    break;
                case R.id.text_register_01:
                    Intent intent = new Intent();
                    intent.setClass(RegisterActivity.this,LoginActivity.class);
                    Toast.makeText(RegisterActivity.this, "点击返回按钮，返回登录页面",Toast.LENGTH_LONG).show();
                    startActivity(intent);
                    break;
                default:
                    break;
            }
        }
    }
}

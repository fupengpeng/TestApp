package com.test.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.test.fupengpeng.testapp.R;

/**
 * Created by Administrator on 2017/4/18 0018.
 */

public class LoginActivity extends Activity {
    TextView textViewLogin01;
    TextView textViewLogin02;
    TextView textViewLogin03;
    Button buttonLogin01;
    Spinner spinner01;
    EditText editTextAccount01;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        textViewLogin01 = (TextView) findViewById(R.id.text_login_01);
        textViewLogin02 = (TextView) findViewById(R.id.text_login_02);
        textViewLogin03 = (TextView) findViewById(R.id.text_login_03);
        buttonLogin01 = (Button) findViewById(R.id.button_login_01);
        spinner01 = (Spinner) findViewById(R.id.spinner_login_01);
        editTextAccount01 = (EditText) findViewById(R.id.editText_login_account);
        spinner01.setOnItemSelectedListener(new MyOnItemSelectedListener());
        textViewLogin01.setOnClickListener(new MyOnClickListener());
        textViewLogin02.setOnClickListener(new MyOnClickListener());
        textViewLogin03.setOnClickListener(new MyOnClickListener());
        buttonLogin01.setOnClickListener(new MyOnClickListener());

    }
    class MyOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String[] account = getResources().getStringArray(R.array.account);
            Toast.makeText(LoginActivity.this, "你点击的是:"+account[position],Toast.LENGTH_LONG).show();
            editTextAccount01.setText(account[position]);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
    class MyOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button_login_01:
                    Toast.makeText(LoginActivity.this, "点击登录按钮",Toast.LENGTH_LONG).show();

                    break;
                case R.id.text_login_01:
                    Toast.makeText(LoginActivity.this, "点击忘记密码按钮",Toast.LENGTH_LONG).show();
                    break;
                case R.id.text_login_02:
                    Intent intent = new Intent();
                    intent.setClass(LoginActivity.this,RegisterActivity.class);
                    Toast.makeText(LoginActivity.this, "点击注册账号按钮",Toast.LENGTH_LONG).show();
                    startActivity(intent);
                    break;
                case R.id.text_login_03:
                    Toast.makeText(LoginActivity.this, "点击取消登录按钮",Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}

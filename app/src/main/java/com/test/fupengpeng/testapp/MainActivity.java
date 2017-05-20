package com.test.fupengpeng.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    public Button my_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        Log.e(TAG, "init: ");
        my_button = (Button) findViewById(R.id.two_activity_button01);
        my_button.setText("点击跳转至下一页面");
        my_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
//        Intent intent = new Intent();
    }
}
package com.test.test01;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.test.fupengpeng.testapp.R;


/**
 * Created by Administrator on 2017/4/18 0018.
 */

public class Activity1 extends Activity{
    Button btnToInternalActivity;
    Button btnToExternalActivity_01;
    EditText tbBundle;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Activity1", "onCreate");//显示当前状态，onCreate与onDestroy对应
        setContentView(R.layout.main1);

        btnToInternalActivity=(Button)this.findViewById(R.id.main1_Button01);
        btnToExternalActivity_01 =(Button)this.findViewById(R.id.main1_Button02);
        btnToInternalActivity.setOnClickListener(new ClickEvent());
        btnToExternalActivity_01.setOnClickListener(new ClickEvent());
        tbBundle=(EditText)this.findViewById(R.id.EditText01);
    }
    public void onDestroy()
    {
        super.onDestroy();
        Log.e("Activity1", "onDestroy");//显示当前状态，onCreate与onDestroy对应
    }
    @Override
    public void onStart()
    {
        super.onStart();
        Log.e("Activity1", "onStart");//显示当前状态，onStart与onStop对应
    }
    @Override
    public void onStop()
    {
        super.onStop();
        Log.e("Activity1", "onStop");//显示当前状态，onStart与onStop对应
    }
    @Override
    public void onRestart()
    {
        super.onRestart();
        Log.e("Activity1", "onRestart");
    }
    @Override
    public void onResume()
    {
        super.onResume();
        Log.e("Activity1", "onResume");//显示当前状态，onPause与onResume对应
        SharedPreferences prefs = getPreferences(0); //SharedPreferences 用于存储数据
        String restoredText = prefs.getString("editText01", null);
        if (restoredText != null) {
            this.tbBundle.setText(restoredText);
        }
    }
    @Override
    public void onPause()
    {
        super.onResume();
        Log.e("Activity1", "onPause");//显示当前状态，onPause与onResume对应
        //保存文本框的内容，使得重回本Acitivity的时候可以恢复
        SharedPreferences.Editor editor = getPreferences(0).edit();//SharedPreferences 用于存储数据
        editor.putString("editText01", this.tbBundle.getText().toString());
        editor.commit();
    }

    class ClickEvent implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(v==btnToInternalActivity) {
                Intent intent = new Intent();
                intent.setClass(Activity1.this,Activity2.class);

                //new一个Bundle对象，并将要传递的数据传入
                Bundle bundle = new Bundle();
                bundle.putString("Text",tbBundle.getText().toString());

                //将Bundle对象assign给Intent
                intent.putExtras(bundle);

                //调用Activity2
                startActivity(intent);

                Activity1.this.finish();//会触发onDestroy();
            }
            else if(v== btnToExternalActivity_01)
            {
                //有些外部调用需要开启权限
                Uri uri = Uri.parse("https://www.baidu.com");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }

        }

    }
}

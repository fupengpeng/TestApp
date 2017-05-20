package com.test.test01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.test.fupengpeng.testapp.R;


/**
 * Created by Administrator on 2017/4/18 0018.
 */

public class Activity2 extends Activity{
    Button btnBackMain1;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.e("Activity2", "onCreate");//显示当前状态，onCreate与onDestroy对应

        //加载activity2.xml
        setContentView(R.layout.main2);

        //得Intent中的Bundle对象
        Bundle bunde = this.getIntent().getExtras();
        //取得Bundle对象中的数据
        Log.i("In_Text", bunde.getString("Text"));
        btnBackMain1=(Button)this.findViewById(R.id.main2_Button01);
        btnBackMain1.setOnClickListener(new ClickEvent());
    }

    public void onDestroy()
    {
        super.onDestroy();
        Log.e("Activity2", "onDestroy");//显示当前状态，onCreate与onDestroy对应
    }
    @Override
    public void onStart()
    {
        super.onStart();
        Log.e("Activity2", "onStart");//显示当前状态，onStart与onStop对应
    }
    @Override
    public void onStop()
    {
        super.onStop();
        Log.e("Activity2", "onStop");//显示当前状态，onStart与onStop对应
    }
    @Override
    public void onRestart()
    {
        super.onRestart();
        Log.e("Activity2", "onRestart");
    }
    @Override
    public void onResume()
    {
        super.onResume();
        Log.e("Activity2", "onResume");//显示当前状态，onPause与onResume对应
    }
    @Override
    public void onPause()
    {
        super.onResume();
        Log.e("Activity2", "onPause");//显示当前状态，onPause与onResume对应
    }

    class ClickEvent implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(v==btnBackMain1)
            {

                Intent intent = new Intent();
                intent.setClass(Activity2.this,Activity1.class);

                //调用Activity1
                startActivity(intent);

                Activity2.this.finish();//会触发onDestroy();
            }

        }

    }
}

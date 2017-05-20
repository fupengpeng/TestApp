package com.test.customviewgroup;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.test.fupengpeng.testapp.R;

public class CustomeViewGroupActivity extends Activity
{
    private static final String TAG = "CustomeViewGroupActivity";

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custome_view_group);
        textView = (TextView) findViewById(R.id.text001);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomeViewGroupActivity.this,"点击工程师按钮变色",Toast.LENGTH_LONG);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        Log.e(TAG, "onCreate: "+"什么东西？？" );

        return true;
    }

}

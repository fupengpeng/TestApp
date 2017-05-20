package com.test.test04;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.test.fupengpeng.testapp.R;

/**
 * Created by Administrator on 2017/4/18 0018.
 * 展示图片跟随手指移动的效果
 */

public class OneActivity extends Activity{
    String TAG = "OneActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.one_activity_framelayout01);

        final RabbitView rabbitView = new RabbitView(this);
        rabbitView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                rabbitView.bitmapX = event.getX();
                rabbitView.bitmapY = event.getY();
                rabbitView.invalidate();
                return true;
            }
        });
        frameLayout.addView(rabbitView);

    }
}

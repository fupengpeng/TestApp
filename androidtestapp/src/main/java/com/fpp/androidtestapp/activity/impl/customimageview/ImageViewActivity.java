package com.fpp.androidtestapp.activity.impl.customimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fpp.androidtestapp.R;
import com.fpp.androidtestapp.customerview.ZQImageViewRoundOval;

public class ImageViewActivity extends AppCompatActivity {




    private ZQImageViewRoundOval iv_circle;//圆形图片
    private ZQImageViewRoundOval iv_roundRect;//圆角矩形图片
    private ZQImageViewRoundOval iv_oval;//椭圆图片
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        initViews();
    }
    /**
     * 初始化Views
     */
    private void initViews(){
        iv_circle = (ZQImageViewRoundOval)findViewById(R.id.cicle);
        iv_roundRect = (ZQImageViewRoundOval)findViewById(R.id.roundRect);
        iv_oval = (ZQImageViewRoundOval)findViewById(R.id.oval);


        iv_roundRect.setType(ZQImageViewRoundOval.TYPE_ROUND);
        iv_roundRect.setRoundRadius(20);//矩形凹行大小

        iv_oval.setType(ZQImageViewRoundOval.TYPE_OVAL);
        iv_oval.setRoundRadius(45);// 圆角大小

    }
}

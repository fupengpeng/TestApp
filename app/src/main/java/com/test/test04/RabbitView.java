package com.test.test04;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.test.fupengpeng.testapp.R;

/**
 * Created by Administrator on 2017/4/18 0018.
 */

public class RabbitView extends View {
    public float bitmapX;
    public float bitmapY;
    public RabbitView(Context context) {
        super(context);
        bitmapX = 750;
        bitmapY = 400;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.mao);
        canvas.drawBitmap(bitmap,bitmapX,bitmapY,paint);
        if (bitmap.isRecycled()){
            bitmap.recycle();
        }
    }
}

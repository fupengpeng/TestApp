package com.fpp.androidtestapp.activity.impl.adapterview;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.fpp.androidtestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterViewFlipperActivity extends AppCompatActivity {

    int[] imageIds = new int[]{
            R.drawable.task_no_bg_1,
            R.drawable.task_no_bg_2,
            R.drawable.task_no_bg_3
    };
    @BindView(R.id.flipper)
    AdapterViewFlipper flipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_flipper);
        ButterKnife.bind(this);

        AVFAdapter avfAdapter = new AVFAdapter();
        flipper.setAdapter(avfAdapter);

    }

    public void prev(View source) {
        flipper.showPrevious();
        flipper.stopFlipping();
    }

    public void next(View source) {
        flipper.showNext();
        flipper.stopFlipping();
    }

    public void auto(View source) {
        flipper.startFlipping();
    }

    class AVFAdapter extends BaseAdapter {

        public AVFAdapter() {
        }

        @Override
        public int getCount() {
            return imageIds.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(AdapterViewFlipperActivity.this);
            imageView.setImageResource(imageIds[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);  // 设置缩放类型
            imageView.setLayoutParams(
                    new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return imageView;
        }
    }
}

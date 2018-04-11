package com.fpp.androidtestapp.activity.impl.adapterview;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.StackView;

import com.fpp.androidtestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StackViewActivity extends AppCompatActivity {


    @BindView(R.id.mStackView)
    StackView mStackView;

    int[] imageIds = new int[]{
            R.drawable.task_no_bg_1,
            R.drawable.task_no_bg_2,
            R.drawable.task_no_bg_3
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_view);
        ButterKnife.bind(this);

        AVFAdapter avfAdapter = new AVFAdapter();
        mStackView.setAdapter(avfAdapter);

    }

    public void prev(View source) {
        mStackView.showPrevious();
    }

    public void next(View source) {
        mStackView.showNext();
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
            ImageView imageView = new ImageView(StackViewActivity.this);
            imageView.setImageResource(imageIds[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);  // 设置缩放类型
            imageView.setLayoutParams(
                    new ActionBar.LayoutParams(100, 100));
            return imageView;
        }
    }
}

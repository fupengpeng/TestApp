package com.fpp.androidtestapp.activity.impl.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fpp.androidtestapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewActivity extends AppCompatActivity {


    @BindView(R.id.iv_title_activity_left)
    ImageView ivTitleActivityLeft;
    @BindView(R.id.tv_title_activity_title)
    TextView tvTitleActivityTitle;
    @BindView(R.id.iv_title_activity_right)
    ImageView ivTitleActivityRight;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private List<String> mDatas;
    private HomeAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
        tvTitleActivityTitle.setText("RecyclerView");

        initData();
        //效果一
//        recyclerview.setLayoutManager(new LinearLayoutManager(this));
//        recyclerview.setAdapter(mAdapter = new HomeAdapter());
//        recyclerview.addItemDecoration(new DividerItemDecoration(this,
//                DividerItemDecoration.VERTICAL_LIST));

        //效果二
//        recyclerview.setLayoutManager(new GridLayoutManager(this,4));
//        recyclerview.setAdapter(mAdapter = new HomeAdapter());
//        recyclerview.addItemDecoration(new DividerGridItemDecoration(this));

        //效果三
        recyclerview.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
//        recyclerview.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL));
        recyclerview.setAdapter(mAdapter = new HomeAdapter());
        recyclerview.addItemDecoration(new DividerGridItemDecoration(this));


    }

    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    RecyclerViewActivity.this).inflate(R.layout.recycler_view_item_recycler_view, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(mDatas.get(position));
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.id_num);
            }
        }
    }


}

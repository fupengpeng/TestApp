package com.fpp.androidtestapp.activity.impl.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fpp.androidtestapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author fupengpeng
 * @description RecycleView实现横向ListView
 * @date 2018/2/5 0005 17:06
 */
public class RcyclerViewHorizontalActivity extends AppCompatActivity {


    @BindView(R.id.recycler_view_horizontal)
    RecyclerView recyclerViewHorizontal;
    private List<String> mDatas;

    private MyAdapter adapter;


    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcycler_view_horizontal);
        ButterKnife.bind(this);

        initData();
        initView();


    }

    private void initView() {

        // 初始化布局管理器
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        // 初始化适配器
        adapter = new MyAdapter(mDatas);

        // 设置布局管理器
        recyclerViewHorizontal.setLayoutManager(mLayoutManager);
        // 设置adapter
        recyclerViewHorizontal.setAdapter(adapter);
        // 设置Item之间间隔样式
        recyclerViewHorizontal.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.HORIZONTAL));


    }

    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }
}

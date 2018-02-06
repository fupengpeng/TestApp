package com.fpp.androidtestapp.activity.impl.recyclerview;

import android.content.Intent;
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
import android.widget.Toast;

import com.fpp.androidtestapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecyclerViewActivity extends AppCompatActivity {


    @BindView(R.id.iv_title_activity_left)
    ImageView ivTitleActivityLeft;
    @BindView(R.id.tv_title_activity_title)
    TextView tvTitleActivityTitle;
    @BindView(R.id.iv_title_activity_right)
    ImageView ivTitleActivityRight;
    @BindView(R.id.recyclerview01)
    RecyclerView recyclerview01;
    @BindView(R.id.recyclerview02)
    RecyclerView recyclerview02;
    @BindView(R.id.recyclerview03)
    RecyclerView recyclerview03;
    @BindView(R.id.recyclerview04)
    RecyclerView recyclerview04;
    @BindView(R.id.recyclerview05)
    LeftSwipeMenuRecyclerView recyclerview05;
    @BindView(R.id.recyclerview06)
    RecyclerView recyclerview06;
    @BindView(R.id.recyclerview07)
    RecyclerView recyclerview07;
    @BindView(R.id.tv_recycle_view_horizontal)
    TextView tvRecycleViewHorizontal;
    private List<String> mDatas;

    private HomeAdapter mAdapter;

    private MyAdapter adapter;

    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
        tvTitleActivityTitle.setText("RecyclerView");

        initData();

        /*

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // 设置布局管理器
        mRecyclerView.setLayoutManager(mLayoutManager);
        // 设置adapter
        mRecyclerView.setAdapter(mAdapter);
        // 设置Item添加和移除的动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // 设置Item之间间隔样式
        mRecyclerView.addItemDecoration(mDividerItemDecoration);

        */


        //效果一：基本ListView
        initView01();


        //效果二：基本GridView
        initView02();

        //效果三：同效果二
        initView03();

        //效果四：同效果二
        initView04();

        //效果五：滑动点击事件
        initView05();

        //效果六：同效果一
        initView06();


        //效果七：横向ListView
        initView07();


    }

    private void initView05() {
        /**
         * 商品显示列表格式
         */
        boolean commodity_list = false;
        List<Message> messageList = new ArrayList<Message>();
        for (int i = 0; i < 20; i++) {
            Message message = new Message();
            message.setId(i);
            message.setFid("fid" + i);
            message.setName("name" + i);
            messageList.add(message);
        }
        LeftSwipeMenuRecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        recyclerview05.setLayoutManager(layoutManager);

        RVAdapter adapters = new RVAdapter(this, messageList, commodity_list);
        recyclerview05.setAdapter(adapters);
    }

    private void initView04() {
        recyclerview04.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
//        recyclerview03.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL));
        recyclerview04.setAdapter(mAdapter = new HomeAdapter());
        recyclerview04.addItemDecoration(new DividerGridItemDecoration(this));
    }

    private void initView03() {
        recyclerview03.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerview03.setAdapter(mAdapter = new HomeAdapter());
        recyclerview03.addItemDecoration(new DividerGridItemDecoration(this));
    }

    private void initView02() {
        //设置布局管理器
        recyclerview02.setLayoutManager(new GridLayoutManager(this, 4));  // 4 : 列数
        //设置数据
        recyclerview02.setAdapter(mAdapter = new HomeAdapter());
        //设置分割线
        recyclerview02.addItemDecoration(new DividerGridItemDecoration(this));
    }

    private void initView01() {
        //设置布局管理器
        recyclerview01.setLayoutManager(new LinearLayoutManager(this));
        //设置数据
        recyclerview01.setAdapter(mAdapter = new HomeAdapter());
        //设置分割线
        recyclerview01.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));
    }

    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }


    private void initView06() {
        //初始化布局管理器
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = new MyAdapter(mDatas);

        // 设置布局管理器
        recyclerview06.setLayoutManager(mLayoutManager);
        // 设置adapter
        recyclerview06.setAdapter(mAdapter);
        recyclerview06.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecyclerViewActivity.this, "click " + position + " item", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(RecyclerViewActivity.this, "long click " + position + " item", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView07() {
        // 初始化布局管理器
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        // 初始化适配器
        adapter = new MyAdapter(mDatas);

        // 设置布局管理器
        recyclerview07.setLayoutManager(mLayoutManager);
        // 设置adapter
        recyclerview07.setAdapter(mAdapter);
        // 设置Item之间间隔样式
        recyclerview07.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.HORIZONTAL));


    }

    @OnClick(R.id.tv_recycle_view_horizontal)
    public void onViewClicked() {

//        Intent intent = new Intent(this,RcyclerViewHorizontalActivity.class);
//        startActivity(intent);

        Intent intent = new Intent(this, LVOrRCVActivity.class);
        startActivity(intent);


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

package com.fpp.androidtestapp.activity.impl.order;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.fpp.androidtestapp.R;
import com.fpp.androidtestapp.activity.impl.BaseActivity;
import com.fpp.androidtestapp.activity.impl.MainActivity;
import com.fpp.androidtestapp.activity.view.order.IServiceOrderView;
import com.fpp.androidtestapp.adapter.order.ServiceOrderPagerAdapter;
import com.fpp.androidtestapp.entity.LoadOrderListResponseData;
import com.fpp.androidtestapp.fragment.impl.order.AllFragment;
import com.fpp.androidtestapp.fragment.impl.order.AlreadyAccomplishFragment;
import com.fpp.androidtestapp.fragment.impl.order.AlreadyCancelFragment;
import com.fpp.androidtestapp.fragment.impl.order.UnderwayFragment;
import com.fpp.androidtestapp.fragment.impl.order.WaitAcceptFragment;
import com.fpp.androidtestapp.presenter.factory.order.ServiceOrderViewPresenterFactory;
import com.fpp.androidtestapp.presenter.interf.order.IServiceOrderViewPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * @description  服务单页面
 * @author  fupengpeng
 * @date  2017/12/20 0020 19:50
 */

public class ServiceOrderActivity extends BaseActivity implements IServiceOrderView {


    /**
     * 返回主页面
     */
    @BindView(R.id.iv_title_activity_left)
    ImageView ivTitleActivityLeft;
    /**
     * 标题
     */
    @BindView(R.id.tv_title_activity_title)
    TextView tvTitleActivityTitle;
    /**
     * 页面viewpager
     */
    @BindView(R.id.iv_atvt_service_order_viewpager)
    ViewPager ivAtvtServiceOrderViewpager;
    /**
     * 服务单选项栏
     */
    @BindView(R.id.tl_atvt_service_order_tab)
    TabLayout tlAtvtServiceOrderTab;


    /**
     * 主导器
     */
    private IServiceOrderViewPresenter presenter;

    /**
     * 标题数据
     */
    private List<String> titleList;

    /**
     * Fragment数据
     */
    private List<Fragment> fragmentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_service_order);
        // 初始化标题栏
        tvTitleActivityTitle.setText("服务单");

        presenter = ServiceOrderViewPresenterFactory.newInstance(this);

        // 初始化界面
        initView();

    }


    private void initView() {

        presenter.loadOrderList(0, 1, 10);

        // 实例化对象
        fragmentList = new ArrayList<Fragment>();

        // 创建Fragment数据源
        AllFragment allFragment = new AllFragment();
        WaitAcceptFragment waitAcceptFragment = new WaitAcceptFragment();
        UnderwayFragment underwayFragment = new UnderwayFragment();
        AlreadyAccomplishFragment alreadyAccomplishFragment = new AlreadyAccomplishFragment();
        AlreadyCancelFragment alreadyCancelFragment = new AlreadyCancelFragment();


        // 设置Fragment数据源
        fragmentList.add(allFragment);
        fragmentList.add(waitAcceptFragment);
        fragmentList.add(underwayFragment);
        fragmentList.add(alreadyAccomplishFragment);
        fragmentList.add(alreadyCancelFragment);


        //设置标题数据
        titleList = new ArrayList<String>();
        titleList.add("全部");
        titleList.add("待接单");
        titleList.add("进行中");
        titleList.add("已完成");
        titleList.add("已取消");


        ServiceOrderPagerAdapter serviceOrderPagerAdapter = new ServiceOrderPagerAdapter(getSupportFragmentManager(), titleList, fragmentList);
        ivAtvtServiceOrderViewpager.setAdapter(serviceOrderPagerAdapter);
        //为TabLayout设置ViewPager
        tlAtvtServiceOrderTab.setupWithViewPager(ivAtvtServiceOrderViewpager);
        //使用ViewPager的适配器
        tlAtvtServiceOrderTab.setTabsFromPagerAdapter(serviceOrderPagerAdapter);


    }


    /**
     * 返回主页面
     */
    @OnClick(R.id.iv_title_activity_left)
    public void returnMainActivity() {
        startActivity(MainActivity.class);
        finish();
    }

    /**
     * 导航栏返回键监听事件
     * 注意:
     * super.onBackPressed()会自动调用finish()方法,关闭
     * 当前Activity.
     * 若要屏蔽Back键盘,注释该行代码即可
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(MainActivity.class);
        finish();
    }


    /**
     * 服务单请求数据
     *
     * @param state 状态：1.待结单，2.服务中，8.已完成,9.已取消
     * @param data  响应数据
     */
    @Override
    public void onLoadOrderListSuccess(int state, LoadOrderListResponseData data) {

    }

    /**
     * @param e 失败信息
     */
    @Override
    public void onLoadDataFail(Exception e) {

    }

}

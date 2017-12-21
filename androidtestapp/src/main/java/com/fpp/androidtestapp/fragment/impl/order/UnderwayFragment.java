package com.fpp.androidtestapp.fragment.impl.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.fpp.androidtestapp.R;
import com.fpp.androidtestapp.adapter.order.UnderwayServiceOrderListAdapter;
import com.fpp.androidtestapp.entity.LoadOrderListResponseData;
import com.fpp.androidtestapp.entity.OrderItem;
import com.fpp.androidtestapp.fragment.impl.BaseFragment;
import com.fpp.androidtestapp.fragment.view.order.IUnderwayFragmentView;
import com.fpp.androidtestapp.presenter.factory.order.UnderwayViewPresenterFactory;
import com.fpp.androidtestapp.presenter.interf.order.IUnderwayViewPresenter;
import com.fpp.androidtestapp.util.InfoUtils;
import com.fpp.androidtestapp.util.LogUtils;
import com.fpp.androidtestapp.util.PullToRefreshUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @description  进行中
 * @author  fupengpeng
 * @date  2017/12/21 0021 9:00
 */

public class UnderwayFragment extends BaseFragment implements IUnderwayFragmentView {


    /**
     * 数据源
     */
    List<OrderItem> list;


    /**
     * 当前页或者要显示的页
     */
    private int currentPage = 1;

    /**
     * 总页数
     */
    private int totalPage = 0;

    /**
     * 进行中订单列表
     */
    @BindView(R.id.lv_fragment_underway_list)
    PullToRefreshListView lvFragmentUnderwayList;

    /**
     * 空数据提示
     */
    @BindView(R.id.tv_fragment_underway_empty)
    TextView tvFragmentUnderwayEmpty;

    /**
     * 主导器
     */
    private IUnderwayViewPresenter presenter;

    /**
     * Adapter
     */
    private UnderwayServiceOrderListAdapter underwayServiceOrderListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState, R.layout.fragment_underway);
        //主导器
        presenter = UnderwayViewPresenterFactory.newInstance(this);
        // 初始化
        init();
        // 设置监听器
        setListeners();
        return view;
    }

    /**
     * 初始化
     */
    private void init() {
        // 设置加载模式
        PullToRefreshUtils.setPullBoth(lvFragmentUnderwayList);
        // 绑定数据
        bindData();
        // 刷新数据
        refreshData(1);
    }

    /**
     * 绑定数据
     */
    private void bindData() {
        list = new ArrayList<>();
        underwayServiceOrderListAdapter = new UnderwayServiceOrderListAdapter(getActivity(), list);
        lvFragmentUnderwayList.setAdapter(underwayServiceOrderListAdapter);
    }

    /**
     * 刷新数据
     */
    private void refreshData(int page) {
        currentPage = page;

        //加载数据
        presenter.loadOrderList(9, currentPage, 5);

    }

    /**
     * 设置监听器
     */
    private void setListeners() {
        // 刷新监听器
        lvFragmentUnderwayList.setOnRefreshListener(new InnerOnRefreshListener2());
        // 子项点击监听器
        lvFragmentUnderwayList.setOnItemClickListener(new InnerOnItemClickListener());
    }



    /**
     * 刷新监听器
     */
    private class InnerOnRefreshListener2 implements PullToRefreshBase.OnRefreshListener2 {
        @Override
        public void onPullDownToRefresh(PullToRefreshBase refreshView) {
            // 下拉刷新
            refreshData(1);
            LogUtils.e("AlreadyCancelFragment", "下拉刷新: " + "----004");
        }

        @Override
        public void onPullUpToRefresh(PullToRefreshBase refreshView) {

            LogUtils.e("AlreadyCancelFragment", "上拉加载: " + "----005");

            // 判断是否还有更多数据
            if (currentPage >= totalPage) {
                InfoUtils.showInfo(getActivity(), "没有更多数据");
                // 加载完成
                PullToRefreshUtils.refreshComplete(lvFragmentUnderwayList);
                return;
            }
            // 上拉加载
            currentPage++;
            refreshData(currentPage);

        }
    }

    /**
     * 子项点击监听器
     */
    public class InnerOnItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int pos = position - 1;
            Intent intent;
            //根据订单状态确定跳转至那个页面
            if ("服务单详情".equals(list.get(pos).getState())) { // 服务单详情
//                intent = new Intent(getActivity(), OrderParticularsActivity.class);
//                intent.putExtra(Consts.IntentExtraKey.LESSON_ID, list.get(pos).getId());

            } else { // 客单详情
//                intent = new Intent(getActivity(), ClientDetailsActivity.class);
//                intent.putExtra(Consts.IntentExtraKey.MICRO_DETAIL, list.get(pos));
            }
//            startActivity(intent);

        }
    }

    /**
     * 获取数据成功
     *
     * @param state 状态：1.待接单，2.服务中，8.已完成,9.已取消
     * @param data  响应数据
     */
    @Override
    public void onLoadOrderListSuccess(int state, LoadOrderListResponseData data) {

        if (state == 9) {
            totalPage = data.getOrdernum();
            if (currentPage == 1) {
                list.clear();
            }
            list.addAll(data.getList());
            underwayServiceOrderListAdapter.notifyDataSetChanged();

            PullToRefreshUtils.refreshComplete(lvFragmentUnderwayList);
        }

    }

    /**
     * 获取数据失败
     *
     * @param e 失败信息
     */
    @Override
    public void onLoadDataFail(Exception e) {

        LogUtils.e("获取数据失败");
    }

}

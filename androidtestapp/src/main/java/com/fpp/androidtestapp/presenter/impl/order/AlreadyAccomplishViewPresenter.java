package com.fpp.androidtestapp.presenter.impl.order;


import com.fpp.androidtestapp.common.ObjectCallBack;
import com.fpp.androidtestapp.entity.LoadOrderListResponseData;
import com.fpp.androidtestapp.fragment.view.order.IAlreadyAccomplishFragmentView;
import com.fpp.androidtestapp.model.factory.OrderModelFactory;
import com.fpp.androidtestapp.model.interf.IOrderModel;
import com.fpp.androidtestapp.presenter.interf.order.IAlreadyAccomplishViewPresenter;

/**
 * @description  已完成服务单Fragment主导器
 * @author  fupengpeng
 * @date  2017/12/20 0020 20:21
 */

public class AlreadyAccomplishViewPresenter implements IAlreadyAccomplishViewPresenter {

    // 服务单业务
    private IOrderModel orderModel;
    // 已完成服务单界面
    private IAlreadyAccomplishFragmentView alreadyAccomplishFragmentView;

    /**
     * 构造函数
     *
     * @param alreadyAccomplishFragmentView 已完成服务单界面
     */
    public AlreadyAccomplishViewPresenter(IAlreadyAccomplishFragmentView alreadyAccomplishFragmentView) {
        this.alreadyAccomplishFragmentView = alreadyAccomplishFragmentView;
        orderModel = OrderModelFactory.newInstance();
    }

    /**
     * 加载订单列表
     *
     * @param state 状态：1.待结单，2.服务中，8.已完成,9.已取消
     * @param page  页码
     * @param count 每页返回结果数量
     */
    @Override
    public void loadOrderList(final int state, int page, int count) {
        orderModel.loadOrderList(state, page, count,
                new ObjectCallBack<LoadOrderListResponseData>() {
                    @Override
                    public void onSuccess(LoadOrderListResponseData data) {
                        // 通知界面
                        alreadyAccomplishFragmentView.onLoadOrderListSuccess(state, data);
                    }

                    @Override
                    public void onFail(Exception e) {
                        // 通知界面
                        alreadyAccomplishFragmentView.onLoadDataFail(e);
                    }
                }
        );
    }


}

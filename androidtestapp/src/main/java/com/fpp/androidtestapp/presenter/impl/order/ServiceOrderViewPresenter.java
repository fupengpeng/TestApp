package com.fpp.androidtestapp.presenter.impl.order;

import com.fpp.androidtestapp.activity.view.order.IServiceOrderView;
import com.fpp.androidtestapp.common.ObjectCallBack;
import com.fpp.androidtestapp.entity.LoadOrderListResponseData;
import com.fpp.androidtestapp.model.factory.OrderModelFactory;
import com.fpp.androidtestapp.model.interf.IOrderModel;
import com.fpp.androidtestapp.presenter.interf.order.IServiceOrderViewPresenter;

/**
 * @description  服务单界面主导器
 * @author  fupengpeng
 * @date  2017/12/21 0021 9:02
 */

public class ServiceOrderViewPresenter implements IServiceOrderViewPresenter {
    // 订单业务
    private IOrderModel orderModel;
    // 服务单界面
    private IServiceOrderView serviceOrderView;

    /**
     * 构造函数
     *
     * @param serviceOrderView 服务单界面
     */
    public ServiceOrderViewPresenter(IServiceOrderView serviceOrderView) {
        this.serviceOrderView = serviceOrderView;
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
                        serviceOrderView.onLoadOrderListSuccess(state, data);
                    }

                    @Override
                    public void onFail(Exception e) {
                        // 通知界面
                        serviceOrderView.onLoadDataFail(e);
                    }
                }
        );
    }

}

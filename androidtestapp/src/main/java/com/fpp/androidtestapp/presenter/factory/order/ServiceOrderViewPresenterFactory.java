package com.fpp.androidtestapp.presenter.factory.order;

import com.fpp.androidtestapp.activity.view.order.IServiceOrderView;
import com.fpp.androidtestapp.presenter.impl.order.ServiceOrderViewPresenter;
import com.fpp.androidtestapp.presenter.interf.order.IServiceOrderViewPresenter;

/**
 * 服务单界面主导器工厂
 */
public class ServiceOrderViewPresenterFactory {
    /**
     * 创建服务单界面主导器对象
     *
     * @param serviceOrderView 服务单界面
     * @return 服务单界面主导器对象
     */
    public static IServiceOrderViewPresenter newInstance(IServiceOrderView serviceOrderView) {
        return new ServiceOrderViewPresenter(serviceOrderView);
    }

}

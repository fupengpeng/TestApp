package com.fpp.androidtestapp.model.factory;


import com.fpp.androidtestapp.model.impl.OrderModel;
import com.fpp.androidtestapp.model.interf.IOrderModel;

/**
 * 服务单业务工厂
 */
public class OrderModelFactory {

    /**
     * 服务单业务实例
     *
     * @return 服务单业务实例
     */
    public static IOrderModel newInstance() {
        return new OrderModel();
    }
}

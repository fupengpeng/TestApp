package com.fpp.androidtestapp.presenter.interf.order;

/**
 * @description  服务单Activity界面主导器
 * @author  fupengpeng
 * @date  2017/12/21 0021 9:07
 */
public interface IServiceOrderViewPresenter {
    /**
     * 加载订单列表
     *
     * @param state 状态：1.待结单，2.服务中，8.已完成,9.已取消
     * @param page  页码
     * @param count 每页返回结果数量
     */
    void loadOrderList(int state, int page, int count);
}

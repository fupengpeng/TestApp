package com.fpp.androidtestapp.presenter.factory.order;


import com.fpp.androidtestapp.fragment.view.order.IAlreadyAccomplishFragmentView;
import com.fpp.androidtestapp.presenter.impl.order.AlreadyAccomplishViewPresenter;
import com.fpp.androidtestapp.presenter.interf.order.IAlreadyAccomplishViewPresenter;

/**
 * 已完成服务单Fragment主导器工厂
 */

public class AlreadyAccomplishViewPresenterFactory {
    /**
     * 已完成服务单Fragment界面主导器对象
     *
     * @param alreadyAccomplishFragmentView 已完成服务单 界面
     * @return 已完成服务单界面主导器对象
     */
    public static IAlreadyAccomplishViewPresenter newInstance(IAlreadyAccomplishFragmentView alreadyAccomplishFragmentView) {
        return new AlreadyAccomplishViewPresenter(alreadyAccomplishFragmentView);
    }

}

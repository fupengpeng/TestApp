package com.fpp.androidtestapp.presenter.factory.order;


import com.fpp.androidtestapp.fragment.view.order.IUnderwayFragmentView;
import com.fpp.androidtestapp.presenter.impl.order.UnderwayViewPresenter;
import com.fpp.androidtestapp.presenter.interf.order.IUnderwayViewPresenter;

/**
 * 进行中服务单Fragment主导器工厂
 */

public class UnderwayViewPresenterFactory {
    /**
     * 进行中服务单Fragment界面主导器对象
     *
     * @param underwayFragmentView 进行中服务单 界面
     * @return 进行中服务单界面主导器对象
     */
    public static IUnderwayViewPresenter newInstance(IUnderwayFragmentView underwayFragmentView) {
        return new UnderwayViewPresenter(underwayFragmentView);
    }

}

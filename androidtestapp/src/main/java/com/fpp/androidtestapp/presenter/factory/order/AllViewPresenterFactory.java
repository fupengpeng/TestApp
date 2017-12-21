package com.fpp.androidtestapp.presenter.factory.order;

import com.fpp.androidtestapp.fragment.view.order.IAllFragmentView;
import com.fpp.androidtestapp.presenter.impl.order.AllViewPresenter;
import com.fpp.androidtestapp.presenter.interf.order.IAllViewPresenter;

/**
 * 全部服务单Fragment主导器工厂
 */

public class AllViewPresenterFactory {
    /**
     * 全部服务单Fragment界面主导器对象
     *
     * @param allFragmentView 全部服务单 界面
     * @return 全部服务单界面主导器对象
     */
    public static IAllViewPresenter newInstance(IAllFragmentView allFragmentView) {
        return new AllViewPresenter(allFragmentView);
    }

}

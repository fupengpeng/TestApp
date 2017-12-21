package com.fpp.androidtestapp.presenter.factory.order;

import com.fpp.androidtestapp.fragment.view.order.IAlreadyCancelFragmentView;
import com.fpp.androidtestapp.presenter.impl.order.AlreadyCancelViewPresenter;
import com.fpp.androidtestapp.presenter.interf.order.IAlreadyCancelViewPresenter;

/**
 * 已取消服务单Fragment主导器工厂
 */

public class AlreadyCancelViewPresenterFactory {
    /**
     * 已取消服务单Fragment界面主导器对象
     *
     * @param alreadyCancelFragmentView 已取消服务单 界面
     * @return 已取消服务单界面主导器对象
     */
    public static IAlreadyCancelViewPresenter newInstance(IAlreadyCancelFragmentView alreadyCancelFragmentView) {
        return new AlreadyCancelViewPresenter(alreadyCancelFragmentView);
    }

}

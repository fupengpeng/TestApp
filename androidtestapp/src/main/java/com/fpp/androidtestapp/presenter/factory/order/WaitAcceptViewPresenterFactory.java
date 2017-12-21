package com.fpp.androidtestapp.presenter.factory.order;


import com.fpp.androidtestapp.fragment.view.order.IWaitAcceptFragmentView;
import com.fpp.androidtestapp.presenter.impl.order.WaitAcceptViewPresenter;
import com.fpp.androidtestapp.presenter.interf.order.IWaitAcceptViewPresenter;

/**
 * 待接收服务单Fragment主导器工厂
 */

public class WaitAcceptViewPresenterFactory {
    /**
     * 待接收服务单Fragment界面主导器对象
     *
     * @param waitAcceptFragmentView 待接收服务单 界面
     * @return 待接收服务单界面主导器对象
     */
    public static IWaitAcceptViewPresenter newInstance(IWaitAcceptFragmentView waitAcceptFragmentView) {
        return new WaitAcceptViewPresenter(waitAcceptFragmentView);
    }

}

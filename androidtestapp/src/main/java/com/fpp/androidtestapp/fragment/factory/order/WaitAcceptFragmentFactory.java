package com.fpp.androidtestapp.fragment.factory.order;

import com.fpp.androidtestapp.fragment.impl.order.WaitAcceptFragment;
import com.fpp.androidtestapp.fragment.view.order.IWaitAcceptFragmentView;

/**
 * 待接收服务单Fragment工厂
 */

public class WaitAcceptFragmentFactory {
    /**
     * 创建待接收服务单Fragment
     * @return  待接收服务单Fragment实例
     */
    public static IWaitAcceptFragmentView newInstance(){
        return new WaitAcceptFragment();
    }

}

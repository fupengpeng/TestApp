package com.fpp.androidtestapp.fragment.factory.order;

import com.fpp.androidtestapp.fragment.impl.order.AllFragment;
import com.fpp.androidtestapp.fragment.view.order.IAllFragmentView;

/**
 * 全部服务单Fragment工厂
 */

public class AllFragmentFactory {
    /**
     * 创建全部服务单Fragment
     * @return  全部服务单Fragment实例
     */
    public static IAllFragmentView newInstance(){
        return new AllFragment();
    }

}

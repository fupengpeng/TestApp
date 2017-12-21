package com.fpp.androidtestapp.fragment.factory.order;

import com.fpp.androidtestapp.fragment.impl.order.UnderwayFragment;
import com.fpp.androidtestapp.fragment.view.order.IUnderwayFragmentView;

/**
 * 进行中服务单Fragment工厂
 */

public class UnderwayFragmentFactory {
    /**
     * 创建进行中服务单Fragment
     * @return  进行中服务单Fragment实例
     */
    public static IUnderwayFragmentView newInstance(){
        return new UnderwayFragment();
    }

}

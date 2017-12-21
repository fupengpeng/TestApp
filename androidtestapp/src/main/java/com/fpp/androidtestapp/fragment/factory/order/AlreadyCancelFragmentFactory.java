package com.fpp.androidtestapp.fragment.factory.order;

import com.fpp.androidtestapp.fragment.impl.order.AlreadyCancelFragment;
import com.fpp.androidtestapp.fragment.view.order.IAlreadyCancelFragmentView;

/**
 * 已取消服务单Fragment工厂
 */

public class AlreadyCancelFragmentFactory {
    /**
     * 创建已取消服务单Fragment
     * @return  已取消服务单Fragment实例
     */
    public static IAlreadyCancelFragmentView newInstance(){
        return new AlreadyCancelFragment();
    }

}

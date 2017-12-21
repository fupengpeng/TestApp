package com.fpp.androidtestapp.fragment.factory.order;

import com.fpp.androidtestapp.fragment.impl.order.AlreadyAccomplishFragment;
import com.fpp.androidtestapp.fragment.view.order.IAlreadyAccomplishFragmentView;

/**
 * 已完成服务单Fragment工厂
 */

public class AlreadyAccomplishFragmentFactory {
    /**
     * 创建已完成服务单Fragment
     * @return  已完成服务单Fragment实例
     */
    public static IAlreadyAccomplishFragmentView newInstance(){
        return new AlreadyAccomplishFragment();
    }

}

package com.fpp.androidtestapp.model.factory;


import com.fpp.androidtestapp.model.impl.VersionModel;
import com.fpp.androidtestapp.model.interf.IVersionModel;

/**
 * 版本业务工厂
 */
public class VersionModelFactory {

    /**
     * 创建版本业务实例
     *
     * @return 版本业务实例
     */
    public static IVersionModel newInstance() {
        return new VersionModel();
    }
}

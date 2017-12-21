package com.fpp.androidtestapp.model.factory;


import com.fpp.androidtestapp.model.impl.UserModel;
import com.fpp.androidtestapp.model.interf.IUserModel;

/**
 * 用户业务工厂
 */
public class UserModelFactory {

    /**
     * 创建用户业务实例
     *
     * @return 用户业务实例
     */
    public static IUserModel newInstance() {
        return new UserModel();
    }
}

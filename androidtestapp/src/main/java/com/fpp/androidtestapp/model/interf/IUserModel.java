package com.fpp.androidtestapp.model.interf;

import com.fpp.androidtestapp.common.ObjectCallBack;
import com.fpp.androidtestapp.entity.LoginResponseData;

/**
 * 用户业务接口
 */
public interface IUserModel {
    /**
     * 登录
     *
     * @param phoneNumber 手机号
     * @param password    密码
     * @param callBack    回调
     */
    void login(String phoneNumber, String password, final ObjectCallBack<LoginResponseData> callBack);

}

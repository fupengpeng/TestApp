package com.fpp.androidtestapp.presenter.factory.usercenter;

import com.fpp.androidtestapp.activity.view.usercenter.ILoginView;
import com.fpp.androidtestapp.presenter.impl.usercenter.LoginViewPresenter;
import com.fpp.androidtestapp.presenter.interf.usercenter.ILoginViewPresenter;

/**
 * 登录界面主导器工厂
 */
public class LoginViewPresenterFactory {
    /**
     * 创建登录界面主导器对象
     *
     * @param loginView 登录界面
     * @return 登录界面主导器对象
     */
    public static ILoginViewPresenter newInstance(ILoginView loginView) {
        return new LoginViewPresenter(loginView);
    }

}

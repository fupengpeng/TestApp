package com.fpp.androidtestapp.model.impl;

import com.alibaba.fastjson.JSON;
import com.fpp.androidtestapp.common.Consts;
import com.fpp.androidtestapp.common.ObjectCallBack;
import com.fpp.androidtestapp.entity.LoginResponseData;
import com.fpp.androidtestapp.entity.response.LoginResponse;
import com.fpp.androidtestapp.model.interf.IUserModel;
import com.fpp.androidtestapp.util.DateUtils;
import com.fpp.androidtestapp.util.MD5Util;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.rest.SimpleResponseListener;

/**
 * 用户业务
 */
public class UserModel implements IUserModel {
    /**
     * 请求队列
     */
    private static RequestQueue requestQueue = NoHttp.newRequestQueue(3);

    /**
     * 登录
     *
     * @param phoneNumber 手机号
     * @param password    密码
     * @param callBack    回调
     */
    @Override
    public void login(String phoneNumber, String password,
                      final ObjectCallBack<LoginResponseData> callBack) {
        // 创建String请求
        Request<String> request = NoHttp.createStringRequest(Consts.NetUrl.BASE_NET_URL, Consts.NET_REQUEST_METHOD);

        // 添加参数
        request.add("a", "login");
        request.add("shopId", "x");
        request.add("userId", "x");
        request.add("sessionId", "x");
        request.add("token", MD5Util.getMD5("xxxlogin<*?hello.Kaiyuan.com//" + DateUtils.getCurrDate()));
        request.add("mobile", phoneNumber);
        request.add("pwd", password);

        //将request加入requestQueue
        requestQueue.add(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                // 服务器响应码。
                int responseCode = response.getHeaders().getResponseCode();
                // 这里一定要判断状态码，经测试，404错误时也走这个回调方法
                if (responseCode != 200) {
                    // 请求失败
                    Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                    callBack.onFail(e);
                    return;
                }

                // 响应结果。
                String result = response.get();
                // 解析
                LoginResponse loginResponse = JSON.parseObject(result, LoginResponse.class);
                // 判断是否成功
                if (loginResponse.getCode() == 0) { // 成功
                    callBack.onSuccess(loginResponse.getData());
                } else { // 失败
                    Exception e = new Exception(loginResponse.getInfo());
                    callBack.onFail(e);
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                // 请求失败
                Exception e = new Exception(Consts.NET_REQUEST_EXCEPTION);
                callBack.onFail(e);
            }
        });
    }

}

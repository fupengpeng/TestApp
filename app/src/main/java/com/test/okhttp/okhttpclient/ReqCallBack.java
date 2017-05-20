package com.test.okhttp.okhttpclient;

/**
 * Created by Administrator on 2017/4/25 0025.
 */

public interface ReqCallBack<T> {
    /**
     * 响应成功
     */
    void onReqSuccess(T result);

    /**
     * 响应失败
     */
    void onReqFailed(String errorMsg);
}
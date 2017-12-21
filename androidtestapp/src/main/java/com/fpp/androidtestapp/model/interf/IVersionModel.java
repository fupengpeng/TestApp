package com.fpp.androidtestapp.model.interf;

import com.fpp.androidtestapp.common.ObjectCallBack;
import com.fpp.androidtestapp.entity.response.NewVersionResponse;

/**
 * 版本业务
 */
public interface IVersionModel {
    /**
     * 获取最新版本信息
     *
     * @param callBack 回调
     */
    void getNewVersionInfo(final ObjectCallBack<NewVersionResponse> callBack);

    /**
     * 下载APK文件
     *
     * @param what 版本更新Service启动标识
     */
    void downloadAPK(int what);
}

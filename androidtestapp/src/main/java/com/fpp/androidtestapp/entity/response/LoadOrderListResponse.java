package com.fpp.androidtestapp.entity.response;

import com.fpp.androidtestapp.entity.LoadOrderListResponseData;

/**
 * 加载订单列表的响应
 */
public class LoadOrderListResponse extends BaseResponse {
    // 加载订单列表的响应数据
    private LoadOrderListResponseData data;

    public LoadOrderListResponseData getData() {
        return data;
    }

    public void setData(LoadOrderListResponseData data) {
        this.data = data;
    }
}

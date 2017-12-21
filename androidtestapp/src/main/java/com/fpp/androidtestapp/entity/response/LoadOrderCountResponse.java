package com.fpp.androidtestapp.entity.response;


import com.fpp.androidtestapp.entity.ShopStatisticalData;

/**
 * 加载当前门店的统计数据的响应
 */
public class LoadOrderCountResponse extends BaseResponse {
    // 门店统计数据
    private ShopStatisticalData data;

    public ShopStatisticalData getData() {
        return data;
    }

    public void setData(ShopStatisticalData data) {
        this.data = data;
    }
}

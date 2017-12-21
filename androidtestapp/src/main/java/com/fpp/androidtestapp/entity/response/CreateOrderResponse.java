package com.fpp.androidtestapp.entity.response;

/**
 * 创建订单的响应
 */
public class CreateOrderResponse extends BaseResponse{
    // 订单ID
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

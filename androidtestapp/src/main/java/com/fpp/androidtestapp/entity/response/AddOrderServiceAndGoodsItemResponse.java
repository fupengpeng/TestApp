package com.fpp.androidtestapp.entity.response;

/**
 * 添加订单服务项目及商品的响应
 */
public class AddOrderServiceAndGoodsItemResponse extends BaseResponse{
    // 成功信息
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

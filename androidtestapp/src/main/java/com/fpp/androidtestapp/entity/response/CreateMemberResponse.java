package com.fpp.androidtestapp.entity.response;

/**
 * 创建会员的响应
 */
public class CreateMemberResponse extends BaseResponse {
    // 生成的会员ID
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

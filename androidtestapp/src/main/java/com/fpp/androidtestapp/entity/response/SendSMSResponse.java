package com.fpp.androidtestapp.entity.response;

/**
 * 发送验证码的响应
 */
public class SendSMSResponse extends BaseResponse {
    // 成功提示
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

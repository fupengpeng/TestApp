package com.fpp.androidtestapp.entity.response;

/**
 * 上传图片的响应
 */
public class UploadImageResponse extends BaseResponse{
    // 上传后的图片url
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

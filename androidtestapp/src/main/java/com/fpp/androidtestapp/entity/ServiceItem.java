package com.fpp.androidtestapp.entity;

/**
 * 服务项目
 */
public class ServiceItem {
    // 服务ID
    private String serviceitemid;
    // 服务名称
    private String serviceitemname;
    // 服务编号
    private String hotkey;
    // 价格
    private String saleprice;
    // 缩略图
    private String imageurl;
    // 优惠额度
    private String discount;
    // 是否可用
    private boolean enable;
    // 服务次数
    private int num;

    public String getServiceitemid() {
        return serviceitemid;
    }

    public void setServiceitemid(String serviceitemid) {
        this.serviceitemid = serviceitemid;
    }

    public String getServiceitemname() {
        return serviceitemname;
    }

    public void setServiceitemname(String serviceitemname) {
        this.serviceitemname = serviceitemname;
    }

    public String getHotkey() {
        return hotkey;
    }

    public void setHotkey(String hotkey) {
        this.hotkey = hotkey;
    }

    public String getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(String saleprice) {
        this.saleprice = saleprice;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

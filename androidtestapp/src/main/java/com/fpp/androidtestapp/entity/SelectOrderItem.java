package com.fpp.androidtestapp.entity;

/**
 * 选择的品项
 */
public class SelectOrderItem {
    // ID
    private String id;
    // 订单id
    private String oid;
    // 项目类型：1.商品,2.服务
    private int ptype;
    // 项目ID
    private String pid;
    // 数量
    private int num;
    // 原价
    private float cost;
    // 折扣
    private float discount;
    // 售价
    private float price;
    // 计次，如果是计次消费的话
    private int times;
    // 计次ID
    private String timesid;

    public int getPtype() {
        return ptype;
    }

    public void setPtype(int ptype) {
        this.ptype = ptype;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimesid() {
        return timesid;
    }

    public void setTimesid(String timesid) {
        this.timesid = timesid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }
}

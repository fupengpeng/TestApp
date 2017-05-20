package com.test.json.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/28 0028.
 */

public class Weather implements Serializable{
    //  外面大括号的字段封装 setter getter toString
    private  String desc;
    private int status;
    private Data data;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Weather [desc=" + desc + ", status=" + status + ", data="
                + data + "]";
    }
}

package com.test.json.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/28 0028.
 */

public class Forecast  implements Serializable {
    //  数组里面的大括号类型字段的封装
    private String fengxiang;
    private String fengli;
    private String high;
    private String type;
    private String low;
    private String date;

    public String getFengxiang() {
        return fengxiang;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public String getFengli() {
        return fengli;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Forecast [fengxiang=" + fengxiang + ", fengli=" + fengli
                + ", high=" + high + ", type=" + type + ", low=" + low
                + ", date=" + date + "]";
    }
}

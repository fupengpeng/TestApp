package com.test.json.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/28 0028.
 */

public class Yesterday  implements Serializable {
    //   最后{}的字段封装
    private String fl;
    private String fx;
    private String high;
    private String type;
    private String low;
    private String date;

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
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
        return "Yesterday [fl=" + fl + ", fx=" + fx + ", high=" + high
                + ", type=" + type + ", low=" + low + ", date=" + date + "]";
    }
}

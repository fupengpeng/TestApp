package com.test.json.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/4/28 0028.
 */

public class Data  implements Serializable {
    //  里面大括号的字段封装 setter getter toString
//  该类中包含有数组形和对象形，需要一并的封装在里面
    private String wendu;
    private String ganmao;
    private List<Forecast> forecast;
    private Yesterday yesterday;
    private String aqi;
    private String city;

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    public Yesterday getYesterday() {
        return yesterday;
    }

    public void setYesterday(Yesterday yesterday) {
        this.yesterday = yesterday;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Data [wendu=" + wendu + ", ganmao=" + ganmao + ", forecast="
                + forecast + ", yesterday=" + yesterday + ", aqi=" + aqi
                + ", city=" + city + "]";
    }
}

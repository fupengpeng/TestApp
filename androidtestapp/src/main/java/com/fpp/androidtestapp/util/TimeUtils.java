package com.fpp.androidtestapp.util;

import java.util.Calendar;

/**
 * 获取当前的系統時間
 */
public class TimeUtils {
    public static String getTime() {
        Calendar calendar = Calendar.getInstance();
        String year = calendar.get(Calendar.YEAR) + "";
        String month = (calendar.get(Calendar.MONTH) + 1) + "";
        int m = Integer.parseInt(month);
        if (m >=0 && m < 10) {
            month = "0" + month;
        }
        String date = calendar.get(Calendar.DATE) + "";
        int d = Integer.parseInt(date);
        if (d >=0 && d < 10) {
            date = "0" + date;
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append(month);
        buffer.append(date);
        buffer.append(year);
        return buffer.toString();
    }

    public static String getTime1() {
        Calendar calendar = Calendar.getInstance();
        String year = calendar.get(Calendar.YEAR) + "";
        String month = (calendar.get(Calendar.MONTH) + 1) + "";
        int m = Integer.parseInt(month);
        if (m >=0 && m < 10) {
            month = "0" + month;
        }
        String date = calendar.get(Calendar.DATE) + "";
        int d = Integer.parseInt(date);
        if (d >=0 && d < 10) {
            date = "0" + date;
        }
        String hour = calendar.get(Calendar.HOUR) + "";
        int h = Integer.parseInt(hour);
        if (h >=0 && h < 10) {
            hour = "0" + hour;
        }
        String minute = calendar.get(Calendar.MINUTE) + "";
        int mi = Integer.parseInt(minute);
        if (mi >=0 && mi < 10) {
            minute = "0" + minute;
        }
        String second = calendar.get(Calendar.SECOND) + "";
        int s = Integer.parseInt(second);
        if (s > 0 && s < 10) {
            second = "0" + second;
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append(year);
        buffer.append(month);
        buffer.append(date);
        buffer.append(hour);
        buffer.append(minute);
        buffer.append(second);
        return buffer.toString();
    }
}

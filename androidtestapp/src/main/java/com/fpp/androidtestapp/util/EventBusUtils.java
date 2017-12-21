package com.fpp.androidtestapp.util;

import com.fpp.androidtestapp.common.DataEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * EventBus工具类
 */
public class EventBusUtils {
    /**
     * 发送事件
     *
     * @param type 事件类型
     */
    public static void postEvent(int type) {
        EventBus.getDefault().post(new DataEvent(type));
    }

    /**
     * 发送事件
     *
     * @param type 事件类型
     * @param data 数据
     */
    public static void postEvent(int type, Object data) {
        EventBus.getDefault().post(new DataEvent(type, data));
    }

    /**
     * 发送事件
     *
     * @param type 事件类型
     * @param data 数据
     * @param whit 其他标识
     */
    public static void postEvent(int type, Object data, int whit) {
        EventBus.getDefault().post(new DataEvent(type, data, whit));
    }

}

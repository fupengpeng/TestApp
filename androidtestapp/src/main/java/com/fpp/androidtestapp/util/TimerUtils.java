package com.fpp.androidtestapp.util;

import com.fpp.androidtestapp.common.DataEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/12/20.
 * 计时器
 */

public class TimerUtils {
    int counts;

    /**
     *    计时器
     * @param count              多少秒
     * @param eventBusTag       订阅消息标签
     */
    public TimerUtils(final int count, final int eventBusTag){
        final Timer timer =new Timer();
        counts =count;
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                counts--;
                if (counts<=1){
                    EventBus.getDefault().post(new DataEvent(eventBusTag,"获取验证码"));
                    timer.cancel();
                }
               EventBus.getDefault().post(new DataEvent(eventBusTag,counts));
            }

        };
        timer.schedule(timerTask,1000,1000);
    }

}

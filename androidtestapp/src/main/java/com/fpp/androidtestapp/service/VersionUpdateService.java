package com.fpp.androidtestapp.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.fpp.androidtestapp.R;
import com.fpp.androidtestapp.common.Consts;
import com.fpp.androidtestapp.common.DataEvent;
import com.fpp.androidtestapp.common.ObjectCallBack;
import com.fpp.androidtestapp.entity.response.NewVersionResponse;
import com.fpp.androidtestapp.model.factory.VersionModelFactory;
import com.fpp.androidtestapp.model.interf.IVersionModel;
import com.fpp.androidtestapp.util.AppUtils;
import com.fpp.androidtestapp.util.EventBusUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;

/**
 * 版本更新服务
 */
public class VersionUpdateService extends Service {
    /**
     * 版本业务
     */
    private IVersionModel versionModel = VersionModelFactory.newInstance();

    /**
     * 通知管理器
     */
    private NotificationManager notificationManager;
    /**
     * 通知Builder
     */
    private Notification.Builder builder;
    /**
     * 通知
     */
    private Notification notification;
    /**
     * 通知ID
     */
    private int notificationId = 100;
    /**
     * Service启动标识
     */
    private int what = -1;
    /**
     * Service启动标识Key
     */
    public static final String INTENT_KEY_WHAT = "INTENT_KEY_WHAT";

    public VersionUpdateService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // 注册
        EventBus.getDefault().register(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 获取Service启动标识
        if (intent != null) {
            what = intent.getIntExtra(INTENT_KEY_WHAT, -1);
        }

        // 获取版本信息
        getVersionInfo();

        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 获取版本信息
     */
    private void getVersionInfo() {
        // 获取最新版本信息
        versionModel.getNewVersionInfo(new ObjectCallBack<NewVersionResponse>() {
            @Override
            public void onSuccess(NewVersionResponse data) {
                // 发送最新版本事件
                EventBusUtils.postEvent(Consts.DataEventType.VERSION_NEW, data.getVerName(), what);
            }

            @Override
            public void onFail(Exception e) {
                // 关闭服务
                stopSelf();
            }
        });
    }

    /**
     * 接收事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void onDataSynEvent(DataEvent dataEvent) {
        switch (dataEvent.getType()) {
            case Consts.DataEventType.VERSION_UPDATE: // 版本更新
                // 下载新版本
                versionModel.downloadAPK(what);
                // 发送通知
                sendNotification(0);
                break;
            case Consts.DataEventType.VERSION_UPDATE_CANCEL: // 版本更新取消
                stopSelf();
                break;
            case Consts.DataEventType.VERSION_DOWNLOAD_PROGRESS: // 下载进度
                // 发送通知
                sendNotification((int) dataEvent.getData());
                break;
            case Consts.DataEventType.VERSION_DOWNLOAD_ERROR: // 下载失败
                // 取消通知
                notificationManager.cancel(notificationId);
                stopSelf();
                break;
            case Consts.DataEventType.VERSION_DOWNLOAD_FINISH: // 下载完成
                File file = new File(Consts.DOWNLOAD_BASE_PATH + Consts.APK_NAME);
                if (file.exists() & file.length() > 8 * 1024) {
                    // 取消通知
                    notificationManager.cancel(notificationId);
                    // 安装APK
                    AppUtils.installApkPackage(getApplicationContext(), Consts.DOWNLOAD_BASE_PATH + Consts.APK_NAME);
                    stopSelf();
                } else {
                    // 发送下载失败
                    EventBusUtils.postEvent(Consts.DataEventType.VERSION_DOWNLOAD_ERROR, Consts.APK_NAME, what);
                }

                break;
        }
    }

    /**
     * 发送通知
     *
     * @param progress 下载进度
     */
    private void sendNotification(int progress) {
        // 获取通知管理器
        if (notificationManager == null) {
            notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        }

        // Builder
        if (builder == null) {
            builder = new Notification.Builder(this);
        }
        builder.setSmallIcon(R.mipmap.ic_launcher) // 图标
                .setContentTitle(getString(R.string.app_name)) // 通知内容
                .setContentText("已下载" + progress + "%") // 滚动消息
                .setProgress(100, progress, false)
                .setShowWhen(false);

        //
        if (progress == 0) {
            builder.setTicker(getString(R.string.app_name) + "新版本下载中...");
        }

        // 构建通知
        notification = builder.build();
        // 发布通知
        notificationManager.notify(notificationId, notification);
    }

    @Override
    public void onDestroy() {
        // 注销
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}

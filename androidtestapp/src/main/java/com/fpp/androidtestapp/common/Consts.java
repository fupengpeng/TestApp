package com.fpp.androidtestapp.common;

import android.os.Environment;

import com.yanzhenjie.nohttp.RequestMethod;

/**
 * 常量
 */
public class Consts {

    /**
     * 网络URL
     */
    public class NetUrl {
        /**
         * IP地址
         */
        public static final String BASE_NET_URL = "http://api.juyunmei.com/";

        /**
         * 版本管理：最新版本信息
         */
        public static final String VERSION_LOAD_NEW_INFO = "";
        /**
         * 版本管理：APK下载地址
         */
        public static final String VERSION_APK_URL = "";

    }

    /**
     * 等待对话框提示的信息
     */
    public class WaitDialogMessage {
        /**
         * 登录
         */
        public static final String LOGINING = "登录中...";
        /**
         * 数据加载中
         */
        public static final String DATA_LOADING = "数据加载中...";
        /**
         * 设置存储空间权限
         */
        public static final String SET_EXTERNAL_STORAGE_PERMISSION = "请允许权限申请，否者不能访问SDCard";

    }

    /**
     * 事件类型
     */
    public class DataEventType {
        /**
         * 加载当前门店及个人信息成功
         */
        public static final int LOAD_USER_SHOP_INFO_SUCCESS = 0;


        /**
         * 网络连接可用
         */
        public static final int NET_CONNECTION_ACCESS = 101;
        /**
         * 网络连接断开
         */
        public static final int NET_CONNECTION_BREAK = 102;


        /**
         * 最新版本
         */
        public static final int VERSION_NEW = 201;
        /**
         * 版本更新
         */
        public static final int VERSION_UPDATE = 202;
        /**
         * 版本更新取消
         */
        public static final int VERSION_UPDATE_CANCEL = 203;
        /**
         * APK下载失败
         */
        public static final int VERSION_DOWNLOAD_ERROR = 204;
        /**
         * APK下载进度
         */
        public static final int VERSION_DOWNLOAD_PROGRESS = 205;
        /**
         * APK下载完成
         */
        public static final int VERSION_DOWNLOAD_FINISH = 206;
    }

    /**
     * Intent参数Key
     */
    public class IntentExtraKey {

    }

    /**
     * Intent参数Value
     */
    public class IntentExtraValue {

    }

    /**
     * 订单状态
     */
    public class OrderType {
        /**
         * 全部
         */
        public static final String ALL = "0";
        /**
         * 待接单
         */
        public static final String WAITING = "1";
        /**
         * 服务中
         */
        public static final String SERVICING = "2";
        /**
         * 已完成
         */
        public static final String FINISHED = "8";
        /**
         * 已取消
         */
        public static final String CANCELED = "9";
    }

    /**
     * 门店属性配置类型
     */
    public class ShopOrganType {
        /**
         * 部门
         */
        public static final String DEPT = "dept";
        /**
         * 员工岗位
         */
        public static final String POST = "post";
        /**
         * 员工级别
         */
        public static final String JOB = "job";
        /**
         * 费用
         */
        public static final String COST = "cost";
        /**
         * 会员来源
         */
        public static final String SOURCE = "source";
        /**
         * 会员类型
         */
        public static final String MEMBERTYPE = "membertype";
        /**
         * 服务分组
         */
        public static final String SERVICE = "service";
        /**
         * 商品分类
         */
        public static final String GOODS = "goods";
        /**
         * 供应商
         */
        public static final String SUPPLIER = "supplier";
        /**
         * 计次疗程
         */
        public static final String TIMES = "times";
    }

    /**
     * Session
     */
    public static final String SESSION = "SESSION";
    /**
     * 选择的门店
     */
    public static final String CURR_SHOP = "CURR_SHOP";

    /**
     * 网络请求失败
     */
    public static final String NET_REQUEST_EXCEPTION = "数据加载失败，请重新加载";

    /**
     * 网络请求方式
     */
    public static final RequestMethod NET_REQUEST_METHOD = RequestMethod.POST;

    /**
     * 文件下载基路径
     */
    public static final String DOWNLOAD_BASE_PATH = Environment.getExternalStorageDirectory() + "/appname/";
    /**
     * APK文件名
     */
    public static final String APK_NAME = "appname.apk";

}

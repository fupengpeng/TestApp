package com.fpp.androidtestapp.common;

/**                              hankehui
 * Created by Administrator on 2017/12/7.
 * EventBus标签
 *
 * xxxx.xx.xxxx
 * 类  作用 标签
 * 1001:                          客户账单
 * 1002:                          客单详情
 * 1003:                          报表
 * 1004:                          客户建档
 *
 * 01:                            控件修改
 * 02:                            适配器更新ui
 * 03:                            数据修改
 *
 * 0001:                          标签
 */

public class EventTag {
    /**
     * view控件修改
     */
    public class viewRevamp{
        /**
         * 输入框修改
         */
        public static final int CLIENT_SCREEN_SEEK_CANCEL=1001010001;
    }

    /**
     * 适配器更新ui
     */
    public class adapter{
        /**
         * 客单详情删除项目
         */
        public static final int CLIENT_ADAPTER_VIEW=1002020001;
    }

    /**
     * 数据修改
     */
    public class message{
        /**
         * 报表现金收入百分比显示
         */
        public static final int STATEMENT_MONEY_TEXT_PERCENT=1003030001;
        /**
         * 验证码等待
         */
        public static final int CLIENT_BOOK_BUILDING_VERIFICATION_CODE_TIME=1004030001;
        /**
         * 发送验证码
         */
        public static final int CLIENT_BOOK_BUILDING_SEND_VERIFICATION_CODE=1004030002;
    }
}

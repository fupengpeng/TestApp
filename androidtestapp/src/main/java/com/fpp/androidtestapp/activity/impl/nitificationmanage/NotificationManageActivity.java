package com.fpp.androidtestapp.activity.impl.nitificationmanage;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.fpp.androidtestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotificationManageActivity extends AppCompatActivity {


    @BindView(R.id.tv_atvt_notification_hide_one)
    TextView tvAtvtNotificationHideOne;
    @BindView(R.id.tv_atvt_notification_hide_two)
    TextView tvAtvtNotificationHideTwo;
    @BindView(R.id.tv_atvt_notification_hide_three)
    TextView tvAtvtNotificationHideThree;
    @BindView(R.id.tv_atvt_notification_hide_four)
    TextView tvAtvtNotificationHideFour;
    @BindView(R.id.tv_atvt_notification_show)
    TextView tvAtvtNotificationShow;
    @BindView(R.id.tv_atvt_notification_hide_five)
    TextView tvAtvtNotificationHideFive;
    @BindView(R.id.tv_atvt_notification_hide_six)
    TextView tvAtvtNotificationHideSix;
    @BindView(R.id.tv_atvt_notification_hide_seven)
    TextView tvAtvtNotificationHideSeven;
    @BindView(R.id.tv_atvt_notification_hide_eight)
    TextView tvAtvtNotificationHideEight;
    @BindView(R.id.tv_atvt_notification_hide_nine)
    TextView tvAtvtNotificationHideNine;
    @BindView(R.id.tv_atvt_notification_hide_ten)
    TextView tvAtvtNotificationHideTen;
    @BindView(R.id.tv_atvt_notification_hide_eleven)
    TextView tvAtvtNotificationHideEleven;
    @BindView(R.id.tv_atvt_notification_hide_twelve)
    TextView tvAtvtNotificationHideTwelve;
    @BindView(R.id.tv_atvt_notification_hide_thirteen)
    TextView tvAtvtNotificationHideThirteen;
    @BindView(R.id.tv_atvt_notification_hide_fourteen)
    TextView tvAtvtNotificationHideFourteen;
    @BindView(R.id.tv_atvt_notification_hide_fifteen)
    TextView tvAtvtNotificationHideFifteen;
    @BindView(R.id.tv_atvt_notification_hide_sixteen)
    TextView tvAtvtNotificationHideSixteen;
    @BindView(R.id.tv_atvt_notification_hide_seventeen)
    TextView tvAtvtNotificationHideSeventeen;
    @BindView(R.id.tv_atvt_notification_hide_eighteen)
    TextView tvAtvtNotificationHideEighteen;
    @BindView(R.id.tv_atvt_notification_hide_nineteen)
    TextView tvAtvtNotificationHideNineteen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏状态栏三：与“隐藏状态栏一”效果相同
//        //去除title
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        //去掉Activity上面的状态栏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // 隐藏状态栏四：与“隐藏状态栏一”效果相同
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_notification_manage);
        ButterKnife.bind(this);


    }

    // 隐藏状态栏五：在主题样式中添加下述属性
//    <item name="android:windowFullscreen">true</item>
    // 隐藏状态栏六：在AndroidManifest.xml的activity中设置
//    android:theme="@android:style/Theme.NoTitleBar.Fullscreen"

//    View.SYSTEM_UI_FLAG_VISIBLE：显示状态栏，Activity不全屏显示(恢复到有状态的正常情况)。
//    View.INVISIBLE：隐藏状态栏，同时Activity会伸展全屏显示。
//    View.SYSTEM_UI_FLAG_FULLSCREEN：Activity全屏显示，且状态栏被隐藏覆盖掉。
//    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN：Activity全屏显示，但状态栏不会被隐藏覆盖，状态栏依然可见，Activity顶端布局部分会被状态遮住。
//    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION：效果同View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//    View.SYSTEM_UI_LAYOUT_FLAGS：效果同View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION：隐藏虚拟按键(导航栏)。有些手机会用虚拟按键来代替物理按键。
//    View.SYSTEM_UI_FLAG_LOW_PROFILE：状态栏显示处于低能显示状态(low profile模式)，状态栏上一些图标显示会被隐藏。


//    通过getResources().getConfiguration().orientation可以拿到当前屏幕方向的状态值 Configuration.ORIENTATION_LANDSCAPE 表示的是横屏　


    @OnClick({R.id.tv_atvt_notification_hide_one, R.id.tv_atvt_notification_hide_two,
            R.id.tv_atvt_notification_hide_three, R.id.tv_atvt_notification_hide_four,
            R.id.tv_atvt_notification_show, R.id.tv_atvt_notification_hide_five,
            R.id.tv_atvt_notification_hide_six,
            R.id.tv_atvt_notification_hide_seven, R.id.tv_atvt_notification_hide_eight,
            R.id.tv_atvt_notification_hide_nine, R.id.tv_atvt_notification_hide_ten,
            R.id.tv_atvt_notification_hide_eleven, R.id.tv_atvt_notification_hide_twelve,
            R.id.tv_atvt_notification_hide_thirteen, R.id.tv_atvt_notification_hide_fourteen,
            R.id.tv_atvt_notification_hide_fifteen, R.id.tv_atvt_notification_hide_sixteen,
            R.id.tv_atvt_notification_hide_seventeen, R.id.tv_atvt_notification_hide_eighteen,
            R.id.tv_atvt_notification_hide_nineteen})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_atvt_notification_hide_one:
                // 隐藏状态栏一
                // 彻底隐藏状态栏，从顶部下滑会显示透明状态栏，但点击屏幕其它地方以后，透明状态栏会继续隐藏。
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); //隐藏状态栏
                break;
            case R.id.tv_atvt_notification_hide_two:
                // 隐藏状态栏二
                // 暂时隐藏状态栏，从顶部下滑时状态栏会重新显示。
                View decorView = getWindow().getDecorView();
                int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
                decorView.setSystemUiVisibility(option);

                break;
            case R.id.tv_atvt_notification_hide_three:
                //布局填充状态栏，设置透明
                if (Build.VERSION.SDK_INT >= 21) {
                    decorView = getWindow().getDecorView();
                    option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                    decorView.setSystemUiVisibility(option);
                    getWindow().setStatusBarColor(Color.TRANSPARENT);//透明状态栏
                }

                break;
            case R.id.tv_atvt_notification_hide_four:
                //隐藏状态栏和导航栏，但是一点击就显示出来了
                if (Build.VERSION.SDK_INT >= 21) {
                    decorView = getWindow().getDecorView();
                    option = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN;
                    decorView.setSystemUiVisibility(option);
                }

                break;
            case R.id.tv_atvt_notification_show:
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); //显示状态栏
                break;
            case R.id.tv_atvt_notification_hide_five:
                //布局填充状态栏，导航栏，设置全部透明
                if (Build.VERSION.SDK_INT >= 21) {
                    decorView = getWindow().getDecorView();
                    option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                    decorView.setSystemUiVisibility(option);
                    getWindow().setNavigationBarColor(Color.TRANSPARENT);
                    getWindow().setStatusBarColor(Color.TRANSPARENT);
                }
                break;
            case R.id.tv_atvt_notification_hide_six:
                //全屏显示，拉出状态栏和导航栏后一会后消失。
                if (Build.VERSION.SDK_INT >= 21) {
                    decorView = getWindow().getDecorView();
                    decorView.setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
                }
                break;
            case R.id.tv_atvt_notification_hide_seven:
                // 跟随系统横竖屏显示
                NotificationManageActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                break;
            case R.id.tv_atvt_notification_hide_eight:
                // 横屏显示
                NotificationManageActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                break;
            case R.id.tv_atvt_notification_hide_nine:
                // 竖屏显示
                NotificationManageActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                break;
            case R.id.tv_atvt_notification_hide_ten:
                // 状态栏标识颜色变黑
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                }
                break;
            case R.id.tv_atvt_notification_hide_eleven:
                // 状态栏标识颜色变白
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
                }
                break;
            case R.id.tv_atvt_notification_hide_twelve:
                // 隐藏状态栏，透明导航栏，固定屏幕
                getWindow().addFlags(WindowManager.LayoutParams.TYPE_STATUS_BAR);
                break;
            case R.id.tv_atvt_notification_hide_thirteen:
                // 隐藏状态栏，透明导航栏，不固定屏幕
                getWindow().clearFlags(WindowManager.LayoutParams.TYPE_STATUS_BAR);
                break;
            case R.id.tv_atvt_notification_hide_fourteen:
//                //布局填充状态栏，设置透明
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    decorView = getWindow().getDecorView();
//                    option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
//                    decorView.setSystemUiVisibility(option);
//                    getWindow().setStatusBarColor(Color.TRANSPARENT);//透明状态栏
////                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//                }

//                // 透明状态栏，标题栏
//                getWindow().clearFlags(WindowManager.LayoutParams.TYPE_INPUT_METHOD_DIALOG);
//                getWindow().clearFlags(WindowManager.LayoutParams.TYPE_STATUS_BAR_PANEL);
//                getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
//                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR);

//                // 隐藏标题栏
//                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

//                // 不透明状态栏，标题栏
//                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
//                getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
//                getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR);


//                // 显示标题栏
//                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//                // 透明导航栏
//                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//                // 状态栏变黑
//                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

                getWindow().addFlags(WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED);
                break;
            case R.id.tv_atvt_notification_hide_fifteen:
//                // 恢复原色导航栏
//                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//                // 状态栏变黑后恢复原色
//                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

                getWindow().clearFlags(WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED);
                break;
            case R.id.tv_atvt_notification_hide_sixteen:
//                // 使所有控件变黑
//                getWindow().addFlags(WindowManager.LayoutParams.FLAG_SCALED);
                getWindow().addFlags(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                break;
            case R.id.tv_atvt_notification_hide_seventeen:
//                // 使所有控件恢复本色
//                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SCALED);
                getWindow().clearFlags(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                break;
            case R.id.tv_atvt_notification_hide_eighteen:

                getWindow().addFlags(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
//                // 状态栏变灰
//                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                break;
            case R.id.tv_atvt_notification_hide_nineteen:


                getWindow().clearFlags(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
//                // 状态栏从灰恢复原色
//                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                break;


        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            //竖屏
//            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); //显示状态栏
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);//全部显示出来。
        } else {
            //横屏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); //隐藏状态栏

            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }


}

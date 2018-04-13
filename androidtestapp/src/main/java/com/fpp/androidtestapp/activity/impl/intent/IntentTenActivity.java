package com.fpp.androidtestapp.activity.impl.intent;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.fpp.androidtestapp.R;

public class IntentTenActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_ten);
        // 获取Activity中的TabHost组件
        TabHost tabHost = getTabHost();
        // 使用Intent添加第一个Tab页
        tabHost.addTab(tabHost
                .newTabSpec("tab1")
                .setIndicator("网页展示",getResources().getDrawable(R.drawable.ic_label_black_24dp))
                .setContent(new Intent(this,IntentFiveActivity.class))
        );
        // 使用Intent添加第一个Tab页
        tabHost.addTab(tabHost
                .newTabSpec("tab2")
                .setIndicator("Six")
                .setContent(new Intent(this,IntentSixActivity.class))
        );
        // 使用Intent添加第一个Tab页
        tabHost.addTab(tabHost
                .newTabSpec("tab3")
                .setIndicator("Seven")
                .setContent(new Intent(this,IntentSevenActivity.class))
        );
    }
}

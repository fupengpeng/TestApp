package com.test.tabhost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

import com.test.fupengpeng.testapp.R;


public class TabHostActivity extends AppCompatActivity {

    private TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host);
        tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();

        LayoutInflater inflater = LayoutInflater.from(this);
        inflater.inflate(R.layout.tab1,tabHost.getTabContentView());
        inflater.inflate(R.layout.tab2,tabHost.getTabContentView());
        tabHost.addTab(tabHost.newTabSpec("tabyyyyyyy1").setIndicator("未接电话").setContent(R.id.linearLayout1));

        tabHost.addTab(tabHost.newTabSpec("tabttttttt2").setIndicator("一接电话").setContent(R.id.linearLayout2));
    }
}

package com.fpp.androidtestapp.activity.impl.titlebar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fpp.androidtestapp.R;

public class ToolBarActivity extends AppCompatActivity implements View.OnClickListener{


    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);

        initToolBar();
//        if (Build.VERSION.SDK_INT >= 21) {
//            View decorView = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(option);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }

        initView();


    }

    private void initView() {
        Button showSettings = (Button) findViewById(R.id.show_settings);
        Button hideSettings = (Button) findViewById(R.id.hide_settings);
        showSettings.setOnClickListener(this);
        hideSettings.setOnClickListener(this);





    }

    /**
     * 初始化Toolbar
     */
    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setTitle("");

        setSupportActionBar(toolbar);

        //是否给左上角图标的左边加上一个返回的图标
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //改变默认返回按钮图片
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_account_circle_black_24dp);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * toolbar的按钮点击事件
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(ToolBarActivity.this, "设置动作", Toast.LENGTH_SHORT).show();
                break;
            case R.id.history:
                Toast.makeText(ToolBarActivity.this, "历史", Toast.LENGTH_SHORT).show();
                break;
            case R.id.calendar:
                Toast.makeText(ToolBarActivity.this, "地方大幅度", Toast.LENGTH_SHORT).show();
                break;
            // 默认返回按钮的点击事件
            case android.R.id.home:
                Toast.makeText(ToolBarActivity.this, "返回", Toast.LENGTH_SHORT).show();
                break;

            case R.id.calendar01:
                Toast.makeText(ToolBarActivity.this, "丽丽", Toast.LENGTH_SHORT).show();
                break;


            default:
                break;
        }

        return true;
    }

    /**
     * 设置toolbar中按钮的显示与隐藏
     * @param menu
     * @return
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // 动态设置ToolBar状态
//        switch (mViewPager.getCurrentItem()) {
        switch (a) {
            case 0:
                menu.findItem(R.id.calendar01).setVisible(true);
                menu.findItem(R.id.calendar).setVisible(true);
                break;
            case 1:
                menu.findItem(R.id.calendar01).setVisible(false);
                menu.findItem(R.id.calendar).setVisible(true);
                break;
            case 2:
                menu.findItem(R.id.calendar01).setVisible(false);
                menu.findItem(R.id.calendar).setVisible(true);
                break;
        }
        return super.onPrepareOptionsMenu(menu);
    }


    int a = 0;
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.show_settings:
                // 显示id为 action_settings 的按钮
                toolbar.getMenu().findItem(R.id.action_settings).setVisible(true);
                a = 1;
                Toast.makeText(ToolBarActivity.this, "显示设置按钮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.hide_settings:
                // 隐藏id为 action_settings 的按钮
                toolbar.getMenu().findItem(R.id.action_settings).setVisible(false);
                a = 2;
                Toast.makeText(ToolBarActivity.this, "隐藏设置按钮", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}

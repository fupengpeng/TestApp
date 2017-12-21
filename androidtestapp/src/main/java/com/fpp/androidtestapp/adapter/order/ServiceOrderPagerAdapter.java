package com.fpp.androidtestapp.adapter.order;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @description  服务单页面viewpager适配器
 * @author  fupengpeng
 * @date  2017/12/20 0020 19:56
 */

public class ServiceOrderPagerAdapter extends FragmentPagerAdapter {

    private List<String> title;
    private List<Fragment> views;

    public ServiceOrderPagerAdapter(FragmentManager fragmentManager, List<String> title, List<Fragment> views) {
        super(fragmentManager);
        this.title = title;
        this.views = views;
    }

    @Override
    public Fragment getItem(int position) {
        return views.get(position);
    }

    @Override
    public int getCount() {
        return views.size();
    }


    //配置标题的方法
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }


}



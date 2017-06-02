package com.fupengpeng.selectall.select;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.fupengpeng.selectall.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fupengpeng on 2017/6/2 0002.
 */

public class Mytxtl_list_adapter extends BaseAdapter {


    Context context;
    List<MytxtBean> list = new ArrayList<MytxtBean>();


    public Mytxtl_list_adapter(MytxtActivity context, List<MytxtBean> list) {
// TODO Auto-generated constructor stub
        this.context = context;
        this.list = list;

    }


    @Override
    public int getCount() {
// TODO Auto-generated method stub
        return list.size();
    }


    @Override
    public Object getItem(int arg0) {
// TODO Auto-generated method stub
        return list.get(arg0);
    }


    @Override
    public long getItemId(int arg0) {
// TODO Auto-generated method stub
        return arg0;
    }


    Gridholder gridholder = new Gridholder();


    @Override
    public View getView(final int arg0, View arg1, ViewGroup arg2) {
// TODO Auto-generated method stub


        if (arg1 == null) {
            arg1 = LayoutInflater.from(context).inflate(
                    R.layout.mytext_list_item_view, null);
            arg1.setTag(gridholder);
        } else {
            gridholder = (Gridholder) arg1.getTag();
        }

        gridholder.cb = (CheckBox) arg1.findViewById(R.id.cb);
        gridholder.cbtv = (TextView) arg1.findViewById(R.id.cbtv);
        gridholder.dingao = (TextView) arg1.findViewById(R.id.daidinggao);
        gridholder.person = (TextView) arg1.findViewById(R.id.person);
        gridholder.leixin = (TextView) arg1.findViewById(R.id.putong);
        gridholder.time = (TextView) arg1.findViewById(R.id.time);
        MytxtBean bean = list.get(arg0);

        gridholder.cbtv.setText(bean.getCbdata());
        gridholder.dingao.setText(bean.getDingaodata());
        gridholder.leixin.setText(bean.getLeixingdata());
        gridholder.person.setText(bean.getPersondata());
        gridholder.time.setText(bean.getTimedata());

        if(MytxtActivity.checkPos.get(arg0)){
            gridholder.cb.setChecked(true);
        }else{
            gridholder.cb.setChecked(false);
        }

        return arg1;
    }


    public static class Gridholder {
        TextView dingao, leixin, person, time,cbtv;
        public CheckBox cb;
    }


}
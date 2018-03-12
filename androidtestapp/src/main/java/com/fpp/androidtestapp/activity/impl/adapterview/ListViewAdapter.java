package com.fpp.androidtestapp.activity.impl.adapterview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.fpp.androidtestapp.entity.User;

import java.util.List;

/**
 * @author fupengpeng
 * @description ListView适配器
 * @data 2018/3/12 0012 11:38
 */
public class ListViewAdapter extends BaseAdapter {

    private List<User> mUserList ;

    private Context mContext;

    public ListViewAdapter (List<User> userList,Context context){
        this.mUserList = userList;
        this.mContext = context;
    }


    /**
     * 列表项个数
     * @return
     */
    @Override
    public int getCount() {
        return mUserList.size()==0?0:mUserList.size();
    }

    /**
     * 第position处的列表项内容
     * @param position 当前视图的下标
     * @return  返回列表的第position条数据
     */
    @Override
    public Object getItem(int position) {
        return mUserList.get(position);
    }

    /**
     * 第position处的列表项id
     * @param position 当前视图的下标
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 第position处的列表项组件View
     * @param position 当前视图的下标
     * @param view 布局的复用（当有布局滑出 ListView 显示的范围，view 就指向 刚滑出的布局）
     * @param viewGroup
     * @return  返回当前 Item 展示的布局
     */
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        /*
        // 通过setTag将ViewHolder和convertView绑定
        // 获取，通过ViewHolder找到相应的控件
         */


        return null;
    }
}

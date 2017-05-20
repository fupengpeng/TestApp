package com.test.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.test.fupengpeng.testapp.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/18 0018.
 */

public class MyAdapter extends BaseAdapter {
    private LayoutInflater mInflater = null;
    private Context context;
    private List<Map<String, Object>> data;
    public MyAdapter(Context context, List<Map<String, Object>> data)
    {
        //根据context上下文加载布局，这里的是Demo17Activity本身，即this
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.data = data;
    }
    @Override
    public int getCount() {
        //How many items are in the data set represented by this Adapter.
        //在此适配器中所代表的数据集中的条目数
        return data.size();
    }
    @Override
    public Object getItem(int position) {
        // Get the data item associated with the specified position in the data set.
        //获取数据集中与指定索引对应的数据项
        return data.get(position);
    }
    @Override
    public long getItemId(int position) {
        //Get the row id associated with the specified position in the list.
        //获取在列表中与指定索引对应的行id
        return position;
    }

    //Get a View that displays the data at the specified position in the data set.
    //获取一个在数据集中指定索引的视图来显示数据
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        //如果缓存convertView为空，则需要创建View
        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            //根据自定义的Item布局加载布局
            convertView = mInflater.inflate(R.layout.img_listview_item, null);
            viewHolder.img = (ImageView)convertView.findViewById(R.id.img);
            viewHolder.title = (TextView)convertView.findViewById(R.id.tv);
            viewHolder.info = (TextView)convertView.findViewById(R.id.info);
            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
            convertView.setTag(viewHolder);
        }else
        {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.img.setImageResource((Integer) data.get(position).get("img"));
        viewHolder.title.setText((String)data.get(position).get("title"));
        viewHolder.info.setText((String)data.get(position).get("info"));

        return convertView;
    }


    //ViewHolder静态类
     class ViewHolder
    {
        public ImageView img;
        public TextView title;
        public TextView info;
    }
}
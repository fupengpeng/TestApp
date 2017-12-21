package com.fpp.androidtestapp.adapter.order;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.fpp.androidtestapp.R;
import com.fpp.androidtestapp.adapter.BaseAdapter;
import com.fpp.androidtestapp.entity.order.AddSIOTOCItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @description  转单服务列表适配器
 * @author  fupengpeng
 * @date  2017/12/20 0020 19:57
 */

public class SelectLeafletItemPopupWindowAdapter extends BaseAdapter<AddSIOTOCItem> {

    public SelectLeafletItemPopupWindowAdapter(Context context, List<AddSIOTOCItem> data) {
        super(context, data);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = getLayoutInflater().inflate(R.layout.list_view_item_pw_select_leaflet_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        // 填充数据
        AddSIOTOCItem item = getItem(position);
        holder.tvLvItemPwSelectName.setText(item.getName());
        holder.tvLvItemPwSelectNumber.setText(item.getNumber() + "");
        holder.tvLvItemPwSelectPrice.setText((int) item.getPrice() + "");
        return convertView;
    }

    /**
     * ViewHolder
     */
    static class ViewHolder {
        /**
         * 是否选中
         */
        @BindView(R.id.cb_lv_item_pw_select_item)
        CheckBox cbLvItemPwSelectItem;
        /**
         * 项目名
         */
        @BindView(R.id.tv_lv_item_pw_select_name)
        TextView tvLvItemPwSelectName;
        /**
         * 项目数量
         */
        @BindView(R.id.tv_lv_item_pw_select_number)
        TextView tvLvItemPwSelectNumber;
        /**
         * 项目价格
         */
        @BindView(R.id.tv_lv_item_pw_select_price)
        TextView tvLvItemPwSelectPrice;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }



}

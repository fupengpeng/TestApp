package com.fpp.androidtestapp.adapter.order;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fpp.androidtestapp.R;
import com.fpp.androidtestapp.customerview.RoundImageView;
import com.fpp.androidtestapp.entity.GoodsItem;
import com.fpp.androidtestapp.util.LogUtils;

import java.util.List;

/**
 * @author fupengpeng
 * @description 添加商品条目列表适配器
 * @date 2017/12/20 0020 19:58
 */

public class AddGoodsItemAdapter extends RecyclerView.Adapter<AddGoodsItemAdapter.ViewHolder> {

    /**
     * 展示数据
     */
    List<GoodsItem> data;
    Context context;


    /**
     * 构造函数
     *
     * @param context
     * @param data
     */
    public AddGoodsItemAdapter(Context context , List<GoodsItem> data) {
        this.data = data;
        this.context = context;
    }

    /**
     * 获取第position条数据
     *
     * @param position
     * @return
     */
    public GoodsItem getItem(int position) {
        return data.get(position);
    }

    /**
     * 创建view
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_item_select_soc, parent, false);
        // 实例化viewholder
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    /**
     * 绑定数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        // 填充数据
        final GoodsItem item = data.get(position);
        holder.tvLvItemSelectServiceName.setText(item.getGoodsname());
        holder.tvLvItemSelectServiceSalePrice.setText(item.getSaleprice());
        holder.tvLvItemSelectServiceDiscount.setText(item.getDiscount());
        holder.tvLvItemSelectServiceDiscountPrice.setText(item.getDiscountprice());
        //设置数量，根据数量判断减少的按钮是否显示
        if (item.getNum() <= 0) {
            LogUtils.e("----001");
            holder.tvLvItemSelectServiceAdd.setText("");
            holder.ivLvItemSelectServiceRemove.setVisibility(View.GONE);
            if ("".equals(item.getImageurl())) {
                LogUtils.e("----00007");
                holder.ivLvItemSelectServiceAdd.setImageResource(R.drawable.order_add_item);
            } else {
                LogUtils.e("----000009");
                Glide.with(context).load(item.getImageurl()).into(holder.ivLvItemSelectServiceAdd);
            }
        } else {
            LogUtils.e("----00008");
            if ("".equals(item.getImageurl())) {
                LogUtils.e("----00006");
                holder.ivLvItemSelectServiceAdd.setImageResource(R.drawable.order_add_item);
            } else {
                LogUtils.e("----00005");
                Glide.with(context).load(item.getImageurl()).into(holder.ivLvItemSelectServiceAdd);
            }
            holder.tvLvItemSelectServiceAdd.setBackgroundResource(R.drawable.order_add_sog_tv_style);
            holder.ivLvItemSelectServiceRemove.setVisibility(View.VISIBLE);
            holder.tvLvItemSelectServiceAdd.setText(item.getNum() + "");
        }


        //子条目中增加服务按钮的点击事件设置
        holder.tvLvItemSelectServiceAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemAddListener.onAddClick(position, holder);
            }
        });
        //子条目中减少服务按钮的点击事件设置
        holder.ivLvItemSelectServiceRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemDeleteListener.onDeleteClick(position, holder);
            }
        });


    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout llLvItemSelectService;
        /**
         * 点击添加商品数量
         */
        public TextView tvLvItemSelectServiceAdd;
        /**
         * 商品图片
         */
        public ImageView ivLvItemSelectServiceAdd;
        /**
         * 点击减去服务项或商品数量
         */
        public
        ImageView ivLvItemSelectServiceRemove;
        /**
         * 服务项或商品数量名称
         */
        TextView tvLvItemSelectServiceName;
        /**
         * 服务项或商品原价
         */
        TextView tvLvItemSelectServiceSalePrice;

        /**
         * 服务项或商品折扣
         */
        TextView tvLvItemSelectServiceDiscount;
        /**
         * 服务项或商品折后价
         */
        TextView tvLvItemSelectServiceDiscountPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            ivLvItemSelectServiceAdd = (RoundImageView) itemView.findViewById(R.id.iv_lv_item_select_service_add);
            tvLvItemSelectServiceAdd = (TextView) itemView.findViewById(R.id.tv_lv_item_select_service_add);
            ivLvItemSelectServiceRemove = (ImageView) itemView.findViewById(R.id.iv_lv_item_select_service_remove);
            tvLvItemSelectServiceName = (TextView) itemView.findViewById(R.id.tv_lv_item_select_service_name);
            tvLvItemSelectServiceSalePrice = (TextView) itemView.findViewById(R.id.tv_lv_item_select_service_sale_price);
            tvLvItemSelectServiceDiscount = (TextView) itemView.findViewById(R.id.tv_lv_item_select_service_discount);
            tvLvItemSelectServiceDiscountPrice = (TextView) itemView.findViewById(R.id.tv_lv_item_select_service_discount_price);
            llLvItemSelectService = (LinearLayout) itemView.findViewById(R.id.ll_lv_item_select_service);


        }
    }


    /**
     * 事件回调监听
     */
    private OnItemClickListener onItemClickListener;

    /**
     * 设置回调监听
     *
     * @param listener
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    /**
     * 事件回调监听声明
     */
    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }


    /**
     * 子条目删除按钮监听接口
     */
    private OnItemDeleteListener mOnItemDeleteListener;

    /**
     * 删除按钮的监听接口
     */
    public interface OnItemDeleteListener {
        void onDeleteClick(int position, ViewHolder holder);
    }

    /**
     * 子条目中删除按钮设置监听
     *
     * @param mOnItemDeleteListener
     */
    public void setOnItemDeleteClickListener(OnItemDeleteListener mOnItemDeleteListener) {
        this.mOnItemDeleteListener = mOnItemDeleteListener;
    }

    /**
     * 子条目添加按钮监听接口
     */
    private OnItemAddListener mOnItemAddListener;

    /**
     * 添加按钮的监听接口
     */
    public interface OnItemAddListener {
        void onAddClick(int position, ViewHolder holder);
    }

    /**
     * 子条目中添加按钮设置监听
     *
     * @param mOnItemAddListener
     */
    public void setOnItemAddClickListener(OnItemAddListener mOnItemAddListener) {
        this.mOnItemAddListener = mOnItemAddListener;
    }



}

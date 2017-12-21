package com.fpp.androidtestapp.adapter.order;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fpp.androidtestapp.R;
import com.fpp.androidtestapp.adapter.BaseAdapter;
import com.fpp.androidtestapp.entity.OrderItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @description  待接单服务单列表Adapter
 * @author  fupengpeng
 * @date  2017/12/20 0020 19:56
 */

public class WaitAcceptServiceOrderListAdapter extends BaseAdapter<OrderItem> {

    /**
     * 构造方法
     *
     * @param context Context对象，值不能为null
     * @param data
     */
    public WaitAcceptServiceOrderListAdapter(Context context, List<OrderItem> data) {
        super(context, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = getLayoutInflater().inflate(R.layout.list_view_item_service_order, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        // 填充数据
        OrderItem item = getItem(position);

        //订单信息
        holder.tvLvItemServiceOrderNumber.setBackgroundResource(R.drawable.task_no_bg_3);
        holder.tvLvItemServiceOrderNumber.setText(item.getId());
        holder.tvLvItemServiceOrderStatus.setText("已取消");
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        holder.tvLvItemServiceOrderDate.setText(item.getDate());


        //根据门店会员id判断客户是否是会员
        if (item.getMemberbelongsshopid().isEmpty()){
            holder.ivLvItemServiceOrderUserPic.setImageResource(R.drawable.ic_account_circle_black_24dp);
            holder.tvLvItemServiceOrderUserName.setText("散客");
        }else {
            holder.tvLvItemServiceOrderUserName.setText(item.getTakinguid());
            // TODO: 2017/12/20 0020
            holder.ivLvItemServiceOrderUserPic.setImageURI(Uri.parse("asdfasdfa"));
            holder.tvLvItemServiceOrderUserPhoneNumber.setText("12345678912");
            holder.ivLvItemServiceOrderDial.setImageResource(R.drawable.task_call_mobile);
            holder.tvLvItemServiceOrderDial.setText("拨打电话");

        }

        //最后一项服务信息
        holder.tvLvItemServiceOrderItemName.setText(item.getTakingtime());
        holder.tvLvItemServiceOrderWaiterName.setText(item.getTakingtime());
        holder.tvLvItemServiceOrderServiceStatus.setText(item.getTakingtime());
        holder.tvLvItemServiceOrderServiceTime.setText(item.getTakingtime());


        return convertView;
    }

    /**
     * viewholder
     */
    static class ViewHolder {
        /**
         * 服务单id
         */
        @BindView(R.id.tv_lv_item_service_order_number)
        TextView tvLvItemServiceOrderNumber;
        /**
         * 服务单状态
         */
        @BindView(R.id.tv_lv_item_service_order_status)
        TextView tvLvItemServiceOrderStatus;
        /**
         * 服务单创建日期
         */
        @BindView(R.id.tv_lv_item_service_order_date)
        TextView tvLvItemServiceOrderDate;
        /**
         * 会员头像，非会员时，展示默认头像
         */
        @BindView(R.id.iv_lv_item_service_order_user_pic)
        ImageView ivLvItemServiceOrderUserPic;
        /**
         * 会员名称，非会员时，展示默认名称
         */
        @BindView(R.id.tv_lv_item_service_order_user_name)
        TextView tvLvItemServiceOrderUserName;
        /**
         * 会员手机号，非会员时，没有不展示
         */
        @BindView(R.id.tv_lv_item_service_order_user_phone_number)
        TextView tvLvItemServiceOrderUserPhoneNumber;
        /**
         * 电话图标
         */
        @BindView(R.id.iv_lv_item_service_order_dial)
        ImageView ivLvItemServiceOrderDial;
        /**
         * 拨打电话文字
         */
        @BindView(R.id.tv_lv_item_service_order_dial)
        TextView tvLvItemServiceOrderDial;
        /**
         * 拨打电话
         */
        @BindView(R.id.ll_lv_item_service_order_turn_member)
        LinearLayout llLvItemServiceOrderTurnMember;
        /**
         * 最后一项服务的服务名称
         */
        @BindView(R.id.tv_lv_item_service_order_item_name)
        TextView tvLvItemServiceOrderItemName;
        /**
         * 最后一项服务的工作者名称
         */
        @BindView(R.id.tv_lv_item_service_order_waiter_name)
        TextView tvLvItemServiceOrderWaiterName;
        /**
         * 最后一项服务的服务状态
         */
        @BindView(R.id.tv_lv_item_service_order_service_status)
        TextView tvLvItemServiceOrderServiceStatus;
        /**
         * 最后一项服务的服务时长
         */
        @BindView(R.id.tv_lv_item_service_order_service_time)
        TextView tvLvItemServiceOrderServiceTime;
        /**
         * 查看订单详情按钮
         */
        @BindView(R.id.ll_lv_item_service_order_particulars)
        LinearLayout llLvItemServiceOrderParticulars;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}

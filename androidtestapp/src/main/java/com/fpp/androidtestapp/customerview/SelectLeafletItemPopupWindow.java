package com.fpp.androidtestapp.customerview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.fpp.androidtestapp.R;
import com.fpp.androidtestapp.adapter.BaseAdapter;
import com.fpp.androidtestapp.entity.ServiceItem;
import com.fpp.androidtestapp.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 传单popupwindow
 */

public class SelectLeafletItemPopupWindow extends PopupWindow {

    /**
     * popupwindow 页面
     */
    private View mMenuView;
    /**
     *  全选按钮
     */
    CheckBox checkBox;
    /**
     *  listview
     */
    ListView listView;
    /**
     *  确认转单
     */
    TextView textView;

    /**
     *  传递项目栏
     */
    LinearLayout linearLayout;
    /**
     *  全选标题栏
     */
    LinearLayout linearLayoutContent;

    /**
     * 模拟数据
     */
    List<ServiceItem> mListData;

    /**
     * listview适配器
     */
    private PwAdapter pwAdapter;// adapter
    /**
     * 批量模式下，用来记录当前选中状态
     */
    private SparseArray<Boolean> mSelectState = new SparseArray<Boolean>();

    boolean isSelect = false;

    /**
     * 适配器添加数据（用户服务项）
     */
    List<ServiceItem> data;

    /**
     * context
     */
    Activity mActivity;

    public SelectLeafletItemPopupWindow(final Activity context) {
        super(context);
        this.mActivity = context;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.layout_popupwindow_select_leaflet_item, null);
        //获取控件
        initView();
        //控件点击事件
        initListener();
        //获取数据
        loadData();
        //刷新页面数据
        refreshListView();

        data = getData();
        pwAdapter = new PwAdapter(context, data);
        listView.setAdapter(pwAdapter);

        //ListView item 点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO: 2017/12/12 设置checkbox的属性值变化
            }
        });


        //设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        // 设置弹出窗体显示时的动画，从底部向上弹出
//        this.setAnimationStyle(R.style.popup_window_anim);
        ColorDrawable dw = new ColorDrawable(0x99999999);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);


//        //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
//        mMenuView.setOnTouchListener(new View.OnTouchListener() {
//
//            public boolean onTouch(View v, MotionEvent event) {
//                /*容器  ll_leaflet_content*/
//                int height = mMenuView.findViewById(R.id.ll_leaflet_content).getTop();
//                int y = (int) event.getY();
//                if (event.getAction() == MotionEvent.ACTION_UP) {
//                    if (y < height) {
//                        dismiss();
//                    }
//                }
//                return true;
//            }
//        });


    }

    /**
     * listview数据准备
     *
     * @return
     */
    public List<ServiceItem> getData() {
        List<ServiceItem> data = new ArrayList<ServiceItem>();
        for (int i = 1; i < 50; i++) {
            ServiceItem serviceItem = new ServiceItem();
            serviceItem.setServiceitemid("100" + i);
            serviceItem.setServiceitemname("服务名" + i);
            serviceItem.setDiscount("" + i);
            serviceItem.setSaleprice("" + i);
            serviceItem.setEnable(false);
            data.add(serviceItem);
        }
        return data;
    }


    /**
     * 控件获取
     */
    private void initView() {
        textView = (TextView) mMenuView.findViewById(R.id.tv_layout_pw_affirm_leaflet);
        checkBox = (CheckBox) mMenuView.findViewById(R.id.cb_layout_pw_check_all);
        listView = (ListView) mMenuView.findViewById(R.id.lv_layout_pw_item);
        linearLayout = (LinearLayout) mMenuView.findViewById(R.id.ll_layout_pw_transfer_item_dismiss_pw);
        linearLayoutContent = (LinearLayout) mMenuView.findViewById(R.id.ll_layout_pw_content);

    }

    /**
     * popupwindow中控件点击事件处理
     */
    private void initListener() {
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    for (int i = 0; i < mListData.size(); i++) {
                        mListData.get(i).setEnable(true);
                    }
                    // 刷新
                    pwAdapter.notifyDataSetChanged();
                } else {
                    for (int i = 0; i < mListData.size(); i++) {
                        mListData.get(i).setEnable(false);
                        // 刷新
                        pwAdapter.notifyDataSetChanged();
                    }
                }
            }
        });


        linearLayoutContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectLeafletItemPopupWindow.this.dismiss();
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectLeafletItemPopupWindow.this.dismiss();
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                mActivity.finish();
            }
        });
    }

    /**
     * 设置数据
     */
    private void loadData() {
        mListData = getData();
    }

    /**
     * 更新popupwindow列表页面数据
     */
    private void refreshListView() {
        if (pwAdapter == null) {
            pwAdapter = new PwAdapter(mActivity, mListData);
            listView.setAdapter(pwAdapter);
            listView.setOnItemClickListener(pwAdapter);
        } else {
            pwAdapter.notifyDataSetChanged();
        }
    }
//-------------------------------------------------------------------------------------

    /**
     * 适配器
     */
    class PwAdapter extends BaseAdapter<ServiceItem> implements AdapterView.OnItemClickListener {
        public PwAdapter(Context context, List<ServiceItem> data) {
            super(context, data);
        }

        ViewHolder holder = null;
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_view_item_pw_select_leaflet_item, null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            final ServiceItem item = mListData.get(position);
            bindListItem(holder, item);


            if (item != null) {
                // 判断是否选择
                if (item.isEnable()) {
                    holder.cbLvItemPwSelectItem.setChecked(true);
                } else {
                    holder.cbLvItemPwSelectItem.setChecked(false);
                }
                // 选中操作
                holder.cbLvItemPwSelectItem.setOnClickListener(new CheckBoxOnClick(item));

            }
            return convertView;
        }

        /**
         * checkbox 点击事件监听
         */
        class CheckBoxOnClick implements View.OnClickListener {
            ServiceItem shopcartEntity;

            public CheckBoxOnClick(ServiceItem shopcartEntity) {
                this.shopcartEntity = shopcartEntity;
            }

            @Override
            public void onClick(View view) {
                LogUtils.e("pw---", "onClick: " + "----0011----");
                CheckBox cb = (CheckBox) view;
                if (cb.isChecked()) {
                    shopcartEntity.setEnable(true);
                } else {
                    shopcartEntity.setEnable(false);
                }

                select();

            }

        }

        /**
         * 条目内数据设置
         * @param holder
         * @param data
         */
        private void bindListItem(ViewHolder holder, ServiceItem data) {
            LogUtils.e("pw---", "bindListItem: " + "----0016----");
            holder.tvLvItemPwSelectName.setText(data.getServiceitemname());
            holder.tvLvItemPwSelectPrice.setText("￥" + data.getSaleprice() + ".00");
            holder.tvLvItemPwSelectNumber.setText("×" + data.getDiscount());

            int _id = Integer.parseInt(data.getServiceitemid());
            boolean selected = mSelectState.get(_id, false);
            holder.cbLvItemPwSelectItem.setChecked(selected);

        }

        /**
         * 子条目点击事件
         * @param parent
         * @param view
         * @param position
         * @param id
         */
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            ServiceItem bean = mListData.get(position);

            ViewHolder holder = (ViewHolder) view.getTag();
            int _id = Integer.parseInt(bean.getServiceitemid());

            boolean selected = !mSelectState.get(_id, false);
            holder.cbLvItemPwSelectItem.toggle();

            LogUtils.e("pw---", "onItemClick: " + "----0017----");
            // 将CheckBox的选中状况记录下来
            mListData.get(position).setEnable(holder.cbLvItemPwSelectItem.isChecked());
            // 调整选定条目
            if (holder.cbLvItemPwSelectItem.isChecked() == true) {

            } else {
                mSelectState.delete(position);
            }

            if (mSelectState.size() == mListData.size()) {
                checkBox.setChecked(true);
            } else {
                checkBox.setChecked(false);
            }

        }


        /**
         * 静态类viewholder
         */
        class ViewHolder {
            @BindView(R.id.cb_lv_item_pw_select_item)
            CheckBox cbLvItemPwSelectItem;
            @BindView(R.id.tv_lv_item_pw_select_name)
            TextView tvLvItemPwSelectName;
            @BindView(R.id.tv_lv_item_pw_select_number)
            TextView tvLvItemPwSelectNumber;
            @BindView(R.id.tv_lv_item_pw_select_price)
            TextView tvLvItemPwSelectPrice;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }

    /**
     * 子条目点击选定
     */
    public void select() {
        int count = 0;
        for (int i = 0; i < mListData.size(); i++) {
            if (mListData.get(i).isEnable()) {
                count++;
            }
        }
        if (count == mListData.size()) {
            checkBox.setChecked(true);
        } else {
            isSelect = true;
            checkBox.setChecked(false);
        }

    }


}

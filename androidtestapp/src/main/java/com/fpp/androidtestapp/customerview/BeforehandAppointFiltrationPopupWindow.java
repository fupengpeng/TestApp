package com.fpp.androidtestapp.customerview;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;


import com.fpp.androidtestapp.R;
import com.fpp.androidtestapp.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fupengpeng
 * @description 描述
 * @data 2018/1/16 0016 9:58
 */

public class BeforehandAppointFiltrationPopupWindow extends PopupWindow {


    EditText etLayoutPwClientName;
    EditText etLayoutPwClientPhoneNumber;
    TextView tvLayoutPwShopName;
    TextView tvLayoutPwWaiterName;
    TextView tvLayoutPwSource;
    Button btnLayoutPwQuery;
    View vLayoutPwDismiss;
    ImageView ivLayoutPwLeft;
    private View menuView;
    private Activity activity;
    /**
     * 客户姓名
     */
    private String clientName = null;
    /**
     * 客户联系方式
     */
    private String clientPhoneNumber;
    /**
     * 店铺名
     */
    private String shopName;
    /**
     * 店员名
     */
    private String waiterName;
    /**
     * 预约来源
     */
    private String source;




    public BeforehandAppointFiltrationPopupWindow(final Activity activity, View.OnClickListener onClickListener) {
        super(activity);
        this.activity = activity;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE);
        menuView = inflater.inflate(R.layout.layout_popupwindow_beforehand_appoint_filtration, null);
        this.setContentView(menuView);

        ivLayoutPwLeft = (ImageView) menuView.findViewById(R.id.iv_layout_pw_left);
        etLayoutPwClientName = (EditText) menuView.findViewById(R.id.et_layout_pw_client_name);
        etLayoutPwClientPhoneNumber = (EditText) menuView.findViewById(R.id.et_layout_pw_client_phone_number);
        tvLayoutPwShopName = (TextView) menuView.findViewById(R.id.tv_layout_pw_shop_name);
        tvLayoutPwWaiterName = (TextView) menuView.findViewById(R.id.tv_layout_pw_waiter_name);
        tvLayoutPwSource = (TextView) menuView.findViewById(R.id.tv_layout_pw_source);
        btnLayoutPwQuery = (Button) menuView.findViewById(R.id.btn_layout_pw_query);
        vLayoutPwDismiss = menuView.findViewById(R.id.v_layout_pw_dismiss);

        ivLayoutPwLeft.setOnClickListener(onClickListener);
        tvLayoutPwShopName.setOnClickListener(menuOnClickLisenter);


        tvLayoutPwWaiterName.setOnClickListener(menuOnClickLisenter);
        tvLayoutPwSource.setOnClickListener(menuOnClickLisenter);
        btnLayoutPwQuery.setOnClickListener(onClickListener);
        vLayoutPwDismiss.setOnClickListener(onClickListener);

        this.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        this.setHeight(LinearLayout.LayoutParams.MATCH_PARENT);
        ColorDrawable drawable = new ColorDrawable(0xFF0000);
        this.setBackgroundDrawable(drawable);
        this.setFocusable(true);
        //输入的客户姓名获取
        etLayoutPwClientName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                clientName = etLayoutPwClientName.getText().toString().trim();
            }
        });
        //输入的手机号获取
        etLayoutPwClientPhoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                clientPhoneNumber = etLayoutPwClientPhoneNumber.getText().toString().trim();
            }
        });


    }

    View.OnClickListener menuOnClickLisenter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_layout_pw_shop_name:
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    View view = View
                            .inflate(activity, R.layout.dialog_beforehand_appoint_list_shop_select, null);
                    builder.setView(view);
                    builder.setCancelable(true);
                    ListView shopList = (ListView) view
                            .findViewById(R.id.lv_dialog_shop_select);//店铺列表
                    final List<String> shopNameList = new ArrayList<String>();
                    for (int i = 0; i < 5; i++) {
                        shopNameList.add("dianpu " + i);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(activity, android.R.layout.simple_dropdown_item_1line, shopNameList);
                    shopList.setAdapter(arrayAdapter);
                    final AlertDialog dialog = builder.create();
                    dialog.show();
                    //listview子条目点击事件
                    shopList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            LogUtils.e("选择的店铺名为 = " + shopNameList.get(position));
                        shopName = shopNameList.get(position);
                            tvLayoutPwShopName.setText(shopNameList.get(position));
                            dialog.dismiss();
                        }
                    });
                    break;
                case R.id.tv_layout_pw_waiter_name:

                    break;
                case R.id.tv_layout_pw_source:

                    break;
            }
        }
    };

//    @Override
//    public void showAsDropDown(View anchor) {
//        if (Build.VERSION.SDK_INT >= 24) {
//            Rect rect = new Rect();
//            anchor.getGlobalVisibleRect(rect);
//            int h = anchor.getResources().getDisplayMetrics().heightPixels - rect.bottom;
//            setHeight(h);
//        }
//        super.showAsDropDown(anchor);
//    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}


package com.fpp.androidtestapp.customerview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.fpp.androidtestapp.R;


/**
 * 取消服务单popupwindow
 */

public class CancelServiceOrderPopupWindow extends PopupWindow {

    public static final String TAG = "CancelServiceOrderPopupWindow";
    private View mMenuView;
    TextView tvPwClose,tvPwCloseServiceOrder;

    public CancelServiceOrderPopupWindow(final Activity context, View.OnClickListener onClickListener) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.layout_popupwindow_cancel_service_order, null);

        tvPwClose = (TextView) mMenuView.findViewById(R.id.tv_layout_pw_cancel);
        tvPwCloseServiceOrder = (TextView) mMenuView.findViewById(R.id.tv_layout_pw_cancel_service_order);

        //取消按钮
        tvPwClose.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //销毁弹出框
                dismiss();
            }
        });

        //设置按钮监听
        tvPwCloseServiceOrder.setOnClickListener(onClickListener);
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
//                //popupwindow容器
//                int height = mMenuView.findViewById(R.id.ll_content).getTop();
//                int y=(int) event.getY();
//                if(event.getAction()== MotionEvent.ACTION_UP){
//                    if(y<height){
//                        dismiss();
//                    }
//                }
//                return true;
//            }
//        });

    }


}

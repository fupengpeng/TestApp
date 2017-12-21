package com.fpp.androidtestapp.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * 解决listview与scollview的滑动冲突
 */
public class ListViewUtils {
//    public static  void setListViewHeightBasedOnChildren(ListView samplingSitListView) {
//        // 获取ListView对应的Adapter
//        SelectWaiterAdapter dataPhotoAddAdapter = (SelectWaiterAdapter) samplingSitListView.getAdapter();
//        if (dataPhotoAddAdapter == null) {
//            return;
//        }
//
//        int totalHeight = 0;
//        for (int i = 0, len = dataPhotoAddAdapter.getCount(); i < len; i++) {
//            // listAdapter.getCount()返回数据项的数目
//            View listItem = dataPhotoAddAdapter.getView(i, null, samplingSitListView);
//            // 计算子项View 的宽高
//            listItem.measure(0, 0);
//            // 统计所有子项的总高度
//            totalHeight += listItem.getMeasuredHeight();
//        }
//
//        ViewGroup.LayoutParams params = samplingSitListView.getLayoutParams();
//        params.height = totalHeight+ (samplingSitListView.getDividerHeight() * (dataPhotoAddAdapter.getCount() - 1));
//        // listView.getDividerHeight()获取子项间分隔符占用的高度
//        // params.height最后得到整个ListView完整显示需要的高度
//        samplingSitListView.setLayoutParams(params);
//    }
}

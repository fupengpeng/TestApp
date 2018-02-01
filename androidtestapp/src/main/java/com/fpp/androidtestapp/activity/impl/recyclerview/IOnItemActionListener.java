package com.fpp.androidtestapp.activity.impl.recyclerview;

/**
 * Created by Administrator on 2017/6/20.
 */

public interface IOnItemActionListener {
    void OnItemClick(int position);
    void OnCollect(int position);
    void AddCart(int position);
}

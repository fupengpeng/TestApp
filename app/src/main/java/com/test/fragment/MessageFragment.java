package com.test.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.fupengpeng.testapp.R;

/**
 * Created by Administrator on 2017/4/20 0020.
 */

public class MessageFragment extends Fragment{
    private static final String TAG = "MessageFragment";
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View messageLayout = inflater.inflate(R.layout.message_layout, container, false);
        Log.e(TAG, "MessageFragment-------onCreateView: " );
        return messageLayout;
    }

}
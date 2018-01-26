package com.fpp.androidtestapp.activity.impl.adapterview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.fpp.androidtestapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpinnerActivity extends AppCompatActivity {

    @BindView(R.id.spinner)
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        ButterKnife.bind(this);

        initView();


    }

    private void initView() {

        String[] arr = {"唐僧", "孙悟空", "猪八戒", "沙僧"};
        List<String> name = new ArrayList<String>();
        for (int i = 0; i < 5 ; i++) {
            name.add("名称" + i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, name);

        spinner.setAdapter(adapter);

    }
}

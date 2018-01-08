package com.fpp.androidtestapp.activity.impl.adapterview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.SimpleAdapter;

import com.fpp.androidtestapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author fupengpeng
 * @description adapterview及子类应用
 * @date 2018/1/8 0008 11:00
 */
public class AdapterViewActivity extends AppCompatActivity {

    @BindView(R.id.auto)
    AutoCompleteTextView auto;
    @BindView(R.id.mauto)
    MultiAutoCompleteTextView mauto;
    @BindView(R.id.grid01)
    GridView grid01;
    @BindView(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view);
        ButterKnife.bind(this);

        // 自动完成文本框使用AutoCompleteTextView
        autoCompleteTextView();
        gridView();
    }

    private void gridView() {

        final int[] imageIds = new int[]{
                R.drawable.shilipic, R.drawable.shilipic, R.drawable.shilipic, R.drawable.shilipic, R.drawable.shilipic,
                R.drawable.shilipic, R.drawable.shilipic, R.drawable.shilipic, R.drawable.shilipic, R.drawable.shilipic,
                R.drawable.shilipic, R.drawable.shilipic, R.drawable.shilipic, R.drawable.shilipic, R.drawable.shilipic
        };
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < imageIds.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("image", imageIds);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems

                ,R.layout.cell,new String[] {"image"},new int[] {R.id.image1}
        );
        grid01.setAdapter(simpleAdapter);
        grid01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imageView.setImageResource(imageIds[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        grid01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                imageView.setImageResource(imageIds[i]);
            }
        });


    }

    private void autoCompleteTextView() {
        String[] books = new String[]{
                "ssava",
                "ssajax",
                "ssxml",
                "ssandroid"
        };

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, books);
        auto.setAdapter(aa);
        mauto.setAdapter(aa);
        mauto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }
}

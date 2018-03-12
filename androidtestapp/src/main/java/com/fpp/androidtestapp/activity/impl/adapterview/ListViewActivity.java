package com.fpp.androidtestapp.activity.impl.adapterview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.fpp.androidtestapp.R;
import com.fpp.androidtestapp.entity.User;
import com.fpp.androidtestapp.util.LogUtils;
import com.fpp.androidtestapp.util.ToastUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author fupengpeng
 * @description ListView学习
 * @date 2018/3/12 0012 11:39
 */
public class ListViewActivity extends AppCompatActivity {

    @BindView(R.id.lv_atvt_list_view_one)
    ListView lvAtvtListViewOne;
    @BindView(R.id.lv_atvt_list_view_two)
    ListView lvAtvtListViewTwo;
    @BindView(R.id.lv_atvt_list_view_three)
    ListView lvAtvtListViewThree;
    private String[] names;
    private String[] descs;
    private int[] imageIds;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);

        initViewOne();
        initViewTwo();
        initViewThree();

    }

    /**
     * 初始化View
     */
    private void initViewOne() {
        List<String> stringList = new ArrayList<String>();
        stringList = getDateOne();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringList);
        lvAtvtListViewOne.setAdapter(arrayAdapter);
    }

    private void initViewTwo() {
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, getDateTwo(),
                R.layout.lvi_atvt_list_view_two, new String[]{"personName", "header", "desc"},
                new int[]{R.id.name, R.id.header, R.id.desc});
        lvAtvtListViewTwo.setAdapter(simpleAdapter);

        lvAtvtListViewTwo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ToastUtils.showLong(ListViewActivity.this,"单击 " + names);
            }
        });

        lvAtvtListViewTwo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ToastUtils.showLong(ListViewActivity.this,names[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                LogUtils.e("alsdf");
            }
        });


    }

    private void initViewThree() {
//        List<User> userList = new ArrayList<User>();
//        userList = getDateTwo();
//        ListViewAdapter list
//        lvAtvtListViewOne.setAdapter(arrayAdapter);

    }

    public List<String> getDateOne() {
        List<String> stringList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            stringList.add("one  " + i);
        }
        return stringList;
    }


    private List<Map<String, Object>> getDateTwo() {
        names = new String[]{"张三", "李四", "王五", "王六"};
        descs = new String[]{"姓张", "姓李", "名五", "名六"};
        imageIds = new int[]{R.drawable.shilipic, R.drawable.shilipic, R.drawable.shilipic, R.drawable.shilipic};
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("header", imageIds[i]);
            listItem.put("personName", names[i]);
            listItem.put("desc", descs[i]);
            listItems.add(listItem);

        }

        return listItems;

    }

    public List<User> getDateThree() {
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId("id " + i);
            userList.add(user);
        }
        return userList;
    }


}

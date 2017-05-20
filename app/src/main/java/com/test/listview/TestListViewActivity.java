package com.test.listview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.test.fupengpeng.testapp.R;

/**
 * Created by Administrator on 2017/4/19 0019.
 */

public class TestListViewActivity extends Activity {
    private static final String[] strs = new String[] {
        "first", "second", "third", "fourth", "fifth"
    };//定义一个String数组用来显示ListView的内容
    private ListView lv;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_listview);
        Log.e("ssssssssss", "onCreate: ");

        lv = (ListView) findViewById(R.id.lv);//得到ListView对象的引用

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //点击后在标题上显示点击了第几行
                setTitle("你点击了第"+position+"行");
            }
        });

/*为ListView设置Adapter来绑定数据*/
        lv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strs));
//                android.R.layout.simple_list_item_single_choice,strs));
//        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

//                android.R.layout.simple_list_item_multiple_choice, strs));
//        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

//                android.R.layout.simple_list_item_checked, strs));
//        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }
}
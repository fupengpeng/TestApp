package com.fupengpeng.selectall.selecttitle;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

import com.fupengpeng.selectall.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main2Activity extends Activity {
    public static final String TAG = "Main2Activity";
    TextView tv = null;
    ListView lv = null;
    Button btn_selectAll = null;
    Button btn_inverseSelect = null;
    CheckBox checkBox = null;
    Button btn_calcel = null;
    String name[] = { "G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9",
            "G10", "G11", "G12", "G13", "G14" };

    ArrayList<String> listStr = null;
    private List<HashMap<String, Object>> list = null;
    private MyAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = (TextView) this.findViewById(R.id.tv);
        lv = (ListView) this.findViewById(R.id.lv);
        btn_selectAll = (Button) this.findViewById(R.id.selectall);
        btn_inverseSelect = (Button) this.findViewById(R.id.inverseselect);
        btn_calcel = (Button) this.findViewById(R.id.cancel);
        checkBox = (CheckBox) findViewById(R.id.checkbox);
        showCheckBoxListView();

        //全选
        btn_selectAll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                listStr = new ArrayList<String>();
                for(int i=0;i<list.size();i++){
                    MyAdapter.isSelected.put(i,true);
                    listStr.add(name[i]);
                }
                adapter.notifyDataSetChanged();//注意这一句必须加上，否则checkbox无法正常更新状态
                tv.setText("已选中"+listStr.size()+"项");
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    for(int i=0;i<list.size();i++){
                        if(MyAdapter.isSelected.get(i)==true){
                            MyAdapter.isSelected.put(i, false);
                            listStr.remove(name[i]);
                        }
                    }
                    adapter.notifyDataSetChanged();
                    tv.setText("已选中"+listStr.size()+"项");
                }else {
                    listStr = new ArrayList<String>();
                    for(int i=0;i<list.size();i++){
                        MyAdapter.isSelected.put(i,true);
                        listStr.add(name[i]);
                    }
                    adapter.notifyDataSetChanged();//注意这一句必须加上，否则checkbox无法正常更新状态
                    tv.setText("已选中"+listStr.size()+"项");
                }
            }
        });

        //反选
        btn_inverseSelect.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for(int i=0;i<list.size();i++){
                    if(MyAdapter.isSelected.get(i)==false){
                        MyAdapter.isSelected.put(i, true);
                        listStr.add(name[i]);
                    }
                    else{
                        MyAdapter.isSelected.put(i, false);
                        listStr.remove(name[i]);
                    }
                }
                adapter.notifyDataSetChanged();
                tv.setText("已选中"+listStr.size()+"项");
            }

        });

        //取消已选
        btn_calcel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for(int i=0;i<list.size();i++){
                    if(MyAdapter.isSelected.get(i)==true){
                        MyAdapter.isSelected.put(i, false);
                        listStr.remove(name[i]);
                    }
                }
                adapter.notifyDataSetChanged();
                tv.setText("已选中"+listStr.size()+"项");
            }

        });
    }

    // 显示带有checkbox的listview
    public void showCheckBoxListView() {
        list = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < name.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("item_tv", name[i]);
            Log.e(TAG, "showCheckBoxListView: "+"----003----" );
            map.put("item_cb", false);
            list.add(map);
            Log.e(TAG, "showCheckBoxListView: ==list=="+list.size()+"====" );
            Log.e(TAG, "showCheckBoxListView: ==name=="+name.length+"====" );

            adapter = new MyAdapter(this, list, R.layout.listviewitem,
                    new String[] { "item_tv", "item_cb" }, new int[] {
                    R.id.item_tv, R.id.item_cb });
            lv.setAdapter(adapter);
            listStr = new ArrayList<String>();
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View view,
                                        int position, long arg3) {
                    ViewHolder holder = (ViewHolder) view.getTag();

                    // 在每次获取点击的item时改变checkbox的状态
                    holder.cb.toggle();
                    // 同时修改map的值保存状态
                    MyAdapter.isSelected.put(position, holder.cb.isChecked());
                    Log.e(TAG, "onItemClick: "+"----"+holder.cb.isChecked() +"----");

                    for (int j = 0; j < MyAdapter.isSelected.size(); j++) {
                        Log.e(TAG, "onItemClick: ======"+ MyAdapter.isSelected.get(position).booleanValue());
                        if (MyAdapter.isSelected.get(position).booleanValue()){
                            Log.e(TAG, "onItemClick: "+"----------------" );
                        }
                    }

                    if (holder.cb.isChecked() == true) {
                        Log.e(TAG, "onItemClick: "+"----001----" );

                        listStr.add(name[position]);
                        Log.e(TAG, "onItemClick: "+"--listStr--"+listStr.size()+"----" );
                        Log.e(TAG, "onItemClick: "+"--name--"+name.length+"----" );

                        if (listStr.size()==name.length){
                            Log.e(TAG, "onItemClick: "+"??????????????" );
                            checkBox.setChecked(true);
                        }
                    } else {
                        Log.e(TAG, "onItemClick: "+"----002----" );
                        listStr.remove(name[position]);
                        Log.e(TAG, "onItemClick:111 "+"--listStr--"+listStr.size()+"----" );
                        Log.e(TAG, "onItemClick:111 "+"--name--"+name.length+"----" );
                        if (listStr.size() == name.length-1){
                            Log.e(TAG, "onItemClick:222 "+"--listStr--"+listStr.size()+"----" );
                            Log.e(TAG, "onItemClick:222 "+"--name--"+name.length+"----" );
                            checkBox.setChecked(false);
                        }
                    }

                    tv.setText("已选中"+listStr.size()+"项");
                }

            });
        }

    }

}

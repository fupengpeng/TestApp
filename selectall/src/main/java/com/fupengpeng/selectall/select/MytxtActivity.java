package com.fupengpeng.selectall.select;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.fupengpeng.selectall.MainActivity;
import com.fupengpeng.selectall.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MytxtActivity extends Activity implements View.OnClickListener,
        AdapterView.OnItemClickListener {
    ListView mytextlist;
    List<MytxtBean> datalistm = new ArrayList<MytxtBean>();
    MytxtBean bean;
    ImageButton backbtn;
    Mytxtl_list_adapter myadapter;
    TextView caogaotv,searchtv;
    public static Map<Integer, Boolean> checkPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
// TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mytext_view);
        init();
    }


    private void init() {
// TODO Auto-generated method stub


        caogaotv = (TextView) findViewById(R.id.caogaotv);
        searchtv = (TextView) findViewById(R.id.searchtv);

        mytextlist = (ListView) findViewById(R.id.mytext_list);
        setlistdata();
        backbtn = (ImageButton) findViewById(R.id.mytextback);
        backbtn.setOnClickListener(this);
        caogaotv.setOnClickListener(this);
        searchtv.setOnClickListener(this);

        checkPos = new HashMap<Integer, Boolean>();
        for (int i = 0; i < datalistm.size(); i++) {
            checkPos.put(i, false);
        }
    }


    private void setlistdata() {
        for (int i = 9; i < 15; i++) {

            bean = new MytxtBean(MytxtData.CBDATA[0], MytxtData.DINGGAODATA[0],
                    MytxtData.LEIXINGDATA[0], MytxtData.PERSON[0],
                    MytxtData.TIME[0]);
            datalistm.add(bean);
        }
        myadapter = new Mytxtl_list_adapter(MytxtActivity.this, datalistm);
        mytextlist.setAdapter(myadapter);


        mytextlist.setItemsCanFocus(true);
        mytextlist.setOnItemClickListener(this);



    }


    @Override
    public void onClick(View arg0) {
// TODO Auto-generated method stub


        switch (arg0.getId()) {
            case R.id.mytextback:
                Intent intent = new Intent(MytxtActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.caogaotv:
            case R.id.searchtv:

                Toast.makeText(MytxtActivity.this, "没有提供界面", Toast.LENGTH_SHORT).show();
                break;


        }


    }


    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
// TODO Auto-generated method stub
        System.out.println("第"+arg2+"项");


        new AlertDialog.Builder(this).setIcon(R.drawable.ic_about)
                .setTitle("hello：")
                .setMessage(datalistm.get(arg2).getCbdata())
                .setNegativeButton("退出", new DialogInterface.OnClickListener() {


                    @Override
                    public void onClick(DialogInterface dialog, int which) {
// TODO Auto-generated method stub
                        dialog.cancel();


                    }
                }).show();


    }
}

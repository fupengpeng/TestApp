package com.test.ScreenClass.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.test.fupengpeng.testapp.R;

public class ScreenActivity extends AppCompatActivity {

    private Button listlistview, listgridview, expandableListView,
            expandableGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listlistview = (Button) findViewById(R.id.listlist);
        listgridview = (Button) findViewById(R.id.listgrid);
        expandableListView = (Button) findViewById(R.id.expandableListView);
        expandableGridView = (Button) findViewById(R.id.expandableGridView);

        listlistview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ScreenActivity.this, ListListActivity.class);
                startActivity(intent);
            }
        });

        listgridview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ScreenActivity.this, ScrollGridActivity.class);
                startActivity(intent);
            }
        });

        expandableListView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ScreenActivity.this,
                        ExpandableListViewActivity.class);
                startActivity(intent);
            }
        });

        expandableGridView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ScreenActivity.this,
                        ExpandableGridViewActivity.class);
                startActivity(intent);
            }
        });
    }

}
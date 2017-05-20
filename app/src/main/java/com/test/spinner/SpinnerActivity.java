package com.test.spinner;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.test.fupengpeng.testapp.R;


public class SpinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.colors
        ,android.R.layout.simple_spinner_item);

        spinner.setAdapter(adapter);
//        spinner.setPopupBackgroundResource(R.drawable.hua);//下拉菜单的背景
        spinner.setEnabled(true);//是否可点击

        AdapterView.OnItemSelectedListener onItemSelectedListener =
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(SpinnerActivity.this,"选择的色彩： " +
                                        parent.getItemAtPosition(position).toString(),
                                Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                };

                spinner.setOnItemSelectedListener(onItemSelectedListener);
    }
}

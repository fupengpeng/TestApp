package com.test.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.test.fupengpeng.testapp.R;

public class CheckBoxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        final CheckBox checkBox001  = (CheckBox) findViewById(R.id.check_box_001);
        final CheckBox checkBox002  = (CheckBox) findViewById(R.id.check_box_002);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!((CheckBox)v).isChecked()){
                    Toast.makeText(CheckBoxActivity.this,
                            "\""+((Button)v).getText()+"\"被取消",
                            Toast.LENGTH_SHORT).show();
                }
            }
        };

        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(CheckBoxActivity.this,
                            "\""+buttonView.getText()+"\"被选择",
                            Toast.LENGTH_SHORT).show();
                }
            }
        };

//        checkBox001.setOnCheckedChangeListener(onCheckedChangeListener);
//        checkBox002.setOnCheckedChangeListener(onCheckedChangeListener);
        checkBox001.setOnClickListener(onClickListener);
        checkBox002.setOnClickListener(onClickListener);


    }
}

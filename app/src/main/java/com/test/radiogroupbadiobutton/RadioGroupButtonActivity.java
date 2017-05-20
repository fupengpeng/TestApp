package com.test.radiogroupbadiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.test.fupengpeng.testapp.R;

public class RadioGroupButtonActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_group_button);
        RadioButton radioButton001 = (RadioButton) findViewById(R.id.radio_button_001);
        RadioButton radioButton002 = (RadioButton) findViewById(R.id.radio_button_002);
        RadioButton radioButton003 = (RadioButton) findViewById(R.id.radio_button_003);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.radio_button_001:
                Toast.makeText(RadioGroupButtonActivity.this,"点击第一个",Toast.LENGTH_LONG).show();
                break;
            case R.id.radio_button_002:
                Toast.makeText(RadioGroupButtonActivity.this,"点击第二个",Toast.LENGTH_LONG).show();
                break;
            case R.id.radio_button_003:
                Toast.makeText(RadioGroupButtonActivity.this,"点击第三个",Toast.LENGTH_LONG).show();
                break;

        }
    }
}

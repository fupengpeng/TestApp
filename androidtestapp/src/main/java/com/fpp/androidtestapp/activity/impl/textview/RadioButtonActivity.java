package com.fpp.androidtestapp.activity.impl.textview;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.fpp.androidtestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author fupengpeng
 * @description RadioButton 、 Checkbox 、ToggleButton 、 Switch 简单应用
 * @date 2018/1/8 0008 10:13
 */
public class RadioButtonActivity extends AppCompatActivity {

    @BindView(R.id.male)
    RadioButton male;
    @BindView(R.id.female)
    RadioButton female;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.show)
    TextView show;
    @BindView(R.id.toggle)
    ToggleButton toggle;
    @BindView(R.id.switcher)
    Switch switcher;
    @BindView(R.id.test)
    LinearLayout test;
    @BindView(R.id.start)
    Button start;
    @BindView(R.id.chronomer)
    Chronometer chronomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        ButterKnife.bind(this);

        radioButtonCheckbox();
        toggleButtonSwitch();
        chronometer();


    }

    private void chronometer() {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronomer.setBase(SystemClock.elapsedRealtime());
                chronomer.start();
                start.setEnabled(false);

            }
        });
        chronomer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime() - chronometer.getBase() > 20*1000){
                    chronomer.stop();
                    start.setEnabled(true);
                }
            }
        });


    }

    private void toggleButtonSwitch() {
        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    test.setOrientation(LinearLayout.VERTICAL);
                    toggle.setChecked(true);
                    switcher.setChecked(true);
                } else {
                    test.setOrientation(LinearLayout.HORIZONTAL);
                    toggle.setChecked(false);
                    switcher.setChecked(false);
                }

            }
        };
        toggle.setOnCheckedChangeListener(listener);
        switcher.setOnCheckedChangeListener(listener);

    }

    private void radioButtonCheckbox() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                String tip = i == R.id.male ? "你的性别是男人！" : "你的性别是女人！";
                show.setText(tip);
            }
        });
    }
}

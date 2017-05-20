package com.test.test05;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;


import com.test.fupengpeng.testapp.R;

import java.util.Calendar;

/**
 * Created by Administrator on 2017/4/19 0019.
 * 获取当前时间，并修改展示时间
 */

public class TimeActivity extends Activity{
    // 记录当前的时间
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        DatePicker date = (DatePicker) findViewById(R.id.datePicker);
        TimePicker time = (TimePicker) findViewById(R.id.timePicker);
        // 获取当前的年月日，小时，分钟
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);

        // 初始化DatePicker
        date.init(year, month, day, new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker arg0, int year, int month,
                                      int day) {
                TimeActivity.this.year = year;
                TimeActivity.this.month = month;
                TimeActivity.this.day = day;
                // 显示当前时间和日期
                showDate(year, month, day, hour, minute);
            }

        });

        // 为TimerPicker指定事件监听器
        time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            @Override
            public void onTimeChanged(TimePicker arg0, int hour, int minute) {
                TimeActivity.this.hour = hour;
                TimeActivity.this.minute = minute;
            }
        });
    }

    protected void showDate(int year2, int month2, int day2, int hour2,
                            int minute2) {
        EditText text = (EditText) findViewById(R.id.show);
        text.setText("您的购买时间为：" + year2 + "年" + month2 + "月" + day2 + "日"
                + hour2 + "时" + minute2 + "分");

    }
}

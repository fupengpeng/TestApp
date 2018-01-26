package com.fpp.androidtestapp.activity.impl.datetimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.fpp.androidtestapp.R;

import java.util.Calendar;

public class DateTimePackerActivity extends AppCompatActivity {

    private int year, month, day, hour, minute;
    DatePicker datePicker;
    TimePicker timePicker;
    EditText show;
    Button btnDate, btnTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_packer);
        initView();


    }

    private void initView() {
        datePicker = (DatePicker) findViewById(R.id.date_picker);
        timePicker = (TimePicker) findViewById(R.id.time_picker);
        show = (EditText) findViewById(R.id.show);
        btnDate = (Button) findViewById(R.id.btn_date);
        btnTime = (Button) findViewById(R.id.btn_time);
        btnDate.setOnClickListener(onClickListener);
        btnTime.setOnClickListener(onClickListener);


        // 获取当期日期时间
        Calendar calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);

        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                DateTimePackerActivity.this.year = year;
                DateTimePackerActivity.this.month = month;
                DateTimePackerActivity.this.day = day;
                //显示当前日期时间
                showDate(year, month, day, hour, minute);

            }
        });

        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
                DateTimePackerActivity.this.hour = hour;
                DateTimePackerActivity.this.minute = minute;
                //显示当前日期时间
                showDate(year, month, day, hour, minute);
            }
        });


    }

    private void showDate(int year, int month, int day, int hour, int minute) {


        show.setText("你的购买日期为：" + year + "年" + (month + 1) + "月" + day + "日  " + hour + "时" + minute + "分");

    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_date:
                    DatePickerDialog datePicker = new DatePickerDialog(DateTimePackerActivity.this, new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear,
                                              int dayOfMonth) {
                            // TODO Auto-generated method stub
                            Toast.makeText(DateTimePackerActivity.this, year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
                        }
                    }, 2013, 7, 20);
                    datePicker.show();
                    break;
                case R.id.btn_time:
                    TimePickerDialog time = new TimePickerDialog(DateTimePackerActivity.this, new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            // TODO Auto-generated method stub
                            Toast.makeText(DateTimePackerActivity.this, hourOfDay + "hour " + minute + "minute", Toast.LENGTH_SHORT).show();
                        }
                    }, 18, 25, true);
                    time.show();
                    break;
            }
        }
    };

}

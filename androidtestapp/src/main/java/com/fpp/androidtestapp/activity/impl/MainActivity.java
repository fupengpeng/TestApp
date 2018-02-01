package com.fpp.androidtestapp.activity.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fpp.androidtestapp.R;
import com.fpp.androidtestapp.activity.impl.adapterview.AdapterViewActivity;
import com.fpp.androidtestapp.activity.impl.adapterview.ExpandableListViewActivity;
import com.fpp.androidtestapp.activity.impl.adapterview.SpinnerActivity;
import com.fpp.androidtestapp.activity.impl.customimageview.ImageViewActivity;
import com.fpp.androidtestapp.activity.impl.customimageview.ImageViewTwoActivity;
import com.fpp.androidtestapp.activity.impl.datetimepicker.DateTimePackerActivity;
import com.fpp.androidtestapp.activity.impl.numberpicker.NumberPickerActivity;
import com.fpp.androidtestapp.activity.impl.recyclerview.RecyclerViewActivity;
import com.fpp.androidtestapp.activity.impl.textview.RadioButtonActivity;
import com.fpp.androidtestapp.activity.impl.titlebar.ToolBarActivity;
import com.fpp.androidtestapp.activity.impl.wheelview.WheelViewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author fupengpeng
 * @description 安卓知识点总结
 * @date 2017/12/21 0021 9:24
 */

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.iv_title_activity_left)
    ImageView ivTitleActivityLeft;
    @BindView(R.id.tv_title_activity_left)
    TextView tvTitleActivityLeft;
    @BindView(R.id.tv_title_activity_title)
    TextView tvTitleActivityTitle;
    @BindView(R.id.tv_title_activity_right)
    TextView tvTitleActivityRight;
    @BindView(R.id.iv_title_activity_right)
    ImageView ivTitleActivityRight;
    @BindView(R.id.btn_atvt_main_one)
    Button btnAtvtMainOne;
    @BindView(R.id.btn_atvt_main_two)
    Button btnAtvtMainTwo;
    @BindView(R.id.btn_atvt_main_three)
    Button btnAtvtMainThree;
    @BindView(R.id.btn_atvt_main_four)
    Button btnAtvtMainFour;
    @BindView(R.id.btn_atvt_main_five)
    Button btnAtvtMainFive;
    @BindView(R.id.btn_atvt_main_six)
    Button btnAtvtMainSix;
    @BindView(R.id.btn_atvt_main_seven)
    Button btnAtvtMainSeven;
    @BindView(R.id.btn_atvt_main_eight)
    Button btnAtvtMainEight;
    @BindView(R.id.btn_atvt_main_nine)
    Button btnAtvtMainNine;
    @BindView(R.id.btn_atvt_main_ten)
    Button btnAtvtMainTen;
    @BindView(R.id.btn_atvt_main_eleven)
    Button btnAtvtMainEleven;
    @BindView(R.id.btn_atvt_main_twelve)
    Button btnAtvtMainTwelve;
    @BindView(R.id.btn_atvt_main_thirteen)
    Button btnAtvtMainThirteen;
    @BindView(R.id.btn_atvt_main_fourteen)
    Button btnAtvtMainFourteen;
    @BindView(R.id.btn_atvt_main_fifteen)
    Button btnAtvtMainFifteen;
    @BindView(R.id.btn_atvt_main_sixteen)
    Button btnAtvtMainSixteen;
    @BindView(R.id.btn_atvt_main_seventeen)
    Button btnAtvtMainSeventeen;
    @BindView(R.id.btn_atvt_main_eighteen)
    Button btnAtvtMainEighteen;
    @BindView(R.id.btn_atvt_main_nineteen)
    Button btnAtvtMainNineteen;
    @BindView(R.id.btn_atvt_main_twenty)
    Button btnAtvtMainTwenty;
    @BindView(R.id.btn_atvt_main_twenty_one)
    Button btnAtvtMainTwentyOne;
    @BindView(R.id.btn_atvt_main_twenty_two)
    Button btnAtvtMainTwentyTwo;
    @BindView(R.id.btn_atvt_main_twenty_three)
    Button btnAtvtMainTwentyThree;
    @BindView(R.id.btn_atvt_main_twenty_four)
    Button btnAtvtMainTwentyFour;
    @BindView(R.id.btn_atvt_main_twenty_five)
    Button btnAtvtMainTwentyFive;
    @BindView(R.id.btn_atvt_main_twenty_six)
    Button btnAtvtMainTwentySix;
    @BindView(R.id.btn_atvt_main_twenty_seven)
    Button btnAtvtMainTwentySeven;
    @BindView(R.id.btn_atvt_main_twenty_eight)
    Button btnAtvtMainTwentyEight;
    @BindView(R.id.btn_atvt_main_twenty_nine)
    Button btnAtvtMainTwentyNine;
    @BindView(R.id.drawerLayout)
    LinearLayout drawerLayout;

    Intent intent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tvTitleActivityTitle.setText("安卓总结");

        initView();


    }

    private void initView() {


    }

    @OnClick({R.id.btn_atvt_main_one, R.id.btn_atvt_main_two, R.id.btn_atvt_main_three, R.id.btn_atvt_main_four,
            R.id.btn_atvt_main_five, R.id.btn_atvt_main_six, R.id.btn_atvt_main_seven, R.id.btn_atvt_main_eight,
            R.id.btn_atvt_main_nine, R.id.btn_atvt_main_ten, R.id.btn_atvt_main_eleven, R.id.btn_atvt_main_twelve,
            R.id.btn_atvt_main_thirteen, R.id.btn_atvt_main_fourteen, R.id.btn_atvt_main_fifteen, R.id.btn_atvt_main_sixteen,
            R.id.btn_atvt_main_seventeen, R.id.btn_atvt_main_eighteen, R.id.btn_atvt_main_nineteen, R.id.btn_atvt_main_twenty,
            R.id.btn_atvt_main_twenty_one, R.id.btn_atvt_main_twenty_two, R.id.btn_atvt_main_twenty_three, R.id.btn_atvt_main_twenty_four,
            R.id.btn_atvt_main_twenty_five, R.id.btn_atvt_main_twenty_six, R.id.btn_atvt_main_twenty_seven, R.id.btn_atvt_main_twenty_eight,
            R.id.btn_atvt_main_twenty_nine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_atvt_main_one:
                intent = new Intent(this, ImageViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_two:
                intent = new Intent(this, ImageViewTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_three:
                intent = new Intent(this, com.fpp.androidtestapp.activity.impl.imageview.ImageViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_four:
                intent = new Intent(this, RadioButtonActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_five:
                intent = new Intent(this, AdapterViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_six:
                intent = new Intent(this, ExpandableListViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_seven:
                intent = new Intent(this, SpinnerActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_eight:
                intent = new Intent(this, RecyclerViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_nine:
                intent = new Intent(this, DateTimePackerActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_ten:
                intent = new Intent(this, WheelViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_eleven:
                intent = new Intent(this, NumberPickerActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_twelve:
                intent = new Intent(this, ToolBarActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_thirteen:
                intent = new Intent(this, ImageViewTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_fourteen:
                intent = new Intent(this, ImageViewTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_fifteen:
                intent = new Intent(this, ImageViewTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_sixteen:
                intent = new Intent(this, ImageViewTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_seventeen:
                intent = new Intent(this, ImageViewTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_eighteen:
                intent = new Intent(this, ImageViewTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_nineteen:
                intent = new Intent(this, ImageViewTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_twenty:
                intent = new Intent(this, ImageViewTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_twenty_one:
                intent = new Intent(this, ImageViewTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_twenty_two:
                intent = new Intent(this, ImageViewTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_twenty_three:
                intent = new Intent(this, ImageViewTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_twenty_four:
                intent = new Intent(this, ImageViewTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_twenty_five:
                intent = new Intent(this, ImageViewTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_twenty_six:
                intent = new Intent(this, ImageViewTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_twenty_seven:
                intent = new Intent(this, ImageViewTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_twenty_eight:
                intent = new Intent(this, ImageViewTwoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_atvt_main_twenty_nine:
                intent = new Intent(this, ImageViewTwoActivity.class);
                startActivity(intent);
                break;
        }
    }
}

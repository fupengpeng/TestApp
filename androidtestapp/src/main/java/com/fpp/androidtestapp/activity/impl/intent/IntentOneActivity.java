package com.fpp.androidtestapp.activity.impl.intent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.fpp.androidtestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IntentOneActivity extends AppCompatActivity {


    public static final String THREE_ACTION = "com.fpp.androidtestapp.activity.impl.intent.THREE_ACTION";
    public static final int PICK_CONTACT = 0;
    @BindView(R.id.et_atvt_intent_one_name)
    EditText etAtvtIntentOneName;
    @BindView(R.id.et_atvt_intent_one_number)
    EditText etAtvtIntentOneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_one);
        ButterKnife.bind(this);
    }

    public void skipIntentTwoActivity(View source) {
        // 创建ComponentName对象
        ComponentName cn = new ComponentName(IntentOneActivity.this, IntentTwoActivity.class);
        Intent intent = new Intent();
        // 为Intent设置 Component属性
        intent.setComponent(cn);
        startActivity(intent);
    }

    public void skipIntentThreeActivity(View source) {
        Intent intent = new Intent();
        // 为Intent设置 Action属性
        intent.setAction(IntentOneActivity.THREE_ACTION);
        // 为Intent设置 Category属性
        intent.addCategory("category");
        startActivity(intent);
    }

    public void lookOverLinkman(View source) {
        Intent intent = new Intent();
        // 为Intent设置 Action属性
        intent.setAction(Intent.ACTION_GET_CONTENT);
        // 为Intent设置 Type属性
        intent.setType("vnd.android.cursor.item/phone");
        // 启动Activity，希望获取该Activity的结果
        startActivityForResult(intent, PICK_CONTACT);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PICK_CONTACT:
                if (resultCode == Activity.RESULT_OK) {
                    // 获取返回数据
                    Uri contactData = data.getData();
                    CursorLoader cursorLoader = new CursorLoader(this, contactData, null, null, null, null);
                    // 查询联系人信息
                    Cursor cursor = cursorLoader.loadInBackground();
                    // 如果查询到此联系人
                    if (cursor.moveToFirst()) {
                        String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                        // 获取联系人名称
                        String name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
                        String phoneNumger = "此联系人暂未输入电话号码！";
                        // 根据联系人查询该联系人的详细信息
                        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId, null, null);
                        if (phones.moveToFirst()) {
                            // 取出电话号码
                            phoneNumger = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        }
                        // 关闭游标
                        phones.close();
                        etAtvtIntentOneName.setText(name);
                        etAtvtIntentOneNumber.setText(phoneNumger);
                    }
                    // 关闭游标
                    cursor.close();
                }
                break;
        }

    }

    public void returnHome(View source) {
        Intent intent = new Intent();
        // 为Intent设置 Action属性
        intent.setAction(Intent.ACTION_MAIN);
        // 为Intent设置 Category 属性
        intent.addCategory(Intent.CATEGORY_HOME);
        // 启动Activity，
        startActivity(intent);
    }

    public void skipIntentFourActivity(View source) {
        Intent intent = new Intent(this, IntentFourActivity.class);
        startActivity(intent);
    }

    public void scheme(View source) {
        Intent intent = new Intent(this, IntentFiveActivity.class);
        // 设置Data属性
        intent.setData(Uri.parse("zhi://www.fpps.com:8008/test"));
        startActivity(intent);
    }
    public void schemeHostPort(View source) {
        Intent intent = new Intent(this, IntentSixActivity.class);
        // 设置Data属性
        intent.setData(Uri.parse("zhi://www.fpp.com:8088/test"));
        startActivity(intent);
    }
    public void schemeHostPast(View source) {
        Intent intent = new Intent(this, IntentSevenActivity.class);
        // 设置Data属性
        intent.setData(Uri.parse("zhi://www.fpp.com:8080/tests"));
        startActivity(intent);
    }
    public void schemeHostPastPath(View source) {
        Intent intent = new Intent(this, IntentEightActivity.class);
        // 设置Data属性
        intent.setData(Uri.parse("zhi://www.fpp.com:8088/tests"));
        startActivity(intent);
    }

    public void schemeHostPastPathType(View source) {
        Intent intent = new Intent(this, IntentNineActivity.class);
        // 设置Data属性
        intent.setDataAndType(Uri.parse("zhi://www.fpp.com:8088/tests"),"abc/xyz");
        startActivity(intent);
    }


}

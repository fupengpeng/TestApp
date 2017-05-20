package com.test.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.test.fupengpeng.testapp.R;
import com.test.json.entity.Data;
import com.test.json.entity.Forecast;
import com.test.json.entity.Weather;
import com.test.json.entity.Yesterday;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONActivity extends AppCompatActivity {
    String TAG = "aaa";
    Weather wea;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        textView = (TextView) findViewById(R.id.text);
        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: "+"点击按钮事件" );

                //要解析的对象
                String json="{ 'desc': 'OK', 'status': 1000, 'data': { 'wendu': '20', 'ganmao': " +
                        "'相对于今天将会出现大幅度降温，易发生感冒，请注意适当增加衣服，加强自我防护避免感冒。'," +
                        " 'forecast': [ { 'fengxiang': '北风', 'fengli': '3-4级', 'high': '高温 27℃', 'type':" +
                        " '中雨', 'low': '低温 19℃', 'date': '6日星期五' }, { 'fengxiang': '北风', 'fengli': " +
                        "'微风级', 'high': '高温 23℃', 'type': '大雨', 'low': '低温 17℃', 'date': '7日星期六' }," +
                        " { 'fengxiang': '北风', 'fengli': '微风级', 'high': '高温 26℃', 'type': '小雨'," +
                        " 'low': '低温 17℃', 'date': '8日星期天' }, { 'fengxiang': '南风', 'fengli': " +
                        "'微风级', 'high': '高温 27℃', 'type': '多云', 'low': '低温 15℃', 'date': " +
                        "'9日星期一' }, { 'fengxiang': '南风', 'fengli': '微风级', 'high': '高温 29℃'," +
                        " 'type': '多云', 'low': '低温 16℃', 'date': '10日星期二' } ], 'yesterday': " +
                        "{ 'fl': '微风', 'fx': '北风', 'high': '高温 33℃', 'type': '阴', 'low': " +
                        "'低温 22℃', 'date': '5日星期四' }, 'aqi': '58', 'city': '成都' } }";

                wea=new Weather();
//      首先看到的是一个{}所以用JSON Object来进行解析
//      获得外部的Weather
                try {
                    JSONObject obj = new JSONObject(json);
                    String desc = obj.getString("desc");
                    int status = obj.getInt("status");

                    wea.setStatus(status);
                    wea.setDesc(desc);

//      获得内部Data的数据
                    JSONObject obj1 = obj.getJSONObject("data");
                    Data data=new Data();
                    data.setWendu(obj1.getString("wendu"));
                    data.setGanmao(obj1.getString("ganmao"));
                    data.setAqi(obj1.getString("aqi"));
                    data.setCity(obj1.getString("city"));
                    wea.setData(data);
                    List<Forecast> forecasts=new ArrayList<>();

//      获取forecast数组
                    JSONArray jArr = obj1.getJSONArray("forecast");
                    for (int i = 0; i < jArr.length(); i++) {
                        JSONObject obj2 = jArr.getJSONObject(i);
                        Forecast forecast=new Forecast();
                        forecast.setDate(obj2.getString("date"));
                        forecast.setFengxiang(obj2.getString("fengxiang"));
                        forecast.setHigh(obj2.getString("high"));
                        forecast.setLow(obj2.getString("low"));
                        forecast.setFengli(obj2.getString("fengli"));
                        forecast.setType(obj2.getString("type"));
                        forecasts.add(forecast);
                    }
                    data.setForecast(forecasts);
                    JSONObject obj3 = obj1.getJSONObject("yesterday");
                    Yesterday yesterday=new Yesterday();
                    yesterday.setFl(obj3.getString("fl"));
                    yesterday.setFx(obj3.getString("fx"));
                    yesterday.setHigh(obj3.getString("high"));
                    yesterday.setType(obj3.getString("type"));
                    yesterday.setLow(obj3.getString("low"));
                    yesterday.setDate(obj3.getString("date"));
                    data.setYesterday(yesterday);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


//      输出字段
//                System.out.println(wea);
                Log.e(TAG, "onClick: "+wea.toString() );

            }
        });
//        textView.setText(wea.toString());

    }
}

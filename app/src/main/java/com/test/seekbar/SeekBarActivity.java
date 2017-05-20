package com.test.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.test.fupengpeng.testapp.R;

import org.w3c.dom.Text;

public class SeekBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekbar_001);
        final TextView textView = (TextView) findViewById(R.id.text_view_seekbar);

        seekBar.setMax(100);
        seekBar.setProgress(20);

        textView.setText("当前进度"+seekBar.getProgress());

        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText("当前进度--"+seekBar.getProgress());

                Log.e("", "onProgressChanged: " );
//                Toast.makeText(SeekBarActivity.this,"onProgressChanged",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.e("", "onStartTrackingTouch: " );
//                Toast.makeText(SeekBarActivity.this,"onStartTrackingTouch",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e("", "onStopTrackingTouch: " );
//                Toast.makeText(SeekBarActivity.this,"onStopTrackingTouch",Toast.LENGTH_LONG).show();
            }
        };
        seekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);

    }
}

package com.practice.wavedrawable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.practice.wavedrawablelib.WaveDrawable;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.waveView)
    View waveView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        WaveDrawable waveDrawable = new WaveDrawable();
        waveView.setBackgroundDrawable(waveDrawable);
    }
}

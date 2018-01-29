package com.example.mohamed.v21_stopwatch;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import at.grabner.circleprogress.CircleProgressView;

public class MainActivity extends AppCompatActivity {
Chronometer chronometer;
CircleProgressView circleProgressView;
    long time=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer=findViewById(R.id.chronometer);
        circleProgressView=findViewById(R.id.circleProgress);

    }

    public void Start(View view) {
        StopWatch stopWatch=new StopWatch();
        stopWatch.SatrtCount();
        chronometer.setBase(SystemClock.elapsedRealtime()+time);
        chronometer.start();
    }

    public void Stop(View view) {
    }
    class StopWatch{
        int progressValue=-1;
        void SatrtCount()
        {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    progressValue++;
                    circleProgressView.setValue(progressValue);
                    if (progressValue==59)
                    {
                        progressValue=-1;
                    }
                }
            },0,1000);
        }
    }
}

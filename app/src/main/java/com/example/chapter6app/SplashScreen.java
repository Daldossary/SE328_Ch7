package com.example.chapter6app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimerTask timer = new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(
                        SplashScreen.this,
                        MainActivity.class
                ));
            }
        };
        Timer openning = new Timer();
        openning.schedule(timer, 5000);
    }
}
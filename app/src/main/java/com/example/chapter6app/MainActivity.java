package com.example.chapter6app;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button micButton, recordButton;
    MediaPlayer mp1, mp2;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        micButton = (Button)findViewById(R.id.recordButton);
        recordButton = (Button)findViewById(R.id.micButton);

        micButton.setOnClickListener(micButtonF);
        recordButton.setOnClickListener(recordButtonF);

        mp1 = new MediaPlayer();
        mp1 = MediaPlayer.create(
          this, R.raw.track1
        );

        mp2 = new MediaPlayer();
        mp2 = MediaPlayer.create(
                this, R.raw.track2
        );

        playing=0; //semaphore flag
    }

    Button.OnClickListener micButtonF = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(playing) {
                case 0:
                    mp2.start();
                    playing = 1;
                    micButton.setText("Pause Music");
                    recordButton.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mp2.pause();
                    playing = 0;
                    micButton.setText("Play Mic Music");
                    recordButton.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    Button.OnClickListener recordButtonF = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(playing) {
                case 0:
                    mp1.start();
                    playing = 1;
                    recordButton.setText("Pause Music");
                    micButton.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mp1.pause();
                    playing = 0;
                    recordButton.setText("Play Mic Music");
                    micButton.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}
package com.example.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StoryDetailActivity extends AppCompatActivity {

    private ImageView storyImage, storyAvatar, btnClose;
    private TextView storyUserName, storyTime;
    private ProgressBar storyProgress;

    private Handler handler = new Handler();
    private int progressStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_detail);


        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );


        storyImage = findViewById(R.id.storyImage);
        storyAvatar = findViewById(R.id.storyAvatar);
        storyUserName = findViewById(R.id.storyUserName);
        storyTime = findViewById(R.id.storyTime);
        storyProgress = findViewById(R.id.storyProgress);
        btnClose = findViewById(R.id.btn_close);


        Intent intent = getIntent();
        if (intent != null) {
            int imageRes = intent.getIntExtra("storyImage", 0);
            String name = intent.getStringExtra("storyName");
            String time = intent.getStringExtra("storyTime");

            storyImage.setImageResource(imageRes);
            storyAvatar.setImageResource(imageRes);
            storyUserName.setText(name != null ? name : "");
            storyTime.setText(time != null ? time : "");
        }


        btnClose.setOnClickListener(v -> finish());


        startStoryTimer();
    }

    private void startStoryTimer() {
        progressStatus = 0;
        new Thread(() -> {
            while (progressStatus < 100) {
                progressStatus += 1;
                handler.post(() -> storyProgress.setProgress(progressStatus));

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            finish();
        }).start();
    }
}

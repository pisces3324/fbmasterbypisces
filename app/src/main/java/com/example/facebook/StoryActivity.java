package com.example.facebook;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StoryActivity extends AppCompatActivity {

    ProgressBar storyProgress;
    ImageView storyImageView, btnClose;
    TextView userName;

    private Handler handler = new Handler();
    private int progressStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_detail);


        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );

        storyProgress = findViewById(R.id.storyProgress);
        storyImageView = findViewById(R.id.storyImage);
        btnClose = findViewById(R.id.btn_close);
        userName = findViewById(R.id.storyUserName);


        int imageRes = getIntent().getIntExtra("storyImage", 0);
        String name = getIntent().getStringExtra("storyName");

        storyImageView.setImageResource(imageRes);
        userName.setText(name);

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

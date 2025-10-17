package com.example.facebook;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PrivacyActivity extends AppCompatActivity {

    private ImageView imgBack;
    private LinearLayout privacy1, privacy2, privacy3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);

        imgBack = findViewById(R.id.imgBack);
        privacy1 = findViewById(R.id.privacy1);
        privacy2 = findViewById(R.id.privacy2);
        privacy3 = findViewById(R.id.privacy3);


        imgBack.setOnClickListener(v -> finish());


        privacy1.setOnClickListener(v ->
                Toast.makeText(PrivacyActivity.this, "Chỉnh sửa quyền xem bài viết", Toast.LENGTH_SHORT).show());

        privacy2.setOnClickListener(v ->
                Toast.makeText(PrivacyActivity.this, "Chỉnh sửa quyền xem thông tin cá nhân", Toast.LENGTH_SHORT).show());

        privacy3.setOnClickListener(v ->
                Toast.makeText(PrivacyActivity.this, "Chỉnh sửa quyền tìm kiếm và kết nối", Toast.LENGTH_SHORT).show());
    }
}

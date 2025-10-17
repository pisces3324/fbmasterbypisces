package com.example.facebook;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private ImageView imgBack;
    private LinearLayout layoutAccount, layoutPrivacy, layoutNotifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        imgBack = findViewById(R.id.imgBack);
        layoutAccount = findViewById(R.id.layoutAccount);
        layoutPrivacy = findViewById(R.id.layoutPrivacy);
        layoutNotifications = findViewById(R.id.layoutNotifications);


        imgBack.setOnClickListener(v -> finish());


        layoutAccount.setOnClickListener(v ->
                Toast.makeText(SettingsActivity.this, "Mở cài đặt tài khoản", Toast.LENGTH_SHORT).show());

        layoutPrivacy.setOnClickListener(v ->
                Toast.makeText(SettingsActivity.this, "Mở cài đặt quyền riêng tư", Toast.LENGTH_SHORT).show());

        layoutNotifications.setOnClickListener(v ->
                Toast.makeText(SettingsActivity.this, "Mở cài đặt thông báo", Toast.LENGTH_SHORT).show());
    }
}
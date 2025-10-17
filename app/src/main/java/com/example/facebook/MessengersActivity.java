package com.example.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MessengersActivity extends AppCompatActivity {

    private ImageView imgEdit, imgLogo;
    private ImageView imgSearch, imgQRCode;
    private ImageView profile1, profile2, profile3;
    private TextView textName1, textName2, textName3;
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messengers);


        imgEdit = findViewById(R.id.imageView);
        imgLogo = findViewById(R.id.imageView1);

        imgEdit.setOnClickListener(v ->
                Toast.makeText(this, "Tạo tin nhắn mới", Toast.LENGTH_SHORT).show()
        );

        imgLogo.setOnClickListener(v ->
                Toast.makeText(this, "Logo Messenger", Toast.LENGTH_SHORT).show()
        );


        profile1 = findViewById(R.id.imageView);
        textName1 = findViewById(R.id.textName);

        profile2 = findViewById(R.id.imageView1);
        textName2 = findViewById(R.id.textName1);

        profile3 = findViewById(R.id.imageView2);
        textName3 = findViewById(R.id.textName2);

        profile1.setOnClickListener(v -> openProfile(textName1.getText().toString()));
        profile2.setOnClickListener(v -> openProfile(textName2.getText().toString()));
        profile3.setOnClickListener(v -> openProfile(textName3.getText().toString()));

        bottomNav = findViewById(R.id.bottomNavMessenger);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_chat) {
                Toast.makeText(this, "Chat clicked", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_friends) {
                Toast.makeText(this, "Friends clicked", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_notifications) {
                Toast.makeText(this, "Notifications clicked", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_menu) {
                Toast.makeText(this, "Menu clicked", Toast.LENGTH_SHORT).show();
            }
            return true;
        });

    }

    private void openProfile(String name) {
        Toast.makeText(this, "Mở trang cá nhân của " + name, Toast.LENGTH_SHORT).show();
    }
}

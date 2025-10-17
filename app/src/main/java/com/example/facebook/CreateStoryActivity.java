package com.example.facebook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CreateStoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_story);

        ImageView btnExit = findViewById(R.id.btn_exit);
        ImageView btnCamera = findViewById(R.id.btn_camera);
        ImageView btnUser = findViewById(R.id.btn_user);

        btnExit.setOnClickListener(v -> finish());
        btnCamera.setOnClickListener(v ->
                Toast.makeText(this, "Mở camera", Toast.LENGTH_SHORT).show());
        btnUser.setOnClickListener(v ->
                Toast.makeText(this, "Trang cá nhân", Toast.LENGTH_SHORT).show());
    }
}

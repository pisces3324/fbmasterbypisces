package com.example.facebook;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SavedPostsActivity extends AppCompatActivity {

    private ImageView imgBack;
    private LinearLayout post1, post2, post3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_posts);

        imgBack = findViewById(R.id.imgBack);
        post1 = findViewById(R.id.post1);
        post2 = findViewById(R.id.post2);
        post3 = findViewById(R.id.post3);

        imgBack.setOnClickListener(v -> finish());
        post1.setOnClickListener(v ->
                Toast.makeText(SavedPostsActivity.this, "Đã mở bài viết 1", Toast.LENGTH_SHORT).show());
        post2.setOnClickListener(v ->
                Toast.makeText(SavedPostsActivity.this, "Đã mở bài viết 2", Toast.LENGTH_SHORT).show());
        post3.setOnClickListener(v ->
                Toast.makeText(SavedPostsActivity.this, "Đã mở bài viết 3", Toast.LENGTH_SHORT).show());
    }
}

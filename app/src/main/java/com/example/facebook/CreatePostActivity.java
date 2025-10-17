package com.example.facebook;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.*;

import java.io.IOException;

public class CreatePostActivity extends AppCompatActivity {

    private EditText postContent;
    private ImageView selectedImage;
    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        postContent = findViewById(R.id.post_content);
        selectedImage = findViewById(R.id.selected_image);
        ImageView btnPhoto = findViewById(R.id.btn_photo);
        Button btnPost = findViewById(R.id.btn_post);
        ImageView btnBack = findViewById(R.id.btn_back);


        btnPhoto.setOnClickListener(v -> openImagePicker());


        btnPost.setOnClickListener(v -> {
            String content = postContent.getText().toString().trim();
            if (content.isEmpty() && imageUri == null) {
                Toast.makeText(this, "Hãy viết gì đó hoặc chọn ảnh!", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "Đăng bài thành công", Toast.LENGTH_SHORT).show();
            finish();
        });


        btnBack.setOnClickListener(v -> finish());
    }

    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                selectedImage.setImageBitmap(bitmap);
                selectedImage.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

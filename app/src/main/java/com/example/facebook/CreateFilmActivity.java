package com.example.facebook;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class CreateFilmActivity extends AppCompatActivity {

    private static final int REQUEST_VIDEO_CAPTURE = 1;
    private static final int REQUEST_PICK_VIDEO = 2;
    private static final int REQUEST_PERMISSION = 100;

    ImageView btnExit, imgSetting;
    LinearLayout cameraLayout, musicLayout, sampleLayout, savedLayout,
            draftLayout, effectLayout, greenScreenLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_film);

        btnExit = findViewById(R.id.btn_exit);
        imgSetting = findViewById(R.id.imgsetting);

        cameraLayout = findViewById(R.id.cameraLayout);
        musicLayout = findViewById(R.id.musicLayout);
        sampleLayout = findViewById(R.id.sampleLayout);
        savedLayout = findViewById(R.id.savedLayout);
        draftLayout = findViewById(R.id.draftLayout);
        effectLayout = findViewById(R.id.effectLayout);
        greenScreenLayout = findViewById(R.id.greenScreenLayout);

        btnExit.setOnClickListener(v -> finish());

        imgSetting.setOnClickListener(v ->
                Toast.makeText(this, "Mở cài đặt thước phim", Toast.LENGTH_SHORT).show()
        );
        cameraLayout.setOnClickListener(v -> openCamera());
        musicLayout.setOnClickListener(v ->
                Toast.makeText(this, "Mở thư viện nhạc", Toast.LENGTH_SHORT).show()
        );
        sampleLayout.setOnClickListener(v ->
                Toast.makeText(this, "Chọn mẫu thước phim", Toast.LENGTH_SHORT).show()
        );
        savedLayout.setOnClickListener(v ->
                Toast.makeText(this, "Mở danh sách thước phim đã lưu", Toast.LENGTH_SHORT).show()
        );
        draftLayout.setOnClickListener(v ->
                Toast.makeText(this, "Mở bản nháp thước phim", Toast.LENGTH_SHORT).show()
        );
        effectLayout.setOnClickListener(v ->
                Toast.makeText(this, "Chọn hiệu ứng quay phim", Toast.LENGTH_SHORT).show()
        );
        greenScreenLayout.setOnClickListener(v ->
                Toast.makeText(this, "Bật chế độ phông xanh", Toast.LENGTH_SHORT).show()
        );
        checkPermissions();
    }
    private void checkPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_PERMISSION);
        }
    }
    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_VIDEO_CAPTURE);
        } else {
            Toast.makeText(this, "Không thể mở camera", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK && data != null) {
            Uri videoUri = data.getData();
            Toast.makeText(this, "Đã quay xong video: " + videoUri, Toast.LENGTH_SHORT).show();
        } else if (requestCode == REQUEST_PICK_VIDEO && resultCode == RESULT_OK && data != null) {
            Uri selectedVideoUri = data.getData();
            Toast.makeText(this, "Đã chọn video: " + selectedVideoUri, Toast.LENGTH_SHORT).show();
        }
    }
}

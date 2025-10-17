package com.example.facebook;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private ImageView profilePic, coverPhoto;
    private Button addToStory, editProfile;
    private TextView userName, followers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profilePic = findViewById(R.id.profilePic);
        coverPhoto = findViewById(R.id.coverPhoto);
        addToStory = findViewById(R.id.addToStory);
        editProfile = findViewById(R.id.editProfile);
        userName = findViewById(R.id.userName);
        followers = findViewById(R.id.followers);


        profilePic.setOnClickListener(v ->
                Toast.makeText(ProfileActivity.this, "Đây là hình đại diện của bạn", Toast.LENGTH_SHORT).show()
        );

        coverPhoto.setOnClickListener(v ->
                Toast.makeText(ProfileActivity.this, "Đây là ảnh bìa của bạn", Toast.LENGTH_SHORT).show()
        );

        addToStory.setOnClickListener(v ->
                Toast.makeText(ProfileActivity.this, "Thêm vào tin của bạn", Toast.LENGTH_SHORT).show()
        );

        editProfile.setOnClickListener(v ->
                Toast.makeText(ProfileActivity.this, "Chỉnh sửa trang cá nhân", Toast.LENGTH_SHORT).show()
        );

        userName.setText("Nguyen Van A");
        followers.setText("1.3K người theo dõi");
    }
}

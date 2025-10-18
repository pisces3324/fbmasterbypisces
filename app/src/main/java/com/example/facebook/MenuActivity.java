package com.example.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    ImageView imgSettings, imgSearch, imgUser;
    TextView tvUsername, tvSaved, tvFriends, tvMovies, tvFeed, tvLogout;
    LinearLayout tvHelp, tvPrivacy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        imgSettings = findViewById(R.id.imgSettings);
        imgSearch = findViewById(R.id.imgSearch);
        imgUser = findViewById(R.id.imgUser);
        tvUsername = findViewById(R.id.tvUsername);
        tvSaved = findViewById(R.id.tvSaved);
        tvFriends = findViewById(R.id.tvFriends);
        tvMovies = findViewById(R.id.tvMovies);
        tvFeed = findViewById(R.id.tvFeed);
        tvHelp = findViewById(R.id.tvHelp);
        tvPrivacy = findViewById(R.id.tvPrivacy);
        tvLogout = findViewById(R.id.tvLogout);
        tvUsername.setText("Nguyễn Văn A");
        imgUser.setOnClickListener(v ->{
            Intent intent = new Intent(MenuActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
        imgSettings.setOnClickListener(v -> {

            Intent intent = new Intent(MenuActivity.this, SettingsActivity.class);
            startActivity(intent);
        });
        imgSearch.setOnClickListener(v -> {

            Intent intent = new Intent(MenuActivity.this, SearchActivity.class);
            startActivity(intent);
        });

        tvSaved.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, SavedPostsActivity.class);
            startActivity(intent);
        });

        tvFriends.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, FriendsActivity.class);
            startActivity(intent);
        });

        tvMovies.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, VideoActivity.class);
            startActivity(intent);
        });

        tvFeed.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, HomeActivity.class);
            startActivity(intent);
        });

        tvHelp.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, HelpActivity.class);
            startActivity(intent);
        });

        tvPrivacy.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, PrivacyActivity.class);
            startActivity(intent);
        });

        tvLogout.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}

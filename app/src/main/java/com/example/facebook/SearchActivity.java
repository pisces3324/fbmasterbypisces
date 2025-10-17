package com.example.facebook;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {

    private EditText edtSearch;
    private ImageView imgBack;
    private ImageView imgOption1, imgOption2, imgOption3;
    private TextView tvAddFriend1, tvRemove1, tvAddFriend2, tvRemove2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        edtSearch = findViewById(R.id.edtSearch);
        imgBack = findViewById(R.id.imgBack);
        imgOption1 = findViewById(R.id.imgOption1);
        imgOption2 = findViewById(R.id.imgOption2);
        imgOption3 = findViewById(R.id.imgOption3);

        tvAddFriend1 = findViewById(R.id.tvAddFriend1);
        tvRemove1 = findViewById(R.id.tvRemove1);
        tvAddFriend2 = findViewById(R.id.tvAddFriend2);
        tvRemove2 = findViewById(R.id.tvRemove2);


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvAddFriend1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SearchActivity.this, "Đã gửi lời mời tới tuan tran", Toast.LENGTH_SHORT).show();
            }
        });

        tvRemove1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SearchActivity.this, "Đã gỡ tuan tran khỏi gợi ý", Toast.LENGTH_SHORT).show();
            }
        });

        tvAddFriend2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SearchActivity.this, "Đã gửi lời mời tới nhung tran", Toast.LENGTH_SHORT).show();
            }
        });

        tvRemove2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SearchActivity.this, "Đã gỡ nhung tran khỏi gợi ý", Toast.LENGTH_SHORT).show();
            }
        });


    }
}

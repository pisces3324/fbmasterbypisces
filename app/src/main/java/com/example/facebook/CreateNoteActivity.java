package com.example.facebook;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateNoteActivity extends AppCompatActivity {

    private EditText textName;
    private TextView textCount;
    private ImageView btnBack, btnMusic, btnSmile;
    private TextView btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);


        btnBack = findViewById(R.id.btn_back);
        btnSave = findViewById(R.id.btn_save);
        textName = findViewById(R.id.textName);
        textCount = findViewById(R.id.textCount);
        btnMusic = findViewById(R.id.btn_music);
        btnSmile = findViewById(R.id.btn_smile);


        btnBack.setOnClickListener(v -> finish());


        textName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                textCount.setText(s.length() + "/60");
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });


        btnSave.setOnClickListener(v -> {
            String content = textName.getText().toString().trim();
            if (content.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập nội dung ghi chú!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Đã chia sẻ ghi chú!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        btnMusic.setOnClickListener(v ->
                Toast.makeText(this, "Chức năng thêm nhạc sẽ có sau!", Toast.LENGTH_SHORT).show()
        );
        btnSmile.setOnClickListener(v ->
                Toast.makeText(this, "Chức năng thêm cảm xúc sắp có!", Toast.LENGTH_SHORT).show()
        );
    }
}

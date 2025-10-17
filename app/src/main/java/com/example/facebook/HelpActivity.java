package com.example.facebook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class HelpActivity extends AppCompatActivity {

    private ImageView imgBack;
    private ConstraintLayout faq1, faq2, faq3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        imgBack = findViewById(R.id.imgBack);
        faq1 = findViewById(R.id.faq1);
        faq2 = findViewById(R.id.faq2);
        faq3 = findViewById(R.id.faq3);

        imgBack.setOnClickListener(v -> finish());

        faq1.setOnClickListener(v ->
                Toast.makeText(HelpActivity.this, "Trả lời FAQ 1", Toast.LENGTH_SHORT).show());

        faq2.setOnClickListener(v ->
                Toast.makeText(HelpActivity.this, "Trả lời FAQ 2", Toast.LENGTH_SHORT).show());

        faq3.setOnClickListener(v ->
                Toast.makeText(HelpActivity.this, "Trả lời FAQ 3", Toast.LENGTH_SHORT).show());
    }
}

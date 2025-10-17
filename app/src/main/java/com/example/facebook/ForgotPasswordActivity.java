package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText edtEmail;
    private Button btnNext;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        edtEmail = findViewById(R.id.edtEmail);
        btnNext = findViewById(R.id.btnNext);
        db = new DatabaseHelper(this);

        btnNext.setOnClickListener(v -> {
            String email = edtEmail.getText().toString().trim();
            if (email.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập email", Toast.LENGTH_SHORT).show();
                return;
            }
            boolean exists = db.checkUserByEmailExist(email);
            if (exists) {
                // For demo purposes we directly open reset screen.
                Intent i = new Intent(ForgotPasswordActivity.this, ResetPasswordActivity.class);
                i.putExtra("email", email);
                startActivity(i);
                finish();
            } else {
                Toast.makeText(this, "Email không tồn tại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

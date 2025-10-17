package com.example.facebook;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPasswordActivity extends AppCompatActivity {

    private EditText edtNewPassword, edtConfirmPassword;
    private Button btnReset;
    private DatabaseHelper db;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        edtNewPassword = findViewById(R.id.edtNewPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        btnReset = findViewById(R.id.btnReset);
        db = new DatabaseHelper(this);

        email = getIntent().getStringExtra("email");
        if (email == null) {
            Toast.makeText(this, "Không tìm thấy email", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        btnReset.setOnClickListener(v -> {
            String p1 = edtNewPassword.getText().toString();
            String p2 = edtConfirmPassword.getText().toString();
            if (p1.isEmpty() || p2.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!p1.equals(p2)) {
                Toast.makeText(this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                return;
            }
            boolean ok = db.updatePasswordByEmail(email, p1);
            if (ok) {
                Toast.makeText(this, "Đặt lại mật khẩu thành công", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ResetPasswordActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            } else {
                Toast.makeText(this, "Cập nhật mật khẩu thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

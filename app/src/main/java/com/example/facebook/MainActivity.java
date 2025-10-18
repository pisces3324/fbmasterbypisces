package com.example.facebook;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etEmail, etPassword;
    private Button btnLogin, btnCreateAccount;
    private TextView tvForgot;
    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);
        tvForgot = findViewById(R.id.tvForgot);
        db = new DatabaseHelper(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean success = db.checkUserByEmail(email, password);
                if (success) {
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Email hoặc mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvForgot.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });
        btnCreateAccount.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}

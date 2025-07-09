package com.example.quanlygiaohang_cnpm.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mart.database.DatabaseHelper;
import com.example.mart.R;
import com.example.mart.fragments.AdminSanPhamFragment;
import com.example.mart.fragments.UserSanPhamFragment;

public class DangNhap extends AppCompatActivity {

    EditText etEmailLogin, etMatKhauLogin;
    Button btnDangNhap, btnGoRegister;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        etEmailLogin = findViewById(R.id.etEmailLogin);
        etMatKhauLogin = findViewById(R.id.etMatKhauLogin);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnGoRegister = findViewById(R.id.btnGoRegister);
        db = new DatabaseHelper(this);

        btnDangNhap.setOnClickListener(v -> {
            String email = etEmailLogin.getText().toString();
            String mk = etMatKhauLogin.getText().toString();
            Cursor cursor = db.checkLogin(email, mk);
            if (cursor.moveToFirst()) {
                String role = cursor.getString(cursor.getColumnIndexOrThrow("role"));
                Toast.makeText(this, "Đăng nhập thành công: " + role, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("role", role);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Sai email hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            }
        });

        btnGoRegister.setOnClickListener(v -> {
            startActivity(new Intent(this, DangKy.class));
        });
    }
}

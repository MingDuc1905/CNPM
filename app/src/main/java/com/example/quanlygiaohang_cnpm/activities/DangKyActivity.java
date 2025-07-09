package com.example.quanlygiaohang_cnpm.activities;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mart.database.DatabaseHelper;
import com.example.mart.R;

public class DangKy extends AppCompatActivity {

    EditText etTen, etEmail, etMatKhau;
    Button btnDangKy;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        etTen = findViewById(R.id.etTen);
        etEmail = findViewById(R.id.etEmail);
        etMatKhau = findViewById(R.id.etMatKhau);
        btnDangKy = findViewById(R.id.btnDangKy);
        db = new DatabaseHelper(this);

        btnDangKy.setOnClickListener(v -> {
            String ten = etTen.getText().toString();
            String email = etEmail.getText().toString();
            String mk = etMatKhau.getText().toString();

            if (ten.isEmpty() || email.isEmpty() || mk.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
            } else {
                if (db.insertUser(ten, email, mk, "NhanVien")) {
                    db.insertNhanVienFromUser(ten, email); // 👈 tự động thêm vào bảng NhanVien
                    Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this, "Email đã tồn tại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

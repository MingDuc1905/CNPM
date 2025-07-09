package com.example.quanlygiaohang_cnpm.activities;

import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlygiaohang_cnpm.R;
import com.example.quanlygiaohang_cnpm.adapter.DonHangAdapter;
import com.example.quanlygiaohang_cnpm.models.DonHang;

import java.util.ArrayList;

public class DonHangActivity extends AppCompatActivity {
    RecyclerView rcvDonHang;
    ArrayList<DonHang> list = new ArrayList<>();
    DonHangAdapter adapter;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_don_hang);

        rcvDonHang = findViewById(R.id.rcvDonHang);
        db = new DBHelper(this);

        loadData();

        adapter = new DonHangAdapter(this, list);
        rcvDonHang.setLayoutManager(new LinearLayoutManager(this));
        rcvDonHang.setAdapter(adapter);
    }

    private void loadData() {
        Cursor c = db.getAllDonHang();
        list.clear();
        while (c.moveToNext()) {
            list.add(new DonHang(
                    c.getInt(0),      // id
                    c.getString(1),   // tenKhach
                    c.getString(3),   // diaChi
                    c.getString(2),   // sdt
                    c.getString(4),   // ngayGiao
                    c.getString(5)    // trangThai
            ));
        }
        c.close();
    }

}

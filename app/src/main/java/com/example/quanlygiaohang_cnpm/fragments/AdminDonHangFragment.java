package com.example.mart.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mart.R;
import com.example.mart.activities.AddSanPhamActivity;
import com.example.mart.adapter.SanPhamAdapter;
import com.example.mart.database.DatabaseHelper;
import com.example.mart.models.SanPham;
import com.example.quanlygiaohang_cnpm.fragments.SanPham;

import java.util.ArrayList;
import java.util.List;

public class AdminSanPhamFragment extends Fragment {

    RecyclerView rvSanPham;
    Button btnThem;
    List<com.example.quanlygiaohang_cnpm.fragments.SanPham> list;
    SanPhamAdapter adapter;
    DatabaseHelper dbHelper;
    boolean isAdmin = true; // Đặt cứng hoặc sau này lấy từ Bundle/SharedPref

    public AdminSanPhamFragment() {
        // Constructor mặc định
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_san_pham, container, false);

        rvSanPham = view.findViewById(R.id.rvSanPham);
        btnThem = view.findViewById(R.id.btnThem);
        dbHelper = new DatabaseHelper(getContext());

        btnThem.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), AddSanPhamActivity.class);
            startActivity(intent);
        });

        loadSanPham();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadSanPham(); // Refresh sau khi quay lại từ AddSanPhamActivity
    }

    private void loadSanPham() {
        list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM SanPham", null);

        while (cursor.moveToNext()) {
            int maSP = cursor.getInt(cursor.getColumnIndexOrThrow("MaSP"));
            String tenSP = cursor.getString(cursor.getColumnIndexOrThrow("TenSP"));
            String donViTinh = cursor.getString(cursor.getColumnIndexOrThrow("DonViTinh"));
            int giaBan = cursor.getInt(cursor.getColumnIndexOrThrow("GiaBan"));
            String moTa = cursor.getString(cursor.getColumnIndexOrThrow("MoTa"));
            String tenDM = cursor.getString(cursor.getColumnIndexOrThrow("TenDM")); // Đã sửa
            String tenNCC = cursor.getString(cursor.getColumnIndexOrThrow("TenNCC")); // Đã sửa

            SanPham sp = new SanPham(maSP, tenSP, donViTinh, giaBan, moTa, tenDM, tenNCC);
            list.add(sp);
        }

        cursor.close();
        db.close();

        adapter = new SanPhamAdapter(getContext(), list, isAdmin);
        rvSanPham.setLayoutManager(new LinearLayoutManager(getContext()));
        rvSanPham.setAdapter(adapter);
    }
}
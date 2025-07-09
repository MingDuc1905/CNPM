package com.example.quanlygiaohang_cnpm.activities;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mart.R;
import com.example.mart.adapter.ChiTietHoaDonAdapter;
import com.example.mart.database.DatabaseHelper;
import com.example.mart.models.ChiTietHoaDon;
import com.example.quanlygiaohang_cnpm.adapter.ChiTietDonAdapter;
import com.example.quanlygiaohang_cnpm.database.DatabaseHelper;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ChiTietHoaDonActivity extends AppCompatActivity {

    TextView tvMaHD, tvNgay, tvKhachHang, tvNhanVien, tvTongTien;
    RecyclerView rvChiTiet;
    com.example.quanlygiaohang_cnpm.database.DatabaseHelper dbHelper;
    ChiTietDonAdapter adapter;
    List<ChiTietHoaDonActivity> danhSach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_hoa_don);

        tvMaHD = findViewById(R.id.tvMaHD);
        tvNgay = findViewById(R.id.tvNgay);
        tvKhachHang = findViewById(R.id.tvKhachHang);
        tvNhanVien = findViewById(R.id.tvNhanVien);
        tvTongTien = findViewById(R.id.tvTongTien);
        rvChiTiet = findViewById(R.id.rvChiTiet);

        dbHelper = new com.example.quanlygiaohang_cnpm.database.DatabaseHelper(this);
        int maHD = getIntent().getIntExtra("maHD", -1);

        // Thông tin chung
        Cursor cursor = dbHelper.getReadableDatabase().rawQuery(
                "SELECT hd.MaHD, hd.NgayLap, kh.TenKH, nv.TenNV, hd.TongTien " +
                        "FROM HoaDon hd " +
                        "LEFT JOIN KhachHang kh ON hd.MaKH = kh.MaKH " +
                        "LEFT JOIN NhanVien nv ON hd.MaNV = nv.MaNV " +
                        "WHERE hd.MaHD = ?", new String[]{String.valueOf(maHD)}
        );
        if (cursor.moveToFirst()) {
            tvMaHD.setText("Mã hóa đơn: " + cursor.getInt(0));
            tvNgay.setText("Ngày lập: " + cursor.getString(1));
            tvKhachHang.setText("Khách hàng: " + cursor.getString(2));
            tvNhanVien.setText("Nhân viên bán: " + cursor.getString(3));
            tvTongTien.setText("Tổng tiền: " + NumberFormat.getInstance(new Locale("vi", "VN")).format(cursor.getInt(4)) + " ₫");
        }
        cursor.close();

        // Danh sách chi tiết
        danhSach = new ArrayList<>();
        Cursor ct = dbHelper.getReadableDatabase().rawQuery(
                "SELECT TenSP, SoLuongMua, ThanhTien FROM ChiTietHoaDon WHERE MaHD = ?",
                new String[]{String.valueOf(maHD)}
        );
        while (ct.moveToNext()) {
            danhSach.add(new ChiTietHoaDonActivity(
                    ct.getString(0), ct.getInt(1), ct.getInt(2)
            ));
        }
        ct.close();

        adapter = new ChiTietDonAdapter(this, danhSach);
        rvChiTiet.setLayoutManager(new LinearLayoutManager(this));
        rvChiTiet.setAdapter(adapter);
    }
}

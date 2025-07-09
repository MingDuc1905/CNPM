package com.example.quanlygiaohang_cnpm.activities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public abstract class DBHelper {


    public DBHelper(Context context, String dbName, Object o, int dbVersion) {
    }

    public Cursor getAllDonHang() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM DonHang", null);
    }

    public long insertDonHang(String ten, String diaChi, String sdt, String ngayGiao, String trangThai) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenNguoiNhan", ten);
        values.put("DiaChi", diaChi);
        values.put("SDT", sdt);
        values.put("NgayGiao", ngayGiao);
        values.put("TrangThai", trangThai);
        return db.insert("DonHang", null, values);
    }


    public abstract void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);
}

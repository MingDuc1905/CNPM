package com.example.quanlygiaohang_cnpm.models;

public class DonHang {
    public int id;
    public String tenKhach, diaChi, sdt, ngayGiao, trangThai;

    public DonHang(int id, String tenKhach, String diaChi, String sdt, String ngayGiao, String trangThai) {
        this.id = id;
        this.tenKhach = tenKhach;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.ngayGiao = ngayGiao;
        this.trangThai = trangThai;
    }
}

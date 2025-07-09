package com.example.quanlygiaohang_cnpm.models;

public class ThongKe {
    private String ngay;
    private int tongDoanhThu;

    public ThongKe(String ngay, int tongDoanhThu) {
        this.ngay = ngay;
        this.tongDoanhThu = tongDoanhThu;
    }

    public String getNgay() { return ngay; }
    public int getTongDoanhThu() { return tongDoanhThu; }
}

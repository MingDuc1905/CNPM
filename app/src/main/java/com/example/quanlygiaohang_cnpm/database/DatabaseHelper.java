package com.example.quanlygiaohang_cnpm.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlygiaohang_cnpm.activities.DBHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
public class DatabaseHelper extends DBHelper {
    public static final String DB_NAME = "QuanLyGiaoHang";
    public static final int DB_VERSION = 11;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //tk người dùng
        db.execSQL("CREATE TABLE IF NOT EXISTS DonHang (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "tenKhach TEXT, " +
                "sdt TEXT, " +
                "diaChi TEXT, " +
                "ngayGiao TEXT, " +
                "trangThai TEXT)");
        // 1. Khách hàng
        db.execSQL("CREATE TABLE KhachHang (" +
                "MaKH INTEGER PRIMARY KEY," +
                "TenKH TEXT NOT NULL," +
                "NgaySinh TEXT," +
                "GioiTinh TEXT," +
                "Email TEXT," +
                "SDT TEXT)");
        db.execSQL("INSERT INTO KhachHang (MaKH, TenKH, NgaySinh, GioiTinh, Email, SDT) " +
                "VALUES (1, 'Hoàng Mai Linh', '1998-05-10', 'Nữ', 'linh.hoang@gmail.com', '0901112233')");

        db.execSQL("INSERT INTO KhachHang (MaKH, TenKH, NgaySinh, GioiTinh, Email, SDT) " +
                "VALUES (2, 'Ngô Bá Long', '1993-12-01', 'Nam', 'long.ngo@gmail.com', '0902223344')");

        db.execSQL("INSERT INTO KhachHang (MaKH, TenKH, NgaySinh, GioiTinh, Email, SDT) " +
                "VALUES (3, 'Lê Thị Hạnh', '2000-08-20', 'Nữ', 'hanh.le@gmail.com', '0903334455')");

        db.execSQL("INSERT INTO KhachHang (MaKH, TenKH, NgaySinh, GioiTinh, Email, SDT) " +
                "VALUES (4, 'Trần Minh Hoàng', '1991-03-17', 'Nam', 'hoang.tran@gmail.com', '0904445566')");

        db.execSQL("INSERT INTO KhachHang (MaKH, TenKH, NgaySinh, GioiTinh, Email, SDT) " +
                "VALUES (5, 'Phạm Thu Trang', '1997-07-09', 'Nữ', 'trang.pham@gmail.com', '0905556677')");

        // 2. Nhân viên
        db.execSQL("CREATE TABLE NhanVien (" +
                "MaNV INTEGER PRIMARY KEY," +
                "TenNV TEXT NOT NULL," +
                "NgaySinh TEXT," +
                "GioiTinh TEXT," +
                "SDT TEXT," +
                "Email TEXT," +
                "NgayTuyenDung TEXT," +
                "ChucVu TEXT)");

        // 3. Danh mục sản phẩm
        db.execSQL("CREATE TABLE DanhMucSP (" +
                "MaDM INTEGER PRIMARY KEY," +
                "TenDM TEXT NOT NULL," +
                "MoTa TEXT," +
                "TrangThai TEXT)");
        db.execSQL("INSERT INTO DanhMucSP (MaDM, TenDM, MoTa, TrangThai) " +
                "VALUES (1, 'Đồ uống', 'Các loại nước giải khát, cà phê, trà...', 'Hoạt động')");

        db.execSQL("INSERT INTO DanhMucSP (MaDM, TenDM, MoTa, TrangThai) " +
                "VALUES (2, 'Thực phẩm khô', 'Mì gói, gạo, bún khô, đồ hộp...', 'Hoạt động')");

        db.execSQL("INSERT INTO DanhMucSP (MaDM, TenDM, MoTa, TrangThai) " +
                "VALUES (3, 'Rau củ quả', 'Rau tươi, củ, quả sạch mỗi ngày', 'Hoạt động')");

        db.execSQL("INSERT INTO DanhMucSP (MaDM, TenDM, MoTa, TrangThai) " +
                "VALUES (4, 'Đồ gia dụng', 'Vật dụng nhà bếp, nồi, chảo, dao...', 'Hoạt động')");

        db.execSQL("INSERT INTO DanhMucSP (MaDM, TenDM, MoTa, TrangThai) " +
                "VALUES (5, 'Hóa mỹ phẩm', 'Dầu gội, sữa tắm, nước rửa chén...', 'Ngừng hoạt động')");


        // 4. Nhà cung cấp
        db.execSQL("CREATE TABLE NhaCC (" +
                "MaNCC INTEGER PRIMARY KEY," +
                "TenNCC TEXT NOT NULL," +
                "DiaChi TEXT," +
                "SDT TEXT," +
                "Email TEXT)");
        db.execSQL("INSERT INTO NhaCC (MaNCC, TenNCC, DiaChi, SDT, Email) " +
                "VALUES (1, 'Công ty TNHH ABC', '123 Lê Lợi, Q.1, TP.HCM', '0909123456', 'abc@gmail.com')");

        db.execSQL("INSERT INTO NhaCC (MaNCC, TenNCC, DiaChi, SDT, Email) " +
                "VALUES (2, 'Công ty CP XYZ', '456 Trần Hưng Đạo, Q.5, TP.HCM', '0911222333', 'xyz@congty.vn')");

        db.execSQL("INSERT INTO NhaCC (MaNCC, TenNCC, DiaChi, SDT, Email) " +
                "VALUES (3, 'Công ty TNHH Thiên Long', '789 Cách Mạng Tháng 8, Q.3, TP.HCM', '0933444555', 'thienlong@tl.com')");

        db.execSQL("INSERT INTO NhaCC (MaNCC, TenNCC, DiaChi, SDT, Email) " +
                "VALUES (4, 'Công ty CP Việt Tiến', '12 Nguyễn Trãi, Q.1, TP.HCM', '0909777888', 'viettien@vt.vn')");

        db.execSQL("INSERT INTO NhaCC (MaNCC, TenNCC, DiaChi, SDT, Email) " +
                "VALUES (5, 'Công ty TNHH Minh Long', '34 Lý Thường Kiệt, Q.Tân Bình, TP.HCM', '0988999777', 'minhlong@ml.com')");

        // 5. Sản phẩm
        db.execSQL("CREATE TABLE SanPham (" +
                "MaSP INTEGER PRIMARY KEY," +
                "TenSP TEXT NOT NULL," +
                "DonViTinh TEXT," +
                "GiaBan INTEGER NOT NULL," +
                "MoTa TEXT," +
                "TenDM TEXT," +
                "TenNCC TEXT)");

        // 6. Hóa đơn
        db.execSQL("CREATE TABLE HoaDon (" +
                "MaHD INTEGER PRIMARY KEY," +
                "NgayLap TEXT NOT NULL," +
                "MaKH INTEGER," +
                "MaNV INTEGER," +
                "TongTien INTEGER DEFAULT 0," +
                "VAT REAL DEFAULT 0)");

        // 7. Chi tiết hóa đơn
        // 7. Chi tiết hóa đơn (lưu TenSP thay vì MaSP)
        db.execSQL("CREATE TABLE ChiTietHoaDon (" +
                "MaHD INTEGER," +
                "TenSP TEXT," +
                "SoLuongMua INTEGER NOT NULL," +
                "ThanhTien INTEGER NOT NULL," +
                "PRIMARY KEY (MaHD, TenSP))");


        // 8. Phiếu giảm giá
        db.execSQL("CREATE TABLE PhieuGiamGia (" +
                "MaPhieu INTEGER PRIMARY KEY," +
                "GiaTri INTEGER NOT NULL," +
                "Loai TEXT," +
                "NgayBD TEXT," +
                "NgayKT TEXT," +
                "DieuKien TEXT," +
                "Status TEXT," +
                "MaHD INTEGER)");

        // 9. Bảng Thống Kê Doanh Thu (tùy chọn thêm nếu muốn lưu lại thay vì truy vấn động)
        db.execSQL("CREATE TABLE ThongKe (" +
                "Ngay TEXT PRIMARY KEY," +
                "TongDoanhThu INTEGER)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Users");
        db.execSQL("DROP TABLE IF EXISTS PhieuGiamGia");
        db.execSQL("DROP TABLE IF EXISTS ChiTietHoaDon");
        db.execSQL("DROP TABLE IF EXISTS HoaDon");
        db.execSQL("DROP TABLE IF EXISTS SanPham");
        db.execSQL("DROP TABLE IF EXISTS NhaCC");
        db.execSQL("DROP TABLE IF EXISTS DanhMucSP");
        db.execSQL("DROP TABLE IF EXISTS NhanVien");
        db.execSQL("DROP TABLE IF EXISTS KhachHang");
        onCreate(db);
    }
//    public boolean insertUser(String ten, String email, String matkhau, String role) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("ten", ten);
//        values.put("email", email);
//        values.put("matkhau", matkhau);
//        values.put("role", role);
//        return db.insert("Users", null, values) != -1;
//    }
//
//    public Cursor checkLogin(String email, String password) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        return db.rawQuery("SELECT * FROM Users WHERE email = ? AND matkhau = ?", new String[]{email, password});
//    }
//
//    public boolean insertNhaCC(String tenNCC, String diaChi, String sdt, String email) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("TenNCC", tenNCC);
//        values.put("DiaChi", diaChi);
//        values.put("SDT", sdt);
//        values.put("Email", email);
//        return db.insert("NhaCC", null, values) != -1;
//    }
//
//    public List<SanPham> getAllSanPham() {
//        List<SanPham> list = new ArrayList<>();
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT MaSP, TenSP, DonViTinh, GiaBan, MoTa, TenDM, TenNCC FROM SanPham", null);
//        if (cursor.moveToFirst()) {
//            do {
//                list.add(new SanPham(
//                        cursor.getInt(0),
//                        cursor.getString(1),
//                        cursor.getString(2),
//                        cursor.getInt(3),
//                        cursor.getString(4),
//                        cursor.getString(5),
//                        cursor.getString(6)));
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        return list;
//    }
//
//    public long insertHoaDon(int tongTien, double vat, int maKH, int maNV) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//
//        String ngayLap = getCurrentDate();  // ✅ Tạo ngày hôm nay
//
//        values.put("NgayLap", ngayLap);
//        values.put("MaKH", maKH);
//        values.put("MaNV", maNV);
//        values.put("TongTien", tongTien);
//        values.put("VAT", vat);
//
//        long result = db.insert("HoaDon", null, values);
//
//        if (result != -1) {
//            updateThongKe(ngayLap, tongTien);  // ✅ Cập nhật doanh thu vào bảng thống kê
//        }
//
//        return result;
//    }
//
//
//    public void insertChiTietHoaDon(long maHD, CartItem item) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//
//        String tenSP = item.getSanPham() != null ? item.getSanPham().getTenSP() : "Không rõ";
//
//        values.put("MaHD", maHD);
//        values.put("TenSP", tenSP);
//        values.put("SoLuongMua", item.getSoLuong());
//        values.put("ThanhTien", item.getSoLuong() * item.getSanPham().getGiaBan());
//        db.insert("ChiTietHoaDon", null, values);
//    }
//
//    public List<ChiTietHoaDon> getChiTietHoaDonByMaHD(int maHD) {
//        List<ChiTietHoaDon> list = new ArrayList<>();
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT TenSP, SoLuongMua, ThanhTien FROM ChiTietHoaDon WHERE MaHD = ?", new String[]{String.valueOf(maHD)});
//
//        if (cursor.moveToFirst()) {
//            do {
//                String tenSP = cursor.getString(0); // Cẩn thận: nếu sai tên cột thì sẽ null
//                int soLuong = cursor.getInt(1);
//                int thanhTien = cursor.getInt(2);
//                list.add(new ChiTietHoaDon(tenSP, soLuong, thanhTien));
//            } while (cursor.moveToNext());
//        }
//
//        cursor.close();
//        return list;
//    }
//
//
//    public int getMaNhanVienByTen(String tenNV) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT MaNV FROM NhanVien WHERE TenNV = ?", new String[]{tenNV});
//        if (cursor.moveToFirst()) {
//            int ma = cursor.getInt(0);
//            cursor.close();
//            return ma;
//        }
//        cursor.close();
//        return -1;
//    }
//
//    public int getMaKhachHangByTen(String tenKH) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT MaKH FROM KhachHang WHERE TenKH = ?", new String[]{tenKH});
//        if (cursor.moveToFirst()) {
//            int ma = cursor.getInt(0);
//            cursor.close();
//            return ma;
//        }
//        cursor.close();
//        return -1;
//    }
//
//    public long insertKhachHang(String tenKH) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("TenKH", tenKH);
//        return db.insert("KhachHang", null, values);
//    }
//
//    public void insertNhanVienFromUser(String ten, String email) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("TenNV", ten);
//        values.put("Email", email);
//        values.put("NgayTuyenDung", getCurrentDate());
//        values.put("ChucVu", "Nhân viên");
//        db.insert("NhanVien", null, values);
//    }
//
//    private String getCurrentDate() {
//        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
//    }
//    public List<HoaDon> getAllHoaDonWithNames() {
//        List<HoaDon> list = new ArrayList<>();
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        String query = "SELECT hd.MaHD, hd.NgayLap, kh.TenKH, nv.TenNV, hd.TongTien, hd.VAT " +
//                "FROM HoaDon hd " +
//                "LEFT JOIN KhachHang kh ON hd.MaKH = kh.MaKH " +
//                "LEFT JOIN NhanVien nv ON hd.MaNV = nv.MaNV";
//
//        Cursor cursor = db.rawQuery(query, null);
//        if (cursor.moveToFirst()) {
//            do {
//                HoaDon hd = new HoaDon(
//                        cursor.getInt(0),
//                        cursor.getString(1),
//                        cursor.getString(2),
//                        cursor.getString(3),
//                        cursor.getInt(4),
//                        cursor.getDouble(5)
//                );
//                list.add(hd);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return list;
//    }
//    // Lấy tên khách hàng theo mã
//    public String getTenKhachHangByMa(int maKH) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT TenKH FROM KhachHang WHERE MaKH = ?", new String[]{String.valueOf(maKH)});
//        if (cursor.moveToFirst()) {
//            String tenKH = cursor.getString(0);
//            cursor.close();
//            return tenKH;
//        }
//        cursor.close();
//        return "Không rõ";
//    }
//
//    // Lấy tên nhân viên theo mã
//    public String getTenNhanVienByMa(int maNV) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT TenNV FROM NhanVien WHERE MaNV = ?", new String[]{String.valueOf(maNV)});
//        if (cursor.moveToFirst()) {
//            String tenNV = cursor.getString(0);
//            cursor.close();
//            return tenNV;
//        }
//        cursor.close();
//        return "Không rõ";
//    }
//
//    public Cursor getDoanhThuTheoNgay() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        String query = "SELECT HoaDon.NgayLap, SUM(ChiTietHoaDon.ThanhTien) AS TongDoanhThu " +
//                "FROM HoaDon " +
//                "JOIN ChiTietHoaDon ON HoaDon.MaHD = ChiTietHoaDon.MaHD " +
//                "GROUP BY HoaDon.NgayLap " +
//                "ORDER BY HoaDon.NgayLap ASC";
//        return db.rawQuery(query, null);
//    }
//    public Cursor getMatHangBanChay(String ngayTu, String ngayDen) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        String query = "SELECT SanPham.TenSP, SUM(ChiTietHoaDon.SoLuongMua) AS TongSoLuongBan " +
//                "FROM ChiTietHoaDon " +
//                "JOIN HoaDon ON ChiTietHoaDon.MaHD = HoaDon.MaHD " +
//                "JOIN SanPham ON ChiTietHoaDon.MaSP = SanPham.MaSP " +
//                "WHERE HoaDon.NgayLap BETWEEN ? AND ? " +
//                "GROUP BY ChiTietHoaDon.MaSP " +
//                "ORDER BY TongSoLuongBan DESC " +
//                "LIMIT 1";
//        return db.rawQuery(query, new String[]{ngayTu, ngayDen});
//    }
//    public Cursor getThongKe() {
//        SQLiteDatabase db = this.getReadableDatabase();
//        return db.rawQuery("SELECT * FROM ThongKe ORDER BY Ngay ASC", null);
//    }
//
//    public void updateThongKe(String ngay, int tongTien) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("SELECT TongDoanhThu FROM ThongKe WHERE Ngay = ?", new String[]{ngay});
//
//        if (cursor.moveToFirst()) {
//            int tongCu = cursor.getInt(0);
//            int tongMoi = tongCu + tongTien;
//
//            ContentValues values = new ContentValues();
//            values.put("TongDoanhThu", tongMoi);
//            db.update("ThongKe", values, "Ngay = ?", new String[]{ngay});
//        } else {
//            ContentValues values = new ContentValues();
//            values.put("Ngay", ngay);
//            values.put("TongDoanhThu", tongTien);
//            db.insert("ThongKe", null, values);
//        }
//
//        cursor.close();
//    }
//    public String getTenKhachHangByMaHD(int maHD) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT kh.TenKH FROM HoaDon hd JOIN KhachHang kh ON hd.MaKH = kh.MaKH WHERE hd.MaHD = ?", new String[]{String.valueOf(maHD)});
//        if (cursor.moveToFirst()) {
//            return cursor.getString(0);
//        }
//        return "Không rõ";
//    }
//
//    public String getTenNhanVienByMaHD(int maHD) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT nv.TenNV FROM HoaDon hd JOIN NhanVien nv ON hd.MaNV = nv.MaNV WHERE hd.MaHD = ?", new String[]{String.valueOf(maHD)});
//        if (cursor.moveToFirst()) {
//            return cursor.getString(0);
//        }
//        return "Không rõ";
//    }
//
//    public String getNgayLapByMaHD(int maHD) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT NgayLap FROM HoaDon WHERE MaHD = ?", new String[]{String.valueOf(maHD)});
//        if (cursor.moveToFirst()) {
//            return cursor.getString(0);
//        }
//        return "Không rõ";
//    }
//
//    public int getTongTienByMaHD(int maHD) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT TongTien FROM HoaDon WHERE MaHD = ?", new String[]{String.valueOf(maHD)});
//        if (cursor.moveToFirst()) {
//            return cursor.getInt(0);
//        }
//        return 0;
//    }

}

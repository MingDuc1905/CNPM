package com.example.quanlygiaohang_cnpm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlygiaohang_cnpm.R;
import com.example.quanlygiaohang_cnpm.models.DonHang;

import java.util.ArrayList;

public class DonHangAdapter extends RecyclerView.Adapter<DonHangAdapter.ViewHolder> {
    Context context;
    ArrayList<DonHang> list;

    public DonHangAdapter(Context context, ArrayList<DonHang> list) {
        this.context = context;
        this.list = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTenKhach, txtDiaChi, txtNgayGiao, txtTrangThai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenKhach = itemView.findViewById(R.id.txtTenKhach);
            txtDiaChi = itemView.findViewById(R.id.txtDiaChi);
            txtNgayGiao = itemView.findViewById(R.id.txtNgayGiao);
            txtTrangThai = itemView.findViewById(R.id.txtTrangThai);
        }
    }

    @NonNull
    @Override
    public DonHangAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hoa_don, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DonHangAdapter.ViewHolder holder, int position) {
        DonHang dh = list.get(position);
        holder.txtTenKhach.setText("KH: " + dh.tenKhach);
        holder.txtDiaChi.setText("Địa chỉ: " + dh.diaChi);
        holder.txtNgayGiao.setText("Ngày giao: " + dh.ngayGiao);
        holder.txtTrangThai.setText("Trạng thái: " + dh.trangThai);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

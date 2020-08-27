package com.example.aplikasibarang.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.BarangViewHolder>  {
    @NonNull
    @Override
    public BarangAdapter.BarangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BarangAdapter.BarangViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BarangViewHolder extends RecyclerView.ViewHolder {
        public BarangViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

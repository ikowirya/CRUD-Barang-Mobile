package com.example.aplikasibarang.models;

public class Barang {
    private int id;
    private String Nama_Barang;
    private String Qty;
    private String Exp_date;
    private int Harga;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_Barang() {
        return Nama_Barang;
    }

    public void setNama_Barang(String nama_Barang) {
        Nama_Barang = nama_Barang;
    }

    public String getQty() {
        return Qty;
    }

    public void setQty(String qty) {
        Qty = qty;
    }

    public String getExp_date() {
        return Exp_date;
    }

    public void setExp_date(String exp_date) {
        Exp_date = exp_date;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(String harga) {
        Harga = harga;
    }
}

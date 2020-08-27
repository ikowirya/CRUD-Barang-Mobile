package com.example.aplikasibarang.db;

import android.provider.BaseColumns;

public class BarangEntity {
    public static final class BarangEntry implements BaseColumns {

        public static final String TABLE_NAME = "barang";
        public static final String COLUMN_NAMA_BARANG = "nama_barang";
        public static final String COLUMN_QTY = "qty";
        public static final String COLUMN_EXP_DATE = "exp_date";
        public static final String COLUMN_HARGA = "harga";
    }
}

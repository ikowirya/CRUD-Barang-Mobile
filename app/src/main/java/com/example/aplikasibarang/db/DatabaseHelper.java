package com.example.aplikasibarang.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.aplikasibarang.models.Barang;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "barang.db";

    private String DROP_BARANG_TABLE = "DROP TABLE IF EXISTS " + BarangEntity.BarangEntry.TABLE_NAME;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_FAVORITE_TABLE = "CREATE TABLE " + BarangEntity.BarangEntry.TABLE_NAME + " (" +
                BarangEntity.BarangEntry._ID + " INTEGER NOT NULL," +
                BarangEntity.BarangEntry.COLUMN_NAMA_BARANG + " TEXT NOT NULL, " +
                BarangEntity.BarangEntry.COLUMN_QTY + " TEXT NOT NULL, " +
                BarangEntity.BarangEntry.COLUMN_EXP_DATE + " TEXT NOT NULL, " +
                BarangEntity.BarangEntry.COLUMN_HARGA + " TEXT NOT NULL " +
                "); ";

        sqLiteDatabase.execSQL(SQL_CREATE_FAVORITE_TABLE);
    }

    public DatabaseHelper open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        DBHelper.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_BARANG_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void addBarang(Barang barang) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(BarangEntity.BarangEntry._ID, barang.getId());
        values.put(BarangEntity.BarangEntry.COLUMN_NAMA_BARANG, barang.getNama_Barang());
        values.put(BarangEntity.BarangEntry.COLUMN_QTY, barang.getQty());
        values.put(BarangEntity.BarangEntry.COLUMN_EXP_DATE, barang.getExp_date());
        values.put(BarangEntity.BarangEntry.COLUMN_HARGA, barang.getHarga());

        db.insert(BarangEntity.BarangEntry.TABLE_NAME, null, values);
        db.close();
    }

    public List<Barang> getAllBarang() {
        // array of columns to fetch
        String[] columns = {
                BarangEntity.BarangEntry._ID,
                BarangEntity.BarangEntry.COLUMN_NAMA_BARANG,
                BarangEntity.BarangEntry.COLUMN_QTY,
                BarangEntity.BarangEntry.COLUMN_EXP_DATE,
                BarangEntity.BarangEntry.COLUMN_HARGA
        };
        // sorting orders
        String sortOrder =
                BarangEntity.BarangEntry.COLUMN_NAMA_BARANG + " ASC";
        List<Barang> beneficiaryList = new ArrayList<Barang>();

        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.query(BarangEntity.BarangEntry.TABLE_NAME,
                columns,
                null,
                null,
                null,
                null,
                sortOrder);


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Barang barang = new Barang();
                barang.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(BarangEntity.BarangEntry._ID))));
                barang.setNama_Barang(cursor.getString(cursor.getColumnIndex(BarangEntity.BarangEntry.COLUMN_NAMA_BARANG)));
                barang.setQty(cursor.getString(cursor.getColumnIndex(BarangEntity.BarangEntry.COLUMN_QTY)));
                barang.setExp_date(cursor.getString(cursor.getColumnIndex(BarangEntity.BarangEntry.COLUMN_EXP_DATE)));
                barang.setHarga(cursor.getString(cursor.getColumnIndex(BarangEntity.BarangEntry.COLUMN_HARGA)));
                // Adding user record to list
                beneficiaryList.add(barang);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return beneficiaryList;
    }


}

package com.example.doanandroidtourdulich.ui;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHandler extends SQLiteOpenHelper {

    private Context dbContext;
    private SQLiteDatabase db;
    private static final String dbPath = "/data/data/com.example.doanandroidtourdulich/databases/Travel.db";
    private static final String dbName = "Travel.db";
    private static final int dbVersion = 1;

    // Phương thức 1: Phương thức khởi dựng
    public DatabaseHandler(Context context) {
        super(context, dbName, null, dbVersion);
        // TODO Auto-generated constructor stub
        this.dbContext = context;

    }


    public void copyDB2SDCard() throws IOException {
        boolean check = false;
        try {
            File file = new File(dbPath);
            check = file.exists();
            if (check) {
                //file.delete();
                this.close();
            } else if (!check) {
                this.getReadableDatabase();
                //
                InputStream myInput = dbContext.getAssets().open(dbName);
                String outFileName = dbPath;
                OutputStream myOutput = new FileOutputStream(outFileName);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }
                myOutput.flush();
                myOutput.close();
                myInput.close();
            }
        } catch (Exception ex) {
            throw new Error("Lỗi không copy được database");
        }
    }

    //Phương thức 3: Mở CSDL
    public Cursor OpenDB() {
        db = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
        return null;
    }

    //Phương thức 4: Đóng CSDL
    public void CloseDB() {
        db.close();
    }

    //Phương thức 5: Thực thi câu lệnh SQL bất kì
    //Phương thức 6: Đọc CSDL
    public void ReadDB() {
        OpenDB();
        //
        Cursor c = db.rawQuery("select * from KhacSan", null);
        int count = c.getCount();
        Toast.makeText(dbContext, "Số bản ghi: " + count, Toast.LENGTH_SHORT).show();
        c.moveToFirst();
        String s = c.getString(0) + "-" + c.getString(1);
        Toast.makeText(dbContext, s, Toast.LENGTH_SHORT).show();
        //
        CloseDB();
    }

    //tra ve 1 cursor
    public Cursor getCursor(String sql) {
        OpenDB();
        return db.rawQuery(sql, null);
    }

    //onCreate
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    //onUpgrade
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

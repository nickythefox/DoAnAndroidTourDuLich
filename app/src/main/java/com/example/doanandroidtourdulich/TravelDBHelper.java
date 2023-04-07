package com.example.doanandroidtourdulich;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TravelDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = Ultils.DATABASE_NAME;
    private static final int DATABASE_VERSION=2;
    public TravelDBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_USER_TABLE="CREATE TABLE "+Ultils.TABLE_USER+"("
                +Ultils.COLUMN_USER_ACCOUNT+" TEXT PRIMARY KEY AUTOINCREMENT, "
                +Ultils.COLUMN_USER_ACCIMG+" TEXT,"
                +Ultils.COLUMN_USER_EMAIL+" TEXT,"
                +Ultils.COLUMN_USER_FIRSTNAME+" TEXT,"
                +Ultils.COLUMN_USER_LASTNAME+" TEXT,"
                +Ultils.COLUMN_USER_PASSWORD+" TEXT,"
                +Ultils.COLUMN_USER_ROLE+" TEXT"
                +")";
        String CREATE_PLACE_TABLE="CREATE TABLE "+Ultils.TABLE_PLACE+"("
                +Ultils.COLUMN_PLACE_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +Ultils.COLUMN_PLACE_IMAGE+" TEXT,"
                +Ultils.COLUMN_PLACE_NAME+" TEXT"
                +")";
        String CREATE_BOOK_TABLE="CREATE TABLE "+Ultils.TABLE_BOOK+"("
                +Ultils.COLUMN_BOOK_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +Ultils.COLUMN_BOOK_TOTALCOST+" INT,"
                +Ultils.COLUMN_BOOK_BOOKINGDAY+" TEXT,"
                +Ultils.COLUMN_BOOK_QUANTITY+" INT,"
                +"FOREIGN KEY(" + Ultils.COLUMN_USER_ACCOUNT + ") REFERENCES " + Ultils.TABLE_USER + "(" + Ultils.COLUMN_USER_ACCOUNT + "),"
                +"FOREIGN KEY(" + Ultils.COLUMN_TOUR_ID + ") REFERENCES " + Ultils.TABLE_TOUR + "(" + Ultils.COLUMN_TOUR_ID + ")"
                +")";

        String CREATE_TOUR_TABLE="CREATE TABLE "+Ultils.TABLE_TOUR+"("
                +Ultils.COLUMN_TOUR_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +Ultils.COLUMN_TOUR_DESCRIPTION+" TEXT,"
                +Ultils.COLUMN_TOUR_GROUPMEM+" INT,"
                +Ultils.COLUMN_TOUR_NAME+" TEXT,"
                +Ultils.COLUMN_TOUR_IMAGE+" TEXT,"
                +Ultils.COLUMN_TOUR_PRICE+" INT,"
                +"FOREIGN KEY(" + Ultils.COLUMN_PLACE_ID + ") REFERENCES " + Ultils.TABLE_PLACE + "(" + Ultils.COLUMN_PLACE_ID + ")"
                +")";
        String CREATE_TOURIMG_TABLE="CREATE TABLE "+Ultils.TABLE_TOURIMG+"("
                +Ultils.COLUMN_TOURIMG_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +Ultils.COLUMN_TOURIMG_IMAGE+" TEXT,"
                +"FOREIGN KEY(" + Ultils.COLUMN_TOUR_ID + ") REFERENCES " + Ultils.TABLE_TOUR + "(" + Ultils.COLUMN_TOUR_ID + ")"
                +")";

        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
        sqLiteDatabase.execSQL(CREATE_PLACE_TABLE);
        sqLiteDatabase.execSQL(CREATE_TOUR_TABLE);
        sqLiteDatabase.execSQL(CREATE_BOOK_TABLE);
        sqLiteDatabase.execSQL(CREATE_TOURIMG_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Ultils.TABLE_USER);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Ultils.TABLE_PLACE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Ultils.TABLE_BOOK);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Ultils.TABLE_TOUR);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Ultils.TABLE_TOURIMG);
        onCreate((sqLiteDatabase));

    }
}

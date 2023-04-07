package com.example.doanandroidtourdulich;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

public class Ultils {
    public  static final String DATABASE_NAME ="db-tourandtravel";
    public  static final String TABLE_USER ="user";
    public  static final String COLUMN_USER_ACCOUNT="account";
    public  static final String COLUMN_USER_FIRSTNAME="firstname";
    public  static final String COLUMN_USER_LASTNAME="lastname";
    public  static final String COLUMN_USER_PASSWORD="password";
    public  static final String COLUMN_USER_EMAIL="email";
    public  static final String COLUMN_USER_ROLE="role";
    public  static final String COLUMN_USER_ACCIMG="accimg";

    public  static final String TABLE_PLACE ="place";
    public  static final String COLUMN_PLACE_ID="id";
    public  static final String COLUMN_PLACE_NAME="name";
    public  static final String COLUMN_PLACE_IMAGE="image";

    public  static final String TABLE_BOOK ="book";
    public  static final String COLUMN_BOOK_ID="id";
    public  static final String COLUMN_BOOK_QUANTITY="quantity";
    public  static final String COLUMN_BOOK_BOOKINGDAY="bookingday";
    public  static final String COLUMN_BOOK_TOTALCOST="totalcost";

    public  static final String TABLE_TOUR ="tour";
    public  static final String COLUMN_TOUR_ID="id";
    public  static final String COLUMN_TOUR_NAME="name";
    public  static final String COLUMN_TOUR_PRICE="id";
    public  static final String COLUMN_TOUR_DESCRIPTION="decscription";
    public  static final String COLUMN_TOUR_IMAGE="image";
    public  static final String COLUMN_TOUR_GROUPMEM="groupmem";

    public  static final String TABLE_TOURIMG ="tourimg";
    public  static final String COLUMN_TOURIMG_ID="id";
    public  static final String COLUMN_TOURIMG_IMAGE="image";
    public static Bitmap convertToBitMapFromAsset(Context context, String nameImage)
    {
        AssetManager assetManager=context.getAssets();
        try{
            InputStream inputStream=assetManager.open("images/"+nameImage);
            Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
            return bitmap;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }








}

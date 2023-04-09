package com.example.doanandroidtourdulich.Activity.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doanandroidtourdulich.R;
import com.example.doanandroidtourdulich.apdapter.PakageAdapter;
import com.example.doanandroidtourdulich.model.Package;
import com.example.doanandroidtourdulich.ui.DatabaseHandler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class PackageActivity extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    ListView listView;
    ArrayList<Package> list;
    PakageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package);
        try {
            db.copyDB2SDCard();
        } catch (IOException e) {
            e.printStackTrace();
        }
        addcontrol();
        readData();
    }

    private void addcontrol() {
        listView = (ListView) findViewById(R.id.package_list);
        list = new ArrayList<>();
        adapter = new PakageAdapter(this, list);
        listView.setAdapter(adapter);

    }

    private void readData() {
        Cursor cur = db.getCursor("select * from Tour");
        list.clear();
        if (cur.moveToFirst()) {
            do {
                String nameTour = cur.getString(1);
                String priceTour = cur.getString(4);
                byte[] imgTour = cur.getBlob(3);
                list.add(new Package( imgTour,nameTour,priceTour));

            } while (cur.moveToNext());
        }
        adapter.notifyDataSetChanged();
    }

}
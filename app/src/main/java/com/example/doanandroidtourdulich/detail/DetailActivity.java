package com.example.doanandroidtourdulich.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doanandroidtourdulich.R;
import com.example.doanandroidtourdulich.apdapter.PakageAdapter;
import com.example.doanandroidtourdulich.databinding.ActivityDetailBinding;
import com.example.doanandroidtourdulich.model.Package;
import com.example.doanandroidtourdulich.ui.DatabaseHandler;

import java.io.IOException;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    DatabaseHandler db = new DatabaseHandler(this);
    TextView tvName, tvDescription, tvPrice;
    Button bntadd;
    ImageView imgTour;
    Context context;
    ArrayList<Package> list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent callerIntent = getIntent();
        Bundle packagefromCaller = callerIntent.getBundleExtra("Data");
        tvName = (TextView) findViewById(R.id.txt_title);
        tvPrice = (TextView) findViewById(R.id.txt_price);
        tvDescription = (TextView) findViewById(R.id.txt_description);
        imgTour = (ImageView) findViewById(R.id.img_tour);

        String nam = packagefromCaller.getString("nameTour");
        Toast.makeText(DetailActivity.this, nam, Toast.LENGTH_SHORT).show();
        db.OpenDB();

        Cursor cur = db.getCursor("select * from Tour where NameTour='" + nam + "'");
        cur.moveToFirst();
        String name = cur.getString(1);
        String description = cur.getString(2);
        String price=cur.getString(4);
        byte[] img = cur.getBlob(3);
        tvPrice.setText(price);
        tvDescription.setText(description);
        tvName.setText(name);
        Bitmap bmImgTour = BitmapFactory.decodeByteArray(img, 0, img.length);//phan giai anh
        imgTour.setImageBitmap(bmImgTour);
        db.CloseDB();
    }

}

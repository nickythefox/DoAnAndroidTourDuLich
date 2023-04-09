package com.example.doanandroidtourdulich.apdapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doanandroidtourdulich.R;
import com.example.doanandroidtourdulich.detail.DetailActivity;
import com.example.doanandroidtourdulich.model.Package;

import java.util.ArrayList;

public class PakageAdapter extends BaseAdapter {
    Context context;
    ArrayList<Package> list;

    public PakageAdapter(Context context, ArrayList<Package> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertview, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.layoutitempackage, null);
        ImageView ivTour = (ImageView) row.findViewById(R.id.tour_image);
        TextView tvName = (TextView) row.findViewById(R.id.tour_name);
        TextView tvPrice=(TextView)  row.findViewById(R.id.tour_price);
        Button btndetail=(Button) row.findViewById(R.id.tour_details_button);
        Package aPackage = list.get(position);
        tvName.setText(aPackage.getNanme() + "");
        tvPrice.setText(aPackage.getPrice() + "");
        Bitmap bmivTour = BitmapFactory.decodeByteArray(aPackage.getImgTour(), 0, aPackage.getImgTour().length);
        ivTour.setImageBitmap(bmivTour);
        btndetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("nameTour", list.get(position).getNanme().toString());
                Intent in = new Intent(context, DetailActivity.class);
                in.putExtra("Data", bundle);
                context.startActivity(in);
            }
        });
        return row;
    }
}

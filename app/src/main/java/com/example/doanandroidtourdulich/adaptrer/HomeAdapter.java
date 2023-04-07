package com.example.doanandroidtourdulich.adaptrer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanandroidtourdulich.R;
import com.example.doanandroidtourdulich.model.Home;
import com.example.doanandroidtourdulich.model.Package;

import java.util.List;

public class HomeAdapter extends  RecyclerView.Adapter<HomeAdapter.PackageViewholder> {

    private List<Home> mlist;

    public HomeAdapter(List<Home> mlist) {
        this.mlist = mlist;
    }

    @NonNull

    @Override
    public PackageViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutitempackage,parent,false);

        return new PackageViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PackageViewholder holder, int position) {

        Home home=mlist.get(position);
        if(home==null){
            return;
        }
        holder.tvname.setText(home.getNanme());
        holder.tvprice.setText(home.getPrice());
        holder.imtour.setImageResource(home.getImgTour());


    }

    @Override
    public int getItemCount() {
        if(mlist!=null) {
            return mlist.size();
        }return 0;
    }

    public class PackageViewholder extends RecyclerView.ViewHolder{

        private TextView tvname,tvprice;
        private ImageView imtour;
        private Button btndetail;
        public PackageViewholder(@NonNull View itemView) {
            super(itemView);
            tvname=itemView.findViewById(R.id.tour_name);
            tvprice=itemView.findViewById(R.id.tour_price);
            imtour=itemView.findViewById(R.id.tour_image);
            btndetail=itemView.findViewById(R.id.tour_details_button);
        }
    }
}

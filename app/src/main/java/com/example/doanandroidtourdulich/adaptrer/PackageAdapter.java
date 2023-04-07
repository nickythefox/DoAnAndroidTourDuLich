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
import com.example.doanandroidtourdulich.model.Package;

import java.util.List;

public class PackageAdapter extends  RecyclerView.Adapter<PackageAdapter.PackageViewholder> {

    private List<Package> mlist;
    private IclickItemListener mIClickItemListener;
    public interface  IclickItemListener{
        void onClickItemPackage(Package apackage);
    }

    public PackageAdapter(List<Package> mlist, IclickItemListener iclickItemListener) {

        this.mlist = mlist;
        this.mIClickItemListener=iclickItemListener;
    }

    @NonNull

    @Override
    public PackageViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutitempackage,parent,false);

        return new PackageViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PackageViewholder holder, int position) {

        Package aPackage=mlist.get(position);
        if(aPackage==null){
            return;
        }
        holder.tvname.setText(aPackage.getNanme());
        holder.tvprice.setText(aPackage.getPrice());
        holder.imtour.setImageResource(aPackage.getImgTour());
        holder.btndetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIClickItemListener.onClickItemPackage(aPackage);
            }
        });


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

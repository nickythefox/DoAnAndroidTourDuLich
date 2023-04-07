package com.example.doanandroidtourdulich.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doanandroidtourdulich.Activity.ui.PackageActivity;
import com.example.doanandroidtourdulich.R;
import com.example.doanandroidtourdulich.adaptrer.PackageAdapter;
import com.example.doanandroidtourdulich.model.Package;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PackageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PackageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView rvpackage;
    private View mView;
    private PackageActivity mPackageactivity;

    public PackageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PackageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PackageFragment newInstance(String param1, String param2) {
        PackageFragment fragment = new PackageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_package, container, false);
        mPackageactivity=(PackageActivity) getActivity();
        rvpackage=mView.findViewById(R.id.package_list);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(mPackageactivity);
        rvpackage.setLayoutManager(linearLayoutManager);

        PackageAdapter packageAdapter=new PackageAdapter(getListPackage(), new PackageAdapter.IclickItemListener() {
            @Override
            public void onClickItemPackage(Package apackage) {
               //* mPackageactivity.gotoDeatailFragment(apackage);
            }
        });

        rvpackage.setAdapter(packageAdapter);
        RecyclerView.ItemDecoration itemDecoration= new DividerItemDecoration(mPackageactivity,DividerItemDecoration.VERTICAL);
        rvpackage.addItemDecoration(itemDecoration);
        return mView;
    }

    private List<Package> getListPackage() {
        List<Package> list = new ArrayList<>();


        /** list.add(new Package(R.drawable.tourimg1,"DaLat","2000.000 VND"));
        list.add(new Package(R.drawable.tourimg2,"DaLat","2000.000 VND"));
        list.add(new Package(R.drawable.tourimg3,"DaLat","2000.000 VND"));
        list.add(new Package(R.drawable.tourimg5,"DaLat","2000.000 VND"));
        list.add(new Package(R.drawable.tourimg6,"DaLat","2000.000 VND"));
        list.add(new Package(R.drawable.tourimg4,"DaLat","2000.000 VND"));
        list.add(new Package(R.drawable.tourimg7,"DaLat","2000.000 VND"));
        list.add(new Package(R.drawable.tourimg8,"DaLat","2000.000 VND"));
         **/

        return list;
    }
}
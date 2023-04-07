package com.example.doanandroidtourdulich.Activity.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.doanandroidtourdulich.R;
import com.example.doanandroidtourdulich.fragment.PackageFragment;
import com.example.doanandroidtourdulich.model.Package;

public class PackageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package);
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.content_package,new PackageFragment());
        fragmentTransaction.commit();
    }
  /**  public  void gotoDeatailFragment(Package apackage)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        DetailFragment detailFragment=new DetailFragment();

        Bundle bundle=new Bundle();
        bundle.putSerializable("object_package", apackage);
        detailFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.content_package,detailFragment);
        fragmentTransaction.addToBackStack(DetailFragment.TAG);
        fragmentTransaction.commit();

    }**/
}
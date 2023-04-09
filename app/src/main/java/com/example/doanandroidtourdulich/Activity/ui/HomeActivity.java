package com.example.doanandroidtourdulich.Activity.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.doanandroidtourdulich.R;
import com.example.doanandroidtourdulich.fragment.PackageFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        //fragmentTransaction.add(R.id.content_package,new PackageFragment());
        fragmentTransaction.commit();
    }
}
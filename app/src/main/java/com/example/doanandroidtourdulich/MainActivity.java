package com.example.doanandroidtourdulich;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.doanandroidtourdulich.fragment.CartFragment;
import com.example.doanandroidtourdulich.fragment.HomeFragment;
import com.example.doanandroidtourdulich.fragment.PackageFragment;
import com.example.doanandroidtourdulich.fragment.ReviewFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView mnBottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mnBottom = findViewById(R.id.navMenu);
        //

        //load len Fragment
        mnBottom.setOnItemSelectedListener(getListener());

    }
    void loadFragment(Fragment fmNew) {
        FragmentTransaction fmTran = getSupportFragmentManager().beginTransaction();
        fmTran.replace(R.id.main_fragment, fmNew);
        fmTran.addToBackStack(null);
        fmTran.commit();
    }
    private NavigationBarView.OnItemSelectedListener getListener() {
        return new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fmNew;
                switch (item.getItemId()) {
                    case R.id.mnHome:
                        loadFragment(new HomeFragment());
                        return true;
                    case R.id.mnPackage:
                        loadFragment(new PackageFragment());
                        return true;
                    case R.id.mnReview:
                        loadFragment(new ReviewFragment());
                        return true;
                    case R.id.mnCart:
                        loadFragment(new CartFragment());
                        return true;
                }
                return true;
            }
        };
    }

}
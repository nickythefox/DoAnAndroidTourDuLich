package com.example.doanandroidtourdulich;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toolbar;

import com.example.doanandroidtourdulich.Activity.ui.CartActivity;
import com.example.doanandroidtourdulich.Activity.ui.HomeActivity;
import com.example.doanandroidtourdulich.Activity.ui.PackageActivity;
import com.example.doanandroidtourdulich.fragment.CartFragment;
import com.example.doanandroidtourdulich.fragment.HomeFragment;
import com.example.doanandroidtourdulich.fragment.PackageFragment;
import com.example.doanandroidtourdulich.fragment.ReviewFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ListView listView;
    ArrayList<itemMenu> arrayList;
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
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return true;
    }

    @NonNull
    private NavigationBarView.OnItemSelectedListener getListener() {
        return new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fmNew;
                switch (item.getItemId()) {
                    case R.id.mnHome:
                        OpenActivity(new HomeActivity());
                        return true;
                    case R.id.mnPackage:
                        OpenActivity(new PackageActivity());
                        return true;
                   /**case R.id.mnReview:
                        loadFragment(new ReviewFragment());
                        return true;**/

                    case R.id.mnCart:
                        OpenActivity(new CartActivity());
                        return true;
                }
                return true;
            }
        };
    }

    void OpenActivity(Activity activity) {
        Intent i = new Intent(this,activity.getClass());
        startActivity(i);

    }
}


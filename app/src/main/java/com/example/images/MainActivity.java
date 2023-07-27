package com.example.images;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.images.Module.Adapter;
import com.example.images.Module.ImageInstance;
import com.example.images.Module.ImageInterface;
import com.example.images.Module.Model;
import com.example.images.Module.Photo;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView=findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        replaceFragment(new HomeFragment());

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        replaceFragment(new HomeFragment());
                                
                    break;
                    case R.id.searlist:
                        replaceFragment(new SearchFragment());
                        
                        break;
                    case  R.id.myfavourite:
                        replaceFragment(new FavouriteFragment());
                        break;
                    default:
                        replaceFragment(new HomeFragment());
                        break;

                }
                return true;
            }
        });


    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }
}

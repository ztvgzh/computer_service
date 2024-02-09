package com.ztvgzh.computerservice;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener {

    private Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    HomeFragment homeFragment;
    CartFragment blankFragment;
    ProfileFragment profileFragment;
    SearchFragment searchFragment;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initialize();

        homeFragment = new HomeFragment();
        blankFragment = new CartFragment();
        profileFragment = new ProfileFragment();
        searchFragment = new SearchFragment();

        changeFragment(homeFragment);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottom_home:
                        changeFragment(homeFragment);
                        break;
                    case R.id.bottom_blank:
                        changeFragment(blankFragment);
                        break;
                    case R.id.bottom_profile:
                        changeFragment(profileFragment);
                        break;
                    case R.id.bottom_search:
                        changeFragment(searchFragment);
                        break;
                }
                return false;
            }
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(this);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }
    private void initialize() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawer_layout_id);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            //case R.id.nav_category:
             //startActivity(new Intent(Dashboard.this, ProductsActivity.class));
        }
        return true;
    }

    @Override
    public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(@NonNull View drawerView) {

    }

    @Override
    public void onDrawerClosed(@NonNull View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }

}
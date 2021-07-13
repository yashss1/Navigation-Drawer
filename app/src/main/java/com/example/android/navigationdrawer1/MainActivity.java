package com.example.android.navigationdrawer1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new BasketFragment()).commit();
            navigationView.setCheckedItem(R.id.basket);
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id){
                    case R.id.search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new SearchFragment()).commit();
                        navigationView.setCheckedItem(R.id.search);
                        break;
                    case R.id.basket:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new BasketFragment()).commit();
                        navigationView.setCheckedItem(R.id.basket);
                        break;
                    case R.id.favorite:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new FavFragment()).commit();
                        navigationView.setCheckedItem(R.id.favorite);
                        break;
                    case R.id.orders:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new OrderFragment()).commit();
                        navigationView.setCheckedItem(R.id.orders);
                        break;
                    case R.id.settings:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new SettingsFragment()).commit();
                        navigationView.setCheckedItem(R.id.settings);
                        break;
                    case R.id.support:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new SupportFragment()).commit();
                        navigationView.setCheckedItem(R.id.support);
                        break;
                    case R.id.promo_code:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new PromoCodeFragment()).commit();
                        navigationView.setCheckedItem(R.id.promo_code);
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });
    }
}
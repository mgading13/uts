package com.gading.utsnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private HomeFragment homeFragment;
    private MovieFragment movieFragment;
    private AccountFragment accountFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi fragment
        homeFragment = new HomeFragment();
        movieFragment = new MovieFragment();
        accountFragment = new AccountFragment();

        // Menampilkan fragment default saat aplikasi pertama kali dibuka
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                homeFragment).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            if (item.getItemId() == R.id.action_home) {
                selectedFragment = homeFragment;
            } else if (item.getItemId() == R.id.action_movie) {
                selectedFragment = movieFragment;
            } else if (item.getItemId() == R.id.action_account) {
                selectedFragment = accountFragment;
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();
            }

            return true;
        });
    }
}
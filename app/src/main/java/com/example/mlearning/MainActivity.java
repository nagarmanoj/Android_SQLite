package com.example.mlearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hide action bar
        getSupportActionBar().hide();

        BottomNavigationView bottomNavigationView = findViewById(R.id.botton_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navLisner);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navLisner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.nav_home:
                            Intent intent = new Intent(getApplicationContext(),HomePageActivity.class);
                            startActivity(intent);
                            break;
                        case R.id.nav_search:
                            startActivity(new Intent(getApplicationContext(),SearchActivity.class));
                            break;
                        case R.id.nav_add:
                            startActivity(new Intent(getApplicationContext(),AddActivity.class));
                            break;
                        case R.id.nav_account:
                            startActivity(new Intent(getApplicationContext(),AccountActivity.class));
                            break;

                    }
                    return true;
                }
            };
}
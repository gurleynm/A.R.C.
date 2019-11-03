package com.android.arc;

import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.arc.Pages.DefaultScreen;
import com.android.arc.Pages.StartPage;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            DefaultScreen landingFragment = new DefaultScreen();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, landingFragment).commit();
        }
    }
}

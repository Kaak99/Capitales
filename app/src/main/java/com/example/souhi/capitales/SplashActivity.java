package com.example.souhi.capitales;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//
//public class SplashActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash);
//    }
//}


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


public class SplashActivity extends AppCompatActivity {

    //initialisation
    private static int SPLASH_TIME_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Toast.makeText(getApplicationContext(),"apreslayout", Toast.LENGTH_SHORT);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),"avantintent", Toast.LENGTH_SHORT);
                Intent intent = new Intent(SplashActivity.this, ChooseActivity.class);
                startActivity(intent);
                //finish();
                Toast.makeText(getApplicationContext(),"fin", Toast.LENGTH_SHORT);
            }
        }, SPLASH_TIME_OUT);

    }  //fin du on create


}  // fin du main


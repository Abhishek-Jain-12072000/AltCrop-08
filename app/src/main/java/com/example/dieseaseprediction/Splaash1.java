package com.example.dieseaseprediction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splaash1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splaash1);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            Intent i=new Intent(Splaash1.this,MainActivity.class);
            @Override
            public void run() {
                startActivity(i);
            }
        }, 4000);
    }
}
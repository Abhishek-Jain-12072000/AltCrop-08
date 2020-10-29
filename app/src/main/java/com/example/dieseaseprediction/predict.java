package com.example.dieseaseprediction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

public class predict extends AppCompatActivity {
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predict);
        t1 = findViewById(R.id.vv);
        //Extract the data…
        Bundle bundle = getIntent().getExtras();
        final String stuff = bundle.getString("nf");
        final String stuff1 = bundle.getString("if");

        t1.setText(stuff);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            Intent i = new Intent(predict.this, Final.class);
            Bundle bundle = new Bundle();
            String getrec = t1.getText().toString();


            @Override
            public void run() {
                bundle.putString("nf", getrec);
                bundle.putString("if", stuff1);
                i.putExtras(bundle);

                startActivity(i);
            }
        }, 5000);
    }
}
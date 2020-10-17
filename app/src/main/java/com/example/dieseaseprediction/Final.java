package com.example.dieseaseprediction;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.util.Locale;

public class Final extends AppCompatActivity {
TextView textView,t1,t2,t3,t4,t5,t6,t7,pred;
ImageButton btn;
ImageView i1;
TextToSpeech tt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);





        textView = findViewById(R.id.textet);
        t1 = findViewById(R.id.textett);
        i1=findViewById(R.id.images);
        t2=findViewById(R.id.textet2);
        t3 = findViewById(R.id.textet3);
        t4=findViewById(R.id.textet4);
        t5 = findViewById(R.id.textet5);
        t6=findViewById(R.id.textet6);
        btn=findViewById(R.id.btnbtn);
        t7 = findViewById(R.id.textet7);
        pred = findViewById(R.id.prediction);
        Bundle bundle = getIntent().getExtras();
//Extract the data…
        String stuff = bundle.getString("nf");
        String stuff1= bundle.getString("if");


        Uri uri= Uri.parse(stuff1);
        i1.setImageURI(uri);




        if (stuff.charAt(0) == 'F') {
            t1.setText(getString(R.string.false_smut));
            t3.setText(getString(R.string.fc));
            t5.setText(getString(R.string.fb));

            t7.setText(getString(R.string.fp));


        } else if (stuff.charAt(0) == 'H') {
            t1.setText(getString(R.string.healt));
            t3.setText(getString(R.string.hel));
            t2.setVisibility(View.GONE);
            t4.setVisibility(View.GONE);
            t5.setVisibility(View.GONE);
            t6.setVisibility(View.GONE);
            t7.setVisibility(View.GONE);



        } else if (stuff.charAt(0) == 'N') {
            t1.setText(getString(R.string.neck));
            t3.setText(getString(R.string.nc));
            t5.setText(getString(R.string.nb));

            t7.setText(getString(R.string.np));
        } else {
            t1.setText(getString(R.string.bect));
            t3.setText(getString(R.string.bc));
        t5.setText(getString(R.string.bb));
            t7.setText(getString(R.string.bp));
        }



        tt1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
//                    tt1.setLanguage(Local.US);
                    tt1.setLanguage(new Locale("hin"));
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r= textView.getText().toString();
                String r1= t1.getText().toString();
                String r2= t2.getText().toString();
                String r3= t3.getText().toString();
                String r4= t4.getText().toString();
                String r5= t5.getText().toString();
                String r6= t6.getText().toString();
                String r7= t7.getText().toString();

                String rr=r + r1 +r2+r3+r4+r5+r6+r7;

                tt1.speak(rr, TextToSpeech.QUEUE_FLUSH, null);


            }
        });








    }
    public void onPause () {
        if (tt1 != null) {
            tt1.stop();
            tt1.shutdown();
        }
        super.onPause();
    }




    }






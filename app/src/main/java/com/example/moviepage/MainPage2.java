package com.example.moviepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainPage2 extends AppCompatActivity {
    Button inCinema,online;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        inCinema=findViewById(R.id.inthecinema);
        online=findViewById(R.id.online);
        inCinema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainPage2.this, MovePage1.class);
                startActivity(i);

            }
        });
        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainPage2.this, MainPage3.class);
                startActivity(i);
            }
        });

    }
}
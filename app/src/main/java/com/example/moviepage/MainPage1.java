package com.example.moviepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainPage1 extends AppCompatActivity {
    TextView movies,cinema,support;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        movies=findViewById(R.id.move);
        cinema=findViewById(R.id.cinemas);

        support=findViewById(R.id.supports);
        movies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainPage1.this, MainPage2.class);
                startActivity(i);

            }
        });
        cinema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainPage1.this, CinemaPage1.class);
                startActivity(i);

            }
        });

        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainPage1.this, Support.class);
                startActivity(i);

            }
        });

    }
}
package com.example.moviepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainPage3 extends AppCompatActivity {
    ImageView action,anamation,drama,comedy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        action=findViewById(R.id.action1);
        anamation=findViewById(R.id.animation1);
        drama=findViewById(R.id.drama1);
        comedy=findViewById(R.id.comdy1);
        Intent i=new Intent(MainPage3.this, MovePage3.class);
        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("typenum",1);
                startActivity(i);
            }
        });
        comedy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("typenum",2);
                startActivity(i);
            }
        });
        drama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("typenum",3);
                startActivity(i);
            }
        });


        anamation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("typenum",4);
                startActivity(i);
            }
        });

    }
}
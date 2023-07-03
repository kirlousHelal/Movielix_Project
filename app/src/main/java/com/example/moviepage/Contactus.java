package com.example.moviepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Contactus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main15);
    }
    public void Peter(View view) {
        Intent intent= new Intent(this,Peter.class);
        startActivity(intent);
    }

    public void Marina(View view) {
        Intent intent1= new Intent(this,Marina.class);
        startActivity(intent1);
    }

    public void Kiro(View view) {
        Intent intent= new Intent(this,Kiro.class);
        startActivity(intent);
    }

    public void Nada(View view) {
        Intent intent= new Intent(this,Nada.class);
        startActivity(intent);
    }

    public void Joe(View view) {
        Intent intent= new Intent(this,Joe.class);
        startActivity(intent);
    }

    public void Eman(View view) {
        Intent intent= new Intent(this,Eman.class);
        startActivity(intent);
    }
}
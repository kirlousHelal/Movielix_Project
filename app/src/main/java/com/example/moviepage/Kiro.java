package com.example.moviepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Kiro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiro);
    }
    public void back(View view) {
        Intent intent= new Intent(this, Contactus.class);
        startActivity(intent);}
}
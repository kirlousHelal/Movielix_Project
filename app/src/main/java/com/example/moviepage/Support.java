package com.example.moviepage;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Support extends AppCompatActivity {
    EditText email;
    EditText msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        email=(EditText) findViewById(R.id.Email);
        msg=(EditText) findViewById(R.id.Message);



    }
    public void Send(View view) {
        email.setText("");
        msg.setText("");
        Toast.makeText(getApplicationContext(),"We recived your Message",Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"We'll Contact you",Toast.LENGTH_SHORT).show();
    }
}
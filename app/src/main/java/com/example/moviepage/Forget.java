package com.example.moviepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Forget extends AppCompatActivity {
    EditText etemail;
    Button btnRest;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);
        btnRest=findViewById(R.id.btn_reset);
        etemail=findViewById(R.id.et_EmailAddress_forget);
        db=new DBHelper(this);
        btnRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=etemail.getText().toString();
                if(email.equals(""))
                    Toast.makeText(Forget.this, "please enter the email", Toast.LENGTH_SHORT).show();
                else
                {
                    Boolean checkemail=db.checkemail(email);
                    if(checkemail)
                    {
                        Intent goTORest=new Intent(Forget.this, Reset.class);
                        goTORest.putExtra("txemail",email);
                        startActivity(goTORest);
                    }
                    else
                    {
                        Toast.makeText(Forget.this, "the Email dosen't exist", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
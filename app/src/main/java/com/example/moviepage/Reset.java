package com.example.moviepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Reset extends AppCompatActivity {
    TextView txemail;
    EditText etnewpassword,etcomfirmpassword;
    Button btnconfirm;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);
        etcomfirmpassword=findViewById(R.id.et_confirmpassword);
        txemail=findViewById(R.id.tx_emailrest);
        etnewpassword=findViewById(R.id.et_newpassword);
        btnconfirm=findViewById(R.id.btn_confirm);
        db=new DBHelper(this);

        Intent intent=getIntent();
        txemail.setText(intent.getStringExtra("txemail"));

        btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=txemail.getText().toString();
                String pass= etnewpassword.getText().toString();
                String repass=etcomfirmpassword.getText().toString();

                if(pass.equals("")||repass.equals(""))
                    Toast.makeText(Reset.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)) {
                        Boolean checkpasswordupdate = db.updatepassword(email, pass);
                        if (checkpasswordupdate) {
                            Intent gotoLogin = new Intent(Reset.this, Login.class);
                            startActivity(gotoLogin);
                            Toast.makeText(Reset.this, "password updated successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Reset.this, "password updated faild", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Reset.this, "passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
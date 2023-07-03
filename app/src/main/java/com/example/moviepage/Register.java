package com.example.moviepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    Button btnRegister;
    TextView txAleardyHaveAccount;
    EditText /*etFirstname,etLastname,*/etEmailAddress,etPhonenumber,etPass,etRepass;
    EditText etUsername;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        btnRegister=findViewById(R.id.btn_register);
        txAleardyHaveAccount=findViewById(R.id.txt_AlreadyHaveAccount);
        etEmailAddress=findViewById(R.id.et_EmailAddress);
        //  etFirstname=findViewById(R.id.et_Firstname);
        //etLastname=findViewById(R.id.et_Lastname);
        etUsername=findViewById(R.id.et_usernameRegister);
        etPass=findViewById(R.id.et_passwordResgister);
        etRepass=findViewById(R.id.et_RepasswordResgister);
        etPhonenumber=findViewById(R.id.et_Phonenumber);
        DB=new DBHelper(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String UserName = etUsername.getText().toString();
                String Password = etPass.getText().toString();
                String Repassword = etRepass.getText().toString();
                String Email = etEmailAddress.getText().toString();
                String PhoneNumber = etPhonenumber.getText().toString();

                if (UserName.equals("")|| Password.equals("") || Repassword.equals("") || Email.equals("") || PhoneNumber.equals("")) {
                    Toast.makeText(Register.this, "Please Enter All The Fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (Password.equals(Repassword)) {
                        Boolean checkuser = DB.checkusername(UserName);
                        if (!checkuser) {
                            Boolean insert = DB.insertData(UserName,Password, Email, PhoneNumber);
                            if (insert) {
                                Toast.makeText(Register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent goToHome = new Intent(Register.this, Login.class);
                                startActivity(goToHome);
                            }
                            else
                            {
                                Toast.makeText(Register.this, "Registered Faild", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(Register.this, "The User Name is already exist", Toast.LENGTH_SHORT).show();
                        }
                    } else
                    {
                        Toast.makeText(Register.this, "The confirm Password Not matching", Toast.LENGTH_LONG).show();
                        etRepass.setText("");
                    }

                }
            }
        });



        txAleardyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToHome =new Intent(Register.this, Login.class);
                startActivity(goToHome);
            }
        });
    }
}
package com.example.moviepage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    TextView txforgetpassword,txRegister;
    Button btnLogin;
    boolean pressedBack=false;
    CheckBox chRememberMe;
    EditText etUsername,etPassword;
    DBHelper DB;
    @Override
    public void onBackPressed() {
        if (pressedBack) {
            super.onBackPressed();
        } else {
            pressedBack = true;
            Toast.makeText(this, "Press Again TO Exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    pressedBack=false;
                }
            },3000);
            /*new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pressedBack = false;
                }
            }).start();*/
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        txforgetpassword=findViewById(R.id.txt_forgetpassword);
        txRegister=findViewById(R.id.txt_register);
        btnLogin=findViewById(R.id.btnLogin);
        etPassword=findViewById(R.id.et_PasswordLogin);
        etUsername=findViewById(R.id.et_UsernameLogin);
        chRememberMe=findViewById(R.id.ch_RememberMe);
        DB=new DBHelper(this);


        txforgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToForgetPassword=new Intent(Login.this, Forget.class);
                startActivity(goToForgetPassword);
            }
        });

        txRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToRgister=new Intent(Login.this, Register.class);
                startActivity(goToRgister);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username=etUsername.getText().toString();
                String password=etPassword.getText().toString();


                if(username.equals("")||password.equals(""))
                {
                    Toast.makeText(Login.this, "please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean chekusernamepassword=DB.checkusernamepassword(username,password);
                    if(chekusernamepassword)
                    {
                        Toast.makeText(Login.this, "Welcome to The Movielix App", Toast.LENGTH_SHORT).show();
                        Intent goToHome=new Intent(Login.this, MainPage1.class);
                        startActivity(goToHome);
                    }
                    else
                    {
                        Toast.makeText(Login.this, "Invalid Credentails`", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


    }
}
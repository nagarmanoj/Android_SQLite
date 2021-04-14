package com.example.mlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    Button login,forget,register;
    DBHelper MyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);

        login = (Button) findViewById(R.id.btnLogin);
        forget =(Button) findViewById(R.id.forgetPassword);

        register = (Button) findViewById(R.id.btnRegister);

        MyDB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = email.getText().toString();
                String passwordText = password.getText().toString();

                if(emailText.equals("")|| passwordText.equals("")){
                    Toast.makeText(LoginActivity.this,"Please enter all fields",Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkEmailPass = MyDB.checkLoginData(emailText,passwordText);
                    if(checkEmailPass == true){
                        Toast.makeText(LoginActivity.this,"Sign In Sucessfully",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),AccountActivity.class);
                        intent.putExtra("gmailId",emailText);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                    }
                }
                
            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PasswordActivity.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SigninActivity.class));
            }
        });
    }
}
package com.example.mlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {

    EditText user,pass,confirmpass,email,phone;
    Button register , signin;

    DBHelper MyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        user = (EditText) findViewById(R.id.username);
        pass = findViewById(R.id.password);
        confirmpass = findViewById(R.id.confirmPassword);
        email = findViewById(R.id.emailid);
        phone = findViewById(R.id.number);

        register = (Button) findViewById(R.id.btnInsertData);
        signin = (Button) findViewById(R.id.btnSignin);

        MyDB = new DBHelper(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userText = user.getText().toString();
                String passText = pass.getText().toString();
                String confirmText = confirmpass.getText().toString();
                String emailText = email.getText().toString();
                String contactText = phone.getText().toString();

                Boolean checkData = MyDB.insertData(userText,passText,confirmText,emailText,contactText);
                if (checkData == true){
                    Toast.makeText(SigninActivity.this,"Register Sucessfull",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SigninActivity.this,"Register Do Not Sucessfull",Toast.LENGTH_SHORT).show();
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SigninActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
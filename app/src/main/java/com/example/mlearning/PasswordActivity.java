package com.example.mlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PasswordActivity extends AppCompatActivity {

    Button reset;
    EditText emailid;
    DBHelper MyDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        emailid = (EditText) findViewById(R.id.emailid2);
        reset = (Button) findViewById(R.id.resetPassword);
        MyDb = new DBHelper(this);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailidText = emailid.getText().toString();
                Boolean checkEmail = MyDb.checkEmailId(emailidText);
                if(checkEmail == true){
                    Intent intent = new Intent(getApplicationContext(),ResetActivity.class);
                    intent.putExtra("EmailId",emailidText);
                    startActivity(intent);
                }else{
                    Toast.makeText(PasswordActivity.this,"User does not exist",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
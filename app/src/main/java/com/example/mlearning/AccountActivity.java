package com.example.mlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AccountActivity extends AppCompatActivity {

    TextView emailid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        emailid = (TextView) findViewById(R.id.gmail_account);
        Intent intent = getIntent();
        emailid.setText(intent.getStringExtra("gmailId"));
    }
}
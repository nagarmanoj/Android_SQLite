package com.example.mlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResetActivity extends AppCompatActivity {

    TextView gmail;
    Button submit;
    EditText pass,repass;
    DBHelper MyDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        gmail = (TextView) findViewById(R.id.text_emailid);
        pass = (EditText) findViewById(R.id.password123);
        repass = (EditText) findViewById(R.id.repassword123);
        submit = (Button) findViewById(R.id.btnConfirm);
        MyDb = new DBHelper(this);

        Intent intent = getIntent();
        gmail.setText(intent.getStringExtra("EmailId"));


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gmailText = gmail.getText().toString();
                String passText = pass.getText().toString();
                String repassText = repass.getText().toString();
                if(passText.equals(repassText))
                {
                    Boolean updatePass = MyDb.updatePassword(gmailText,passText);
                    if(updatePass == true){
                        Intent intent1 = new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(intent1);
                        Toast.makeText(ResetActivity.this,"Password update sucessfylly",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(ResetActivity.this,"Password Not update",Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(ResetActivity.this,"Password Not Matching",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
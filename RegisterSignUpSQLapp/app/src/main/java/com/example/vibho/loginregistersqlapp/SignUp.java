package com.example.vibho.loginregistersqlapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {


    EditText username,password,email;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        db = new Database(getApplicationContext());

        Button signup = findViewById(R.id.button5);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db.putInfo(username.getText().toString(), password.getText().toString(), email.getText().toString());
                Toast.makeText(SignUp.this, "New user created!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SignUp.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}

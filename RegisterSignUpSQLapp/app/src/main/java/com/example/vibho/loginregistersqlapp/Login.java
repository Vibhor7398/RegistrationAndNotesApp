package com.example.vibho.loginregistersqlapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends AppCompatActivity {


    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText username = findViewById(R.id.editText);
        final EditText password = findViewById(R.id.editText2);
        Button login = findViewById(R.id.button3);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean check = db.verify(username.getText().toString(), password.getText().toString());

                if (check) {
                    Intent i = new Intent(Login.this, ShowDetails.class);
                    i.putExtra("Username", username.getText().toString());
                    startActivity(i);
                } else {
                    Toast.makeText(Login.this, "Enter valid details.", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}


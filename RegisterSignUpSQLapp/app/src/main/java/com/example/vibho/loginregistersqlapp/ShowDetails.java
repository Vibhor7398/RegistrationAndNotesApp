package com.example.vibho.loginregistersqlapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import android.widget.ListView;

public class ShowDetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);



        Bundle b = getIntent().getExtras();
        String user = b.getString("username");
        Toast.makeText(this,"Hello "+user+ ". Have a great day!",Toast.LENGTH_SHORT).show();

    }
}

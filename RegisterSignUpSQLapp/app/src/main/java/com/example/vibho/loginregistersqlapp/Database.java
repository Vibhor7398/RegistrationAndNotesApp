package com.example.vibho.loginregistersqlapp;

import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;
import java.util.ArrayList;

public class Database {
    SQLiteDatabase db;
    Context context;



    Database(Context context)
    {
        this.context = context;
        db = context.openOrCreateDatabase("userDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS table (username VARCHAR, password VARCHAR, email VARCHAR)");
    }



    boolean verify(String username, String password)
    {
        Cursor c = null;
        c = db.rawQuery("select password from table where username='"+username+"'",null);
        String pwd_org="";
        if(c.moveToFirst()){
            int i = c.getColumnIndex("password");
            pwd_org = c.getString(i);
        }
        if(password.compareTo(pwd_org)==0){
            return true;
        }
        return false;
    }



    void putInfo(String username, String password, String email)
    {

        try{

            db.execSQL("INSERT INTO table VALUES('" +username+ "','" +password+ "','" +email+ "')");
           // Toast.makeText(context, "Table Created", Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}

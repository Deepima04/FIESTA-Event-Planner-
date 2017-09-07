package com.example.deepi.fiesta;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.ByteArrayOutputStream;

public class HomeScreen extends AppCompatActivity {

    AppDBManager adm=null;
    private Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        session= new Session(this);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("info", MODE_PRIVATE);
        String first=pref.getString("user_name_fetch", null);

        adm=new AppDBManager(this);
        adm.openDb();
        adm.checkDb();

        if(!session.loggedin())
        {
            logoutt();
        }

    }



    public void planevent(View v)
    {
        Intent i=new Intent(this,PlanEvents.class);
        startActivity(i);
    }

    public void logout(View v)
    {

        logoutt();
    }

    public void logoutt()
    {
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(HomeScreen.this,Main.class));
    }

}

package com.example.deepi.fiesta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Birthday extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
    }




    public void view_birthdaypackages(View v)
    {
        Intent i=new Intent(this,BirthdayPackages.class);
        startActivity(i);
    }
}

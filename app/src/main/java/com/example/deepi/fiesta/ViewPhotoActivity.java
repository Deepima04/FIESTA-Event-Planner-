package com.example.deepi.fiesta;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewPhotoActivity extends AppCompatActivity {

    AppDBManager adm=null;
    String n;
    ViewPager viewPager;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_photo);

      /*  Intent i=getIntent();
        n=i.getExtras().getString("photokeypass");*/
        customAdapter= new CustomAdapter(this);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(customAdapter);


    }




}

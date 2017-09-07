package com.example.deepi.fiesta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Wedding extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wedding);
    }


 public void view_weddingpackages(View v)
 {
     Intent i=new Intent(this,WeddingPackages.class);
     startActivity(i);

 }



    /*public void platinumwedding(View v)
    {
        String custkey1="platinum";
        Intent i=new Intent(this,CustomizeWedding.class);
        i.putExtra("custkey",custkey1);
        startActivity(i);
    }

    public void goldwedding(View v)
    {
        String custkey2="gold";
        Intent i=new Intent(this,CustomizeWedding.class);
        i.putExtra("custkey",custkey2);
        startActivity(i);
    }

    public void silverwedding(View v)
    {
        String custkey3="silver";
        Intent i=new Intent(this,CustomizeWedding.class);
        i.putExtra("custkey",custkey3);
        startActivity(i);
    }*/


}

package com.example.deepi.fiesta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PickYourVenue extends AppCompatActivity {

    String eventpicked,weddingcharge2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_your_venue);

        Intent k=getIntent();
        eventpicked=k.getExtras().getString("pickedevent");
        weddingcharge2=k.getExtras().getString("chargewedding1");
    }

    public void btnplace(View v)
    {
        Intent i=new Intent(this,AllPlaces.class);
        i.putExtra("pickedeventt",eventpicked);
        i.putExtra("chargewedding2",weddingcharge2);
        startActivity(i);
    }


    public void btnvenue(View v)
    {
        Intent i=new Intent(this,AllVenues.class);
        i.putExtra("pickedeventt",eventpicked);
        i.putExtra("chargewedding2",weddingcharge2);
        startActivity(i);
    }

}

package com.example.deepi.fiesta;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowVenue extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listview = null;
    ArrayList<Venue> venuelist = null;
    AppDBManager adm = null;
    String mm;
    Venue v=null;
    String n,eventpickeddd,weddingcharge4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_venue);
        Intent i=getIntent();
        n= i.getStringExtra("key");
        eventpickeddd= i.getStringExtra("pickedeventtt");
        weddingcharge4= i.getStringExtra("chargewedding3");
        adm = new AppDBManager(this);
        listview = (ListView) findViewById(R.id.listview);

        venuelist = new ArrayList<Venue>();
        adm.openDb();
     //   populateVenueList();

        Cursor c=adm.fetch(n);

        if(c!=null&&c.moveToFirst())
        {
            do {
                int id=c.getInt(c.getColumnIndex(AppConstants.COLUMN_MID));
                String name=c.getString(c.getColumnIndex(AppConstants.COLUMN_MNAME));
                String charge=c.getString(c.getColumnIndex(AppConstants.COLUMN_CHARGES));
                String cap=c.getString(c.getColumnIndex(AppConstants.COLUMN_CAPACITY));
                String phono=c.getString(c.getColumnIndex(AppConstants.COLUMN_PHNO));
                String des=c.getString(c.getColumnIndex(AppConstants.COLUMN_DESCRIPTION));
                //String deco=c.getString(c.getColumnIndex(AppConstants.COLUMN_DECORATION));
                String cater=c.getString(c.getColumnIndex(AppConstants.COLUMN_CATERING));
                //String music=c.getString(c.getColumnIndex(AppConstants.COLUMN_MUSIC));
                //String bar=c.getString(c.getColumnIndex(AppConstants.COLUMN_BAR));
                String lat=c.getString(c.getColumnIndex(AppConstants.COLUMN_LAT));
                String longi=c.getString(c.getColumnIndex(AppConstants.COLUMN_LONG));
                String plname=c.getString(c.getColumnIndex(AppConstants.COLUMN_PLACENAME));
               // byte[] arr = c.getBlob(c.getColumnIndex(AppConstants.COLUMN_IMAGE));

                v=new Venue();

                v.setMid(id);
                v.setMname(name);
            v.setCharges(charge);
            v.setCapacity(cap);
            v.setPhno(phono);
            v.setDescription(des);
            //v.setDecoration(deco);
            v.setCatering(cater);
            //v.setMusic(music);
            //v.setBar(bar);
            v.setLatitude(lat);
            v.setLongitude(longi);
            v.setPlacename(plname);
            //v.setMimage(arr);

                // ci.setSname(sname);
                //hc.setHm();

                venuelist.add(v);
            }while(c.moveToNext());
            c.close();
        }
        ArrayAdapter<Venue> ad=new ArrayAdapter<Venue>(this,android.R.layout.simple_list_item_1,venuelist);

//        MyAdapter ad = new MyAdapter(this, venuelist);
        listview.setAdapter(ad);
        listview.setOnItemClickListener(this);
        /*ArrayAdapter<Venue> ad=new ArrayAdapter<Venue>(this,android.R.layout.simple_list_item_1,venuelist);

        //MyAdapter adu = new MyAdapter(this, venuelist);
        listview.setAdapter(ad);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(ShowVenue.this, "You Clicked at " + item, Toast.LENGTH_SHORT).show();
                *//*Intent i=new Intent(ShowVenue.this,ShowDescription.class);
                i.putExtra("city",item);
                startActivity(i);*//*

            }
        });*/

    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
       // Toast.makeText(ShowVenue.this, "You Clicked at " + item, Toast.LENGTH_SHORT).show();
        Intent i=new Intent(ShowVenue.this,ShowDescription.class);
        i.putExtra("venue",item);
        i.putExtra("pickedeventttt",eventpickeddd);
        i.putExtra("chargewedding4",weddingcharge4);
        startActivity(i);
    }
}

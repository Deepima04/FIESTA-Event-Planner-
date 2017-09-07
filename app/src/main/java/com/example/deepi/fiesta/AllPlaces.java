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

public class AllPlaces extends AppCompatActivity implements AdapterView.OnItemClickListener{

  //  AppDBManager adm=null;
    ListView lv=null;

//    ArrayList<String> hclist=null;

    String[] PLACESNAMES=new String[] {"Hazratganj","Gomtinagar","Alambagh","Rajajipuram","Aliganj","Charbagh"};

    String eventpickedd,weddingcharge3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_places);

        Intent k=getIntent();
        eventpickedd=k.getExtras().getString("pickedeventt");
        weddingcharge3=k.getExtras().getString("chargewedding2");
        //adm=new AppDBManager(this);
        //hclist=new ArrayList<String>();
        //adm.openDb();
        //populateCityList();
        lv=(ListView)findViewById(R.id.lv);
        ArrayAdapter<String> ad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,PLACESNAMES);
        lv.setAdapter(ad);
        lv.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        String hm=(String)lv.getItemAtPosition(i);

//        Toast.makeText(this,hm,Toast.LENGTH_LONG).show();
        Intent a=new Intent(this,ShowVenue.class);
        a.putExtra("key", hm);
        a.putExtra("pickedeventtt",eventpickedd);
        a.putExtra("chargewedding3",weddingcharge3);
        startActivity(a);
    }


}

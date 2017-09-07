package com.example.deepi.fiesta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AllVenues extends AppCompatActivity implements AdapterView.OnItemClickListener{


    ListView lv5=null;
    String[] VENUENAMES=new String[] {"RoyalInn","RoyalCafe","Blue","SpiceFactory","Essence","Myraid","Taj","Chemistry","Vintage","Mocha","Dayal","Piccadily","5Seasons","SpiceCaves","Skyhilton","Ginger","Gulmohar","Fuzion","Aryans","SecretBarn","Salt","Cassia","SignInn","Heritage","Metro","Maharaja","LucknowLocal","DeepAvadh"};

    String eventpickeddd,weddingcharge4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_venues);

        Intent k=getIntent();
        eventpickeddd=k.getExtras().getString("pickedeventt");
        weddingcharge4=k.getExtras().getString("chargewedding2");


        lv5=(ListView)findViewById(R.id.lv5);
        ArrayAdapter<String> ad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,VENUENAMES);
        lv5.setAdapter(ad);
        lv5.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        //String item = parent.getItemAtPosition(position).toString();
        String item=(String)lv5.getItemAtPosition(position);
        // Toast.makeText(ShowVenue.this, "You Clicked at " + item, Toast.LENGTH_SHORT).show();
        Intent i=new Intent(AllVenues.this,ShowDescription.class);
        i.putExtra("venue",item);
        i.putExtra("pickedeventttt",eventpickeddd);
        i.putExtra("chargewedding4",weddingcharge4);
        startActivity(i);

    }
}

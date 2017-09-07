package com.example.deepi.fiesta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PlanEvents extends AppCompatActivity implements AdapterView.OnItemClickListener {


    String[] EVENTNAMES = new String[]{"Wedding", "Birthday", "Product Launch", "Seminars", "Conferences"};
    ListView lvvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_events);

        lvvv = (ListView) findViewById(R.id.listplanevents);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, EVENTNAMES);
        lvvv.setAdapter(ad);
        lvvv.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String hm = (String) lvvv.getItemAtPosition(position);
//        Toast.makeText(this,hm,Toast.LENGTH_LONG).show();

        if (hm == "Wedding") {

            Intent a = new Intent(this, Wedding.class);
            a.putExtra("key", hm); //change key name
            startActivity(a);
        }

        if(hm== "Birthday" )
        {
            Intent a = new Intent(this, Birthday.class);
            a.putExtra("key", hm); //change key name
            startActivity(a);
        }

    }
}
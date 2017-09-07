package com.example.deepi.fiesta;

import android.content.Intent;
import android.database.Cursor;
import android.renderscript.Int2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Admin extends AppCompatActivity implements AdapterView.OnItemClickListener{

    AppDBManager adm = null;
    //ArrayList<Booking_Class> userbookinglist = null;
    ArrayList<String> userbookinglist2 = null;
    ListView listseebookings;
    Booking_Class bkc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        adm = new AppDBManager(this);
        adm.openDb();
        listseebookings = (ListView) findViewById(R.id.listseebookings);

        //userbookinglist = new ArrayList<Booking_Class>();
        userbookinglist2 = new ArrayList<String>();
        adm.openDb();
        populateList();
        //ArrayAdapter<Booking_Class> ad = new ArrayAdapter<Booking_Class>(this, android.R.layout.simple_list_item_1, userbookinglist);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, userbookinglist2);
        listseebookings.setAdapter(ad);
        listseebookings.setOnItemClickListener(this);

    }

    public void populateList() {
        Cursor c = adm.fetchuserbooking();

        if (c != null && c.moveToFirst()) {
            do {
                String userid=c.getString(c.getColumnIndex(AppConstants.COLUMN_USERBOOKID));
               // String name=c.getString(c.getColumnIndex(AppConstants.COLUMN_BOOKUSERNAME));
                //bkc=new Booking_Class();

                //bkc.setBookusername(name);
                userbookinglist2.add(userid);

            } while (c.moveToNext());


        }
        c.close();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        /*Booking_Class bkkc=userbookinglist.get(position);
        */
        String item = parent.getItemAtPosition(position).toString();

        Intent i=new Intent(this,DisplayBooking.class);
        i.putExtra("keypass",item);
        startActivity(i);
    }
}
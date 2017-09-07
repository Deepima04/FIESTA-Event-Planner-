package com.example.deepi.fiesta;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class Book extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener,DialogInterface.OnClickListener {

    Calendar datetime=Calendar.getInstance();
    AppDBManager adm=null;
    DateFormat formatdatetime= DateFormat.getDateTimeInstance();
    TextView bookvenue,hallcharges,textcatering,textbudget,fillevent,eventchargestext,textcateringcharges,hahahaha,textuserbookid;
    EditText edtime,eddate,enterpeople;
    CheckBox cbcatering;
    String n,eventpickeddddd,weddingcharge6;
    String charge;
    int total;
    int service=0;
    int pp = 0;
    int wedcharge;
    AlertDialog ad=null;
    int bookkid=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        adm=new AppDBManager(this);

        Intent i=getIntent();
        n=i.getExtras().getString("bookme");
        eventpickeddddd=i.getExtras().getString("pickedeventtttt");
        weddingcharge6=i.getExtras().getString("chargewedding5");


        edtime=(EditText)findViewById(R.id.edtime);
        eddate=(EditText)findViewById(R.id.eddate);
        bookvenue=(TextView)findViewById(R.id.bookvenue);
        hallcharges=(TextView)findViewById(R.id.hallcharges);
        enterpeople=(EditText)findViewById(R.id.enterpeoplenumber);
        fillevent=(TextView)findViewById(R.id.fillevent);
        fillevent.setText(eventpickeddddd);
        eventchargestext=(TextView)findViewById(R.id.eventchargestext);
        eventchargestext.setText(weddingcharge6);
        wedcharge=Integer.parseInt(weddingcharge6);
        textcatering=(TextView)findViewById(R.id.textcatering);
        textcateringcharges=(TextView)findViewById(R.id.textcateringcharges);
        textbudget=(TextView)findViewById(R.id.textbudget);

        hahahaha=(TextView)findViewById(R.id.hahahaha);
        textuserbookid=(TextView)findViewById(R.id.textuserbookid);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("info", MODE_PRIVATE);
        String first=pref.getString("user_name_fetch", null);
        hahahaha.setText(first);
        populatebookingid();
        populatebookdescription();
        cbcatering = (CheckBox)findViewById(R.id.cbcatering);
        cbcatering.setOnClickListener(this);

    }


    public void populatebookingid()
    {
        adm.openDb();
        Cursor c2=adm.fetchBookId();
        String pp="BOOKID";

            if (c2 != null && c2.moveToFirst()) {
                do {

                    String kaka=c2.getString(c2.getColumnIndex(AppConstants.COLUMN_UPDATEID));

                    String paaas=pp+kaka;
                    textuserbookid.setText(paaas);


                    //bkc=new Booking_Class();

                    //bkc.setBookusername(name);
                    //userbookinglist2.add(userid);

                } while (c2.moveToNext());


            }
            c2.close();

    }




    public void populatebookdescription()
    {

        adm.openDb();

        Cursor c=adm.fetchdescription(n);
        if (c != null && c.moveToFirst()) {
            do {

                int id=c.getInt(c.getColumnIndex(AppConstants.COLUMN_MID));
                String name=c.getString(c.getColumnIndex(AppConstants.COLUMN_MNAME));
                charge=c.getString(c.getColumnIndex(AppConstants.COLUMN_CHARGES));
                String cater=c.getString(c.getColumnIndex(AppConstants.COLUMN_CATERING));

                bookvenue.setText(name);
                hallcharges.setText(charge);
                total=Integer.parseInt(charge);
                total=total+wedcharge;
                textcatering.setText(cater);
                textbudget.setText(String.valueOf(total));
            }while (c.moveToNext());
        }
        c.close();

    }


    public void pickdate(View v)
    {
        new DatePickerDialog(this, d, datetime.get(Calendar.YEAR),datetime.get(Calendar.MONTH),datetime.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void picktime(View v)
    {
        new TimePickerDialog(this, t, datetime.get(Calendar.HOUR_OF_DAY), datetime.get(Calendar.MINUTE), true).show();
    }

    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            /*datetime.set(Calendar.YEAR, year);
            datetime.set(Calendar.MONTH, monthOfYear);
            datetime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            */
            String date_selected = String.valueOf(monthOfYear+1)+" /"+String.valueOf(dayOfMonth)+" /"+String.valueOf(year);
            eddate.setText(date_selected);
        }
    };

    TimePickerDialog.OnTimeSetListener t=new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            /*datetime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            datetime.set(Calendar.MINUTE, minute);*/
            String time_selected = String.valueOf(hourOfDay)+" :"+String.valueOf(minute);
            edtime.setText(time_selected);
        }
    };

    @Override
    public void onClick(View view) {

        String caterrr=textcatering.getText().toString();
        int caterrrcharge=Integer.parseInt(caterrr);

        switch (view.getId()) {
            case R.id.cbcatering:
                String people= ""+ enterpeople.getText();
                if(!people.isEmpty()) {
                    pp = Integer.parseInt(people);
                    service=caterrrcharge*pp;
                }
                if (cbcatering.isChecked())
                {


                total=total+(service);

                }
                else {
                total = total - (service);
                    service=0;
                }
                    //Toast.makeText(getApplicationContext(), "caterr", Toast.LENGTH_LONG).show();
                break;

        }
        textcateringcharges.setText(String.valueOf(service));
        textbudget.setText(String.valueOf(total));
    }


    public void booking(View v)
    {
        /*SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        String first=pref.getString("user_name_fetch", null);
        String second=pref.getString("pass_name_fetch", null);
        hahahaha.setText(first);
        haha.setText(second);
*/
    adm.openDb();

        String bookidd=textuserbookid.getText().toString();
        String bookven=bookvenue.getText().toString();
        String bookuser=hahahaha.getText().toString();
        String hall=hallcharges.getText().toString();
        String eve=fillevent.getText().toString();
        String evecharge=eventchargestext.getText().toString();
        String peeps=enterpeople.getText().toString();
        String catcharge=textcateringcharges.getText().toString();
        String bkdate=eddate.getText().toString();
        String bktime=edtime.getText().toString();
        String budd=textbudget.getText().toString();

        Booking_Class bc=new Booking_Class();

        bc.setUserbookid(bookidd);
        bc.setBookvenuename(bookven);
        bc.setBookusername(bookuser);
        bc.setBookvenuecharges(hall);
        bc.setBookeventname(eve);
        bc.setEventcharges(evecharge);
        bc.setBookpeople(peeps);
        bc.setBookcateringcharges(catcharge);
        bc.setBookdate(bkdate);
        bc.setBooktime(bktime);
        bc.setBookbudget(budd);


        //add if condition of booking clash


        long l=adm.addBookingData(bc,bkdate,bookven);


        if (l>0)
        {
            showInfo(budd,l);
            Toast.makeText(this,""+l+"inserted successfully",Toast.LENGTH_LONG).show();

        }

        else
        {
            showInfo2();
            //Toast.makeText(this,"sorry",Toast.LENGTH_LONG).show();
        }

        adm.closeDb();

    }

    public void showInfo(String bud,Long ll)
    {
        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setTitle("info");
        adb.setMessage("Your booking has been confirmed and Booking id is BOOKID"+ll+ "Please pay "+bud+"Rs.");
        adb.setPositiveButton("ok",this);
        ad=adb.create();
        ad.show();

    }
    public void showInfo2()
    {
        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setTitle("SORRY");
        adb.setMessage("Date you have selected is already booked. Booking cannot be done.");
        adb.setPositiveButton("ok",this);
        ad=adb.create();
        ad.show();

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which)
        {
            case DialogInterface.BUTTON_POSITIVE:
                //Toast.makeText(this,"Booking Confirmed",Toast.LENGTH_LONG).show();
                break;
        }

    }
}

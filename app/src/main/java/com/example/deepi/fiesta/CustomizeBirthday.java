package com.example.deepi.fiesta;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.TextView;

public class CustomizeBirthday extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener{

    AppDBManager adm=null;
    TextView textfloralstage,textballoonstage,textpearlywhite,textsatin,textredngold,textwhitenpink,textoutdoorfloral,textmusicfacility,textbarfacility,textcake,textroom_offered,texttotal;
    CheckBox cbfloral_stage,cbballoon_stage,cbpearly_white,cbsatin,cbredngold,cbwhitenpink,cboutdoorfloral,cbmusic_facility,cbbar_facility,cbcake;
    String nm;
    int totaltotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_birthday);

        Intent i=getIntent();
        nm=i.getExtras().getString("birthdaykey");


        textfloralstage =(TextView)findViewById(R.id.textfloralstage1);
        textballoonstage=(TextView)findViewById(R.id.textballoonstage1);
        textpearlywhite=(TextView)findViewById(R.id.textpearlywhite1);
        textsatin=(TextView)findViewById(R.id.textsatin1);
        textredngold=(TextView)findViewById(R.id.textredngold1);
        textwhitenpink=(TextView)findViewById(R.id.textwhitenpink1);
        textoutdoorfloral=(TextView)findViewById(R.id.textoutdoorfloral1);
        textmusicfacility=(TextView)findViewById(R.id.textmusicfacility1);
        textbarfacility=(TextView)findViewById(R.id.textbarfacility1);
        textcake=(TextView)findViewById(R.id.textcake1);
        textroom_offered=(TextView)findViewById(R.id.textroom_offered1);
        texttotal=(TextView)findViewById(R.id.texttotalcharges1);

        populateBirthdayDescription();

        cbfloral_stage = (CheckBox)findViewById(R.id.cbfloral_stage1);
        cbfloral_stage.setOnClickListener(this);
        cbballoon_stage= (CheckBox)findViewById(R.id.cbballoon_stage1);
        cbballoon_stage.setOnClickListener(this);
        cbpearly_white= (CheckBox)findViewById(R.id.cbpearly_white1);
        cbpearly_white.setOnClickListener(this);
        cbsatin= (CheckBox)findViewById(R.id.cbsatin1);
        cbsatin.setOnClickListener(this);
        cbredngold= (CheckBox)findViewById(R.id.cbredngold1);
        cbredngold.setOnClickListener(this);
        cbwhitenpink= (CheckBox)findViewById(R.id.cbwhitenpink1);
        cbwhitenpink.setOnClickListener(this);
        cboutdoorfloral= (CheckBox)findViewById(R.id.cboutdoorfloral1);
        cboutdoorfloral.setOnClickListener(this);
        cbmusic_facility= (CheckBox)findViewById(R.id.cbmusic_facility1);
        cbmusic_facility.setOnClickListener(this);
        cbbar_facility= (CheckBox)findViewById(R.id.cbbar_facility1);
        cbbar_facility.setOnClickListener(this);
        cbcake= (CheckBox)findViewById(R.id.cbcake1);
        cbcake.setOnClickListener(this);

    }

    public void populateBirthdayDescription() {
        adm = new AppDBManager(this);
        adm.openDb();

        Cursor c = adm.fetchweddingdescription(nm);
        if (c != null && c.moveToFirst()) {
            do {

                String floral=c.getString(c.getColumnIndex(AppConstants.COLUMN_FLORALSTAGE));
                String balloonstage=c.getString(c.getColumnIndex(AppConstants.COLUMN_BALLOONSTAGE));
                String pearlywhite=c.getString(c.getColumnIndex(AppConstants.COLUMN_PEARLYWHITE));
                String satin=c.getString(c.getColumnIndex(AppConstants.COLUMN_SATIN));
                String redngold=c.getString(c.getColumnIndex(AppConstants.COLUMN_REDNGOLD));
                String whitenpink=c.getString(c.getColumnIndex(AppConstants.COLUMN_WHITENPINK));
                String outdoorfloral=c.getString(c.getColumnIndex(AppConstants.COLUMN_OUTDOORFLORAL));
                String musicc=c.getString(c.getColumnIndex(AppConstants.COLUMN_MUSICFACILITY));
                String barbar=c.getString(c.getColumnIndex(AppConstants.COLUMN_BARFACILITY));
                String weddingcake=c.getString(c.getColumnIndex(AppConstants.COLUMN_WEDDINGCAKE));
                String room=c.getString(c.getColumnIndex(AppConstants.COLUMN_ROOM));

                textfloralstage.setText(floral);

                textballoonstage.setText(balloonstage);

                textpearlywhite.setText(pearlywhite);

                textsatin.setText(satin);

                textredngold.setText(redngold);

                textwhitenpink.setText(whitenpink);

                textoutdoorfloral.setText(outdoorfloral);

                textmusicfacility.setText(musicc);

                textbarfacility.setText(barbar);

                textcake.setText(weddingcake);

                textroom_offered.setText(room);


            } while (c.moveToNext());
        }
        c.close();


    }


    @Override
    public void onClick(View v) {
        String ff=textfloralstage.getText().toString();

        String bb=textballoonstage.getText().toString();

        String pp=textpearlywhite.getText().toString();

        String ss=textsatin.getText().toString();

        String rr=textredngold.getText().toString();

        String wp=textwhitenpink.getText().toString();

        String fo=textoutdoorfloral.getText().toString();

        String mf=textmusicfacility.getText().toString();

        String bf=textbarfacility.getText().toString();

        String ck=textcake.getText().toString();

        int flo=Integer.parseInt(ff);
        int balloon=Integer.parseInt(bb);
        int pearl=Integer.parseInt(pp);
        int satt=Integer.parseInt(ss);
        int redd=Integer.parseInt(rr);
        int whiten=Integer.parseInt(wp);
        int outdoorflo=Integer.parseInt(fo);
        int musicfac=Integer.parseInt(mf);
        int barfaci=Integer.parseInt(bf);
        int cakke=Integer.parseInt(ck);

        switch (v.getId()) {
            case R.id.cbfloral_stage1:
                if (cbfloral_stage.isChecked()){


                    //ischecked
                    totaltotal=totaltotal+flo;}
                else {
                    totaltotal = totaltotal - flo;
                }


                break;


            case R.id.cbballoon_stage1:
                if (cbballoon_stage.isChecked()){


                    //ischecked
                    totaltotal=totaltotal+balloon;}
                else {
                    totaltotal = totaltotal - balloon;
                }


                break;

            case R.id.cbpearly_white1:
                if (cbpearly_white.isChecked()){


                    //ischecked
                    totaltotal=totaltotal+pearl;}
                else {
                    totaltotal = totaltotal - pearl;
                }


                break;

            case R.id.cbsatin1:
                if (cbsatin.isChecked()){


                    //ischecked
                    totaltotal=totaltotal+satt;}
                else {
                    totaltotal = totaltotal - satt;
                }


                break;


            case R.id.cbredngold1:
                if (cbredngold.isChecked()){


                    //ischecked
                    totaltotal=totaltotal+redd;}
                else {
                    totaltotal = totaltotal - redd;
                }


                break;


            case R.id.cbwhitenpink1:
                if (cbwhitenpink.isChecked()){


                    //ischecked
                    totaltotal=totaltotal+whiten;}
                else {
                    totaltotal = totaltotal - whiten;
                }


                break;



            case R.id.cboutdoorfloral1:
                if (cboutdoorfloral.isChecked()){


                    //ischecked
                    totaltotal=totaltotal+outdoorflo;}
                else {
                    totaltotal = totaltotal - outdoorflo;
                }


                break;


            case R.id.cbmusic_facility1:
                if (cbmusic_facility.isChecked()){


                    //ischecked
                    totaltotal=totaltotal+musicfac;}
                else {
                    totaltotal = totaltotal - musicfac;
                }


                break;


            case R.id.cbbar_facility1:
                if (cbbar_facility.isChecked()){


                    //ischecked
                    totaltotal=totaltotal+barfaci;}
                else {
                    totaltotal = totaltotal - barfaci;
                }


                break;


            case R.id.cbcake1:
                if (cbcake.isChecked()){


                    //ischecked
                    totaltotal=totaltotal+cakke;}
                else {
                    totaltotal = totaltotal - cakke;
                }


                break;

        }

        texttotal.setText(String.valueOf(totaltotal));

    }

    public void pickyourvenueb(View v)
    {

        String weddingcharge1=texttotal.getText().toString();
        String pick="Birthday";
        Intent i=new Intent(this,PickYourVenue.class);
        i.putExtra("pickedevent",pick);
        i.putExtra("chargewedding1",weddingcharge1);
        startActivity(i);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

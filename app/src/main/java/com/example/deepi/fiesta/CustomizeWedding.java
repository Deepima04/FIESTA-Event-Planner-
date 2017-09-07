package com.example.deepi.fiesta;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.TextView;

public class CustomizeWedding extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener{

    AppDBManager adm=null;
    TextView textfloralstage,textopenwedding,textethnicstage,textballoonstage,textpearlywhite,textsatin,textredngold,textwhitenpink,textmandap,textoutdoorfloral,textmusicfacility,textbarfacility,textcake,textroom_offered,texttotal;
    CheckBox cbfloral_stage,cbopen_wedding,cbethnic_stage,cbballoon_stage,cbpearly_white,cbsatin,cbredngold,cbwhitenpink,cbmandap,cboutdoorfloral,cbmusic_facility,cbbar_facility,cbcake;
    String nm;
    int totaltotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_wedding);

        Intent i=getIntent();
        nm=i.getExtras().getString("weddingkey");

                textfloralstage =(TextView)findViewById(R.id.textfloralstage);
                textopenwedding =(TextView)findViewById(R.id.textopenwedding);
                textethnicstage=(TextView)findViewById(R.id.textethnicstage);
                textballoonstage=(TextView)findViewById(R.id.textballoonstage);
                textpearlywhite=(TextView)findViewById(R.id.textpearlywhite);
                textsatin=(TextView)findViewById(R.id.textsatin);
                textredngold=(TextView)findViewById(R.id.textredngold);
                textwhitenpink=(TextView)findViewById(R.id.textwhitenpink);
                textmandap=(TextView)findViewById(R.id.textmandap);
                textoutdoorfloral=(TextView)findViewById(R.id.textoutdoorfloral);
                textmusicfacility=(TextView)findViewById(R.id.textmusicfacility);
                textbarfacility=(TextView)findViewById(R.id.textbarfacility);
                textcake=(TextView)findViewById(R.id.textcake);
                textroom_offered=(TextView)findViewById(R.id.textroom_offered);
                texttotal=(TextView)findViewById(R.id.texttotalcharges);


        populateWeddingDescription();

                cbfloral_stage = (CheckBox)findViewById(R.id.cbfloral_stage);
                cbfloral_stage.setOnClickListener(this);
                cbopen_wedding = (CheckBox)findViewById(R.id.cbopen_wedding);
                cbopen_wedding.setOnClickListener(this);
                cbethnic_stage= (CheckBox)findViewById(R.id.cbethnic_stage);
                cbethnic_stage.setOnClickListener(this);
                cbballoon_stage= (CheckBox)findViewById(R.id.cbballoon_stage);
                cbballoon_stage.setOnClickListener(this);
                cbpearly_white= (CheckBox)findViewById(R.id.cbpearly_white);
                cbpearly_white.setOnClickListener(this);
                cbsatin= (CheckBox)findViewById(R.id.cbsatin);
                cbsatin.setOnClickListener(this);
                cbredngold= (CheckBox)findViewById(R.id.cbredngold);
                cbredngold.setOnClickListener(this);
                cbwhitenpink= (CheckBox)findViewById(R.id.cbwhitenpink);
                cbwhitenpink.setOnClickListener(this);
                cbmandap= (CheckBox)findViewById(R.id.cbmandap);
                cbmandap.setOnClickListener(this);
                cboutdoorfloral= (CheckBox)findViewById(R.id.cboutdoorfloral);
                cboutdoorfloral.setOnClickListener(this);
                cbmusic_facility= (CheckBox)findViewById(R.id.cbmusic_facility);
                cbmusic_facility.setOnClickListener(this);
                cbbar_facility= (CheckBox)findViewById(R.id.cbbar_facility);
                cbbar_facility.setOnClickListener(this);
                cbcake= (CheckBox)findViewById(R.id.cbcake);
                cbcake.setOnClickListener(this);
    }


    public void populateWeddingDescription() {
        adm = new AppDBManager(this);
        adm.openDb();

        Cursor c = adm.fetchweddingdescription(nm);
        if (c != null && c.moveToFirst()) {
            do {

                String floral=c.getString(c.getColumnIndex(AppConstants.COLUMN_FLORALSTAGE));
                String openwedding=c.getString(c.getColumnIndex(AppConstants.COLUMN_OPENWEDDING));
                String ethnic=c.getString(c.getColumnIndex(AppConstants.COLUMN_ETHNICSTAGE));
                String balloonstage=c.getString(c.getColumnIndex(AppConstants.COLUMN_BALLOONSTAGE));
                String pearlywhite=c.getString(c.getColumnIndex(AppConstants.COLUMN_PEARLYWHITE));
                String satin=c.getString(c.getColumnIndex(AppConstants.COLUMN_SATIN));
                String redngold=c.getString(c.getColumnIndex(AppConstants.COLUMN_REDNGOLD));
                String whitenpink=c.getString(c.getColumnIndex(AppConstants.COLUMN_WHITENPINK));
                String mandap=c.getString(c.getColumnIndex(AppConstants.COLUMN_MANDAP));
                String outdoorfloral=c.getString(c.getColumnIndex(AppConstants.COLUMN_OUTDOORFLORAL));
                String musicc=c.getString(c.getColumnIndex(AppConstants.COLUMN_MUSICFACILITY));
                String barbar=c.getString(c.getColumnIndex(AppConstants.COLUMN_BARFACILITY));
                String weddingcake=c.getString(c.getColumnIndex(AppConstants.COLUMN_WEDDINGCAKE));
                String room=c.getString(c.getColumnIndex(AppConstants.COLUMN_ROOM));

                textfloralstage.setText(floral);

                textopenwedding.setText(openwedding);

                textethnicstage.setText(ethnic);

                textballoonstage.setText(balloonstage);

                textpearlywhite.setText(pearlywhite);

                textsatin.setText(satin);

                textredngold.setText(redngold);

                textwhitenpink.setText(whitenpink);

                textmandap.setText(mandap);

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

        String oo=textopenwedding.getText().toString();

        String ee=textethnicstage.getText().toString();

        String bb=textballoonstage.getText().toString();

        String pp=textpearlywhite.getText().toString();

        String ss=textsatin.getText().toString();

        String rr=textredngold.getText().toString();

        String wp=textwhitenpink.getText().toString();

        String mm=textmandap.getText().toString();

        String fo=textoutdoorfloral.getText().toString();

        String mf=textmusicfacility.getText().toString();

        String bf=textbarfacility.getText().toString();

        String ck=textcake.getText().toString();



        int flo=Integer.parseInt(ff);
        int openwed=Integer.parseInt(oo);
        int eth=Integer.parseInt(ee);
        int balloon=Integer.parseInt(bb);
        int pearl=Integer.parseInt(pp);
        int satt=Integer.parseInt(ss);
        int redd=Integer.parseInt(rr);
        int whiten=Integer.parseInt(wp);
        int mandp=Integer.parseInt(mm);
        int outdoorflo=Integer.parseInt(fo);
        int musicfac=Integer.parseInt(mf);
        int barfaci=Integer.parseInt(bf);
        int cakke=Integer.parseInt(ck);


        switch (v.getId()) {
            case R.id.cbfloral_stage:
                if (cbfloral_stage.isChecked()){


                    //ischecked
                    totaltotal=totaltotal+flo;}
                else {
                    totaltotal = totaltotal - flo;
                }


                break;

            case R.id.cbopen_wedding:
                if (cbopen_wedding.isChecked()){


                    //ischecked
                    totaltotal=totaltotal+openwed;}
                else {
                    totaltotal = totaltotal - openwed;
                }


                break;

            case R.id.cbethnic_stage:
                if (cbethnic_stage.isChecked()){


                    //ischecked
                    totaltotal=totaltotal+eth;}
                else {
                    totaltotal = totaltotal - eth;
                }


                break;

            case R.id.cbballoon_stage:
                if (cbballoon_stage.isChecked()){


                    //ischecked
                    totaltotal=totaltotal+balloon;}
                else {
                    totaltotal = totaltotal - balloon;
                }


                break;

            case R.id.cbpearly_white:
                if (cbpearly_white.isChecked()){


                    //ischecked
                    totaltotal=totaltotal+pearl;}
                else {
                    totaltotal = totaltotal - pearl;
                }


                break;

            case R.id.cbsatin:
                if (cbsatin.isChecked()){


                    //ischecked
                    totaltotal=totaltotal+satt;}
                else {
                    totaltotal = totaltotal - satt;
                }


                break;


            case R.id.cbredngold:
                if (cbredngold.isChecked()){


                    //ischecked
                    totaltotal=totaltotal+redd;}
                else {
                    totaltotal = totaltotal - redd;
                }


                break;


            case R.id.cbwhitenpink:
                if (cbwhitenpink.isChecked()){


                    //ischecked
                    totaltotal=totaltotal+whiten;}
                else {
                    totaltotal = totaltotal - whiten;
                }


                break;


            case R.id.cbmandap:
                if (cbmandap.isChecked()){


                    //ischecked
                    totaltotal=totaltotal+mandp;}
                else {
                    totaltotal = totaltotal - mandp;
                }


                break;


            case R.id.cboutdoorfloral:
                if (cboutdoorfloral.isChecked()){


                    //ischecked
                    totaltotal=totaltotal+outdoorflo;}
                else {
                    totaltotal = totaltotal - outdoorflo;
                }


                break;


            case R.id.cbmusic_facility:
                if (cbmusic_facility.isChecked()){


                    //ischecked
                    totaltotal=totaltotal+musicfac;}
                else {
                    totaltotal = totaltotal - musicfac;
                }


                break;


            case R.id.cbbar_facility:
                if (cbbar_facility.isChecked()){


                    //ischecked
                    totaltotal=totaltotal+barfaci;}
                else {
                    totaltotal = totaltotal - barfaci;
                }


                break;


            case R.id.cbcake:
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

    public void pickyourvenue(View v)
    {

        String weddingcharge1=texttotal.getText().toString();
        String pick="Wedding";
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
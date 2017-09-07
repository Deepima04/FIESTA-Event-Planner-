package com.example.deepi.fiesta;

import android.*;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ShowDescription extends AppCompatActivity implements TextToSpeech.OnInitListener{

    AppDBManager adm=null;
    TextView txtview,txtdescription,txtcharges,txtaddress,txtphno,txtcapacity;
    ImageView imgview;
    String monumentname,eventpickedddd,weddingcharge5;
    Venue hm;
    TextToSpeech tts=null;
    String lat,longi,name,phono;
    //private Map<String, Drawable> map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_description);




        tts=new TextToSpeech(this,this);
        Intent i=getIntent();
        monumentname=i.getExtras().getString("venue");
        eventpickedddd=i.getExtras().getString("pickedeventttt");
        weddingcharge5=i.getExtras().getString("chargewedding4");

        adm=new AppDBManager(this);

        txtview=(TextView)findViewById(R.id.txtview);
        txtdescription=(TextView)findViewById(R.id.txtdescription);
        txtcharges=(TextView)findViewById(R.id.txtcharges);
        txtaddress=(TextView)findViewById(R.id.textaddress);
        txtphno=(TextView)findViewById(R.id.textphno);
        txtcapacity=(TextView)findViewById(R.id.txtcapacity);

        imgview=(ImageView)findViewById(R.id.imgview);
        populatedescription();


    }

    public void populatedescription()
    {
        adm=new AppDBManager(this);
        adm.openDb();

        Cursor c=adm.fetchdescription(monumentname);
        if (c != null && c.moveToFirst()) {
            do {

                int id=c.getInt(c.getColumnIndex(AppConstants.COLUMN_MID));
                name=c.getString(c.getColumnIndex(AppConstants.COLUMN_MNAME));
                String address=c.getString(c.getColumnIndex(AppConstants.COLUMN_ADDRESS));
                String charge=c.getString(c.getColumnIndex(AppConstants.COLUMN_CHARGES));
                String cap=c.getString(c.getColumnIndex(AppConstants.COLUMN_CAPACITY));
                phono=c.getString(c.getColumnIndex(AppConstants.COLUMN_PHNO));
                String descrip=c.getString(c.getColumnIndex(AppConstants.COLUMN_DESCRIPTION));
                //String deco=c.getString(c.getColumnIndex(AppConstants.COLUMN_DECORATION));
                String cater=c.getString(c.getColumnIndex(AppConstants.COLUMN_CATERING));
                //String music=c.getString(c.getColumnIndex(AppConstants.COLUMN_MUSIC));
                //String bar=c.getString(c.getColumnIndex(AppConstants.COLUMN_BAR));
                lat=c.getString(c.getColumnIndex(AppConstants.COLUMN_LAT));
                longi=c.getString(c.getColumnIndex(AppConstants.COLUMN_LONG));
                String plname=c.getString(c.getColumnIndex(AppConstants.COLUMN_PLACENAME));
//                byte[] arr = c.getBlob(c.getColumnIndex(AppConstants.COLUMN_IMAGE));

                txtview.setText(name);
                txtcharges.setText(charge);
                txtcapacity.setText(cap);
                txtaddress.setText(address);
                txtphno.setText(phono);

                txtdescription.setText(descrip);

                if(name.equals("Barbeque")) {
                    Drawable drawable1 = ContextCompat.getDrawable(this, R.drawable.bbq);
                    imgview.setImageDrawable(drawable1);
                }
                if(name.equals("Chemistry")) {
                    Drawable drawable2 = ContextCompat.getDrawable(this, R.drawable.chemistry);
                    imgview.setImageDrawable(drawable2);
                }
                if(name.equals("Vintage")) {
                    Drawable drawable3 = ContextCompat.getDrawable(this, R.drawable.bbq);
                    imgview.setImageDrawable(drawable3);
                }
                if(name.equals("Mocha")) {
                    Drawable drawable4 = ContextCompat.getDrawable(this, R.drawable.mocha);
                    imgview.setImageDrawable(drawable4);
                }
                if(name.equals("Dayal")) {
                    Drawable drawable5 = ContextCompat.getDrawable(this, R.drawable.dayal);
                    imgview.setImageDrawable(drawable5);
                }

                if(name.equals("RoyalInn")) {
                    Drawable drawable6 = ContextCompat.getDrawable(this, R.drawable.royalinn);
                    imgview.setImageDrawable(drawable6);
                }
                if(name.equals("RoyalCafe")) {
                    Drawable drawable7 = ContextCompat.getDrawable(this, R.drawable.royalcafe);
                    imgview.setImageDrawable(drawable7);
                }

                if(name.equals("Blue")) {
                    Drawable drawable8 = ContextCompat.getDrawable(this, R.drawable.blue);
                    imgview.setImageDrawable(drawable8);
                }

                if(name.equals("SpiceFactory")) {
                    Drawable drawable9 = ContextCompat.getDrawable(this, R.drawable.a);
                    imgview.setImageDrawable(drawable9);
                }

                if(name.equals("Essence")) {
                    Drawable drawable10 = ContextCompat.getDrawable(this, R.drawable.b);
                    imgview.setImageDrawable(drawable10);
                }

                if(name.equals("Myraid")) {
                    Drawable drawable11 = ContextCompat.getDrawable(this, R.drawable.c);
                    imgview.setImageDrawable(drawable11);
                }



                if(name.equals("Taj")) {
                    Drawable drawable12 = ContextCompat.getDrawable(this, R.drawable.taj);
                    imgview.setImageDrawable(drawable12);
                }

                if(name.equals("Piccadily")) {
                    Drawable drawable13 = ContextCompat.getDrawable(this, R.drawable.d);
                    imgview.setImageDrawable(drawable13);
                }


                if(name.equals("5Seasons")) {
                    Drawable drawable14 = ContextCompat.getDrawable(this, R.drawable.e);
                    imgview.setImageDrawable(drawable14);
                }


                if(name.equals("SpiceCaves")) {
                    Drawable drawable15 = ContextCompat.getDrawable(this, R.drawable.spicecaves);
                    imgview.setImageDrawable(drawable15);
                }


                if(name.equals("Skyhilton")) {
                    Drawable drawable16 = ContextCompat.getDrawable(this, R.drawable.skyhilton);
                    imgview.setImageDrawable(drawable16);
                }


                if(name.equals("Ginger")) {
                    Drawable drawable17 = ContextCompat.getDrawable(this, R.drawable.f);
                    imgview.setImageDrawable(drawable17);
                }


                if(name.equals("Gulmohar")) {
                    Drawable drawable18 = ContextCompat.getDrawable(this, R.drawable.g);
                    imgview.setImageDrawable(drawable18);
                }


                if(name.equals("Fuzion")) {
                    Drawable drawable19 = ContextCompat.getDrawable(this, R.drawable.h);
                    imgview.setImageDrawable(drawable19);
                }

                if(name.equals("Aryans")) {
                    Drawable drawable20 = ContextCompat.getDrawable(this, R.drawable.i);
                    imgview.setImageDrawable(drawable20);
                }


                if(name.equals("SecretBarn")) {
                    Drawable drawable21 = ContextCompat.getDrawable(this, R.drawable.barn);
                    imgview.setImageDrawable(drawable21);
                }


                if(name.equals("Salt")) {
                    Drawable drawable22 = ContextCompat.getDrawable(this, R.drawable.salt);
                    imgview.setImageDrawable(drawable22);
                }


                if(name.equals("Cassia")) {
                    Drawable drawable23 = ContextCompat.getDrawable(this, R.drawable.cassia);
                    imgview.setImageDrawable(drawable23);
                }


                if(name.equals("SignInn")) {
                    Drawable drawable24 = ContextCompat.getDrawable(this, R.drawable.signin);
                    imgview.setImageDrawable(drawable24);
                }


                if(name.equals("Heritage")) {
                    Drawable drawable25 = ContextCompat.getDrawable(this, R.drawable.a);
                    imgview.setImageDrawable(drawable25);
                }


                if(name.equals("Metro")) {
                    Drawable drawable26 = ContextCompat.getDrawable(this, R.drawable.b);
                    imgview.setImageDrawable(drawable26);
                }


                if(name.equals("Maharaja")) {
                    Drawable drawable27 = ContextCompat.getDrawable(this, R.drawable.c);
                    imgview.setImageDrawable(drawable27);
                }


                if(name.equals("LucknowLocal")) {
                    Drawable drawable28 = ContextCompat.getDrawable(this, R.drawable.d);
                    imgview.setImageDrawable(drawable28);
                }


                if(name.equals("DeepAvadh")) {
                    Drawable drawable29 = ContextCompat.getDrawable(this, R.drawable.e);
                    imgview.setImageDrawable(drawable29);
                }

/*
                ByteArrayInputStream bis=new ByteArrayInputStream(arr);
                Bitmap b= BitmapFactory.decodeStream(bis);
                imgview.setImageBitmap(b);
*/

                /*txtdescription.setText(hm.getDes());
                txtcharges.setText(hm.getCrname());
*/
            }while (c.moveToNext());
        }
        c.close();

    }



    public void address(View v)
    {
        String mapkey=name;
        Intent i=new Intent(this,MapsActivity.class);
        i.putExtra("venue",mapkey);
        startActivity(i);
    }


    public void viewphoto(View v)
    {
        String photokey=name;
        Intent i=new Intent(this,ViewPhotoActivity.class);
//        i.putExtra("photokeypass",photokey);
        startActivity(i);

    }

    public void book(View v)
    {

        String bookname=name;
        Intent i=new Intent(this,Book.class);
        i.putExtra("bookme",bookname);
        i.putExtra("pickedeventtttt",eventpickedddd);
        i.putExtra("chargewedding5",weddingcharge5);
        startActivity(i);
    }

    public void call(View v)
    {
        String number = phono;

        Intent obj = new Intent(Intent.ACTION_CALL);
        obj.setData(Uri.parse("tel: " + number));
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        startActivity(obj);

    }




    @SuppressLint("NewApi")
    public void speech(View v)
    {
        String dd=txtdescription.getText().toString();
        String dn=txtview.getText().toString();
        tts.speak(dn+""+dd,TextToSpeech.QUEUE_FLUSH,null,null);

    }
    @Override
    public void onInit(int i)
    {
        if(i==TextToSpeech.LANG_NOT_SUPPORTED||i==TextToSpeech.LANG_MISSING_DATA)
        {

            Toast.makeText(this,"not supported" +i, Toast.LENGTH_LONG).show();
        }
        else
        {
            tts.setLanguage(Locale.ENGLISH);
        }

    }


    protected void onDestroy()
    {
        super.onDestroy();
        tts.shutdown();
    }



}

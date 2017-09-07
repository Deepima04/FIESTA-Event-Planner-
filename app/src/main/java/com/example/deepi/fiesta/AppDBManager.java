package com.example.deepi.fiesta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Deepi on 2/11/2017.
 */

public class AppDBManager {
    AppHelper ah = null;
    SQLiteDatabase sb = null;
    int bkid=1;
    Context context=null;

    public AppDBManager(Context context) {
        ah = new AppHelper(context, AppConstants.DATABASE_NAME, null, AppConstants.DATABASE_VERSION);
        this.context=context;
    }

    public void openDb() {
        sb = ah.getWritableDatabase();
    }

    public void closeDb() {
        if (sb != null)
            sb.close();
    }





    public long insertEntry(LoginCredentials lc)
    {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("USERNAME", lc.getName());
        newValues.put("PASSWORD",lc.getPassword());
        newValues.put(AppConstants.LOGIN_MAILID,lc.getMailid());
        newValues.put(AppConstants.LOGIN_PHONENUMBER,lc.getPhonenumber());

        // Insert the row into your table
        long l=sb.insert(AppConstants.LOGINTABLE, null, newValues);
        return l;
        //Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }

    public String getSingleEntry(String userName)
    {
        Cursor cursor=sb.query(AppConstants.LOGINTABLE, null, AppConstants.LOGIN_USERNAME + " =?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }

    public Cursor fetchusername(String un) {

        String agr[] = {un};
        //String colss[]={AppConstants.COLUMN_MNAME,AppConstants.COLUMN_DESCRIPTION,AppConstants.COLUMN_IMAGE};

        Cursor des = sb.query(AppConstants.LOGINTABLE, null, AppConstants.LOGIN_USERNAME + " =?", agr, null, null, null);
        //Cursor des=sb.query(AppConstants.TABLE_MNAME,null,null,null,null,null,null);
        return des;

    }
/*

    public Cursor fetchcity()
    {

        Cursor city=sb.query(AppConstants.TABLE_NAME,null,null,null,null,null,null);

        return city;

    }
*/

 /*   public Cursor checkc()

    {
        String col[]={AppConstants.COLUMN_NAME};
        Cursor city=sb.query(AppConstants.TABLE_NAME,col,null,null,null,null,null);

        return city;

    }*/

    public Cursor checkm()

    {
        String col[] = {AppConstants.COLUMN_MNAME};
        Cursor city = sb.query(AppConstants.TABLE_MNAME, col, null, null, null, null, null);

        return city;

    }

    public Cursor fetchdescription(String monumentname)

    {
        String agr[] = {monumentname};
        //String colss[]={AppConstants.COLUMN_MNAME,AppConstants.COLUMN_DESCRIPTION,AppConstants.COLUMN_IMAGE};

        Cursor des = sb.query(AppConstants.TABLE_MNAME, null, AppConstants.COLUMN_MNAME + " =?", agr, null, null, null);
        //Cursor des=sb.query(AppConstants.TABLE_MNAME,null,null,null,null,null,null);
        return des;

    }


    public Cursor fetchweddingdescription(String name)

    {
        String agr[] = {name};
        //String colss[]={AppConstants.COLUMN_MNAME,AppConstants.COLUMN_DESCRIPTION,AppConstants.COLUMN_IMAGE};

        Cursor des = sb.query(AppConstants.TABLE_WEDDING, null, AppConstants.COLUMN_WED_CATEGORY + " =?", agr, null, null, null);
        //Cursor des=sb.query(AppConstants.TABLE_MNAME,null,null,null,null,null,null);
        return des;

    }


/*

    public Cursor fetchmonument(int cityid)

    {
        int agr[]={cityid};
        String args[]={String.valueOf(cityid)};

        Cursor mon=sb.query(AppConstants.TABLE_MNAME,null, AppConstants.COLUMN_CID +" =?",args,null,null,null);

        return mon;

    }
*/

    public static byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }/*
    public void popullateCity(byte[] image1)
    {


        addVenue(image1);

    }*/

    public void checkDb()
    {

        Cursor mon=sb.query(AppConstants.TABLE_MNAME,null,null,null,null,null,null);

        if(mon.getCount()<1)
        {
            addVenue();
            addWeddingDetails();
            addBookid();
        }

    }

    public void addWeddingDetails()
    {
        ContentValues cvv = new ContentValues();

        cvv.put(AppConstants.COLUMN_WED_CATEGORY, "Platinum");
        cvv.put(AppConstants.COLUMN_FLORALSTAGE, "150000");
        cvv.put(AppConstants.COLUMN_OPENWEDDING, "200000");
        cvv.put(AppConstants.COLUMN_ETHNICSTAGE, "125000");
        cvv.put(AppConstants.COLUMN_BALLOONSTAGE, "195000");
        cvv.put(AppConstants.COLUMN_PEARLYWHITE, "95000");
        cvv.put(AppConstants.COLUMN_SATIN, "90000");
        cvv.put(AppConstants.COLUMN_REDNGOLD, "100000");
        cvv.put(AppConstants.COLUMN_WHITENPINK, "98000");
        cvv.put(AppConstants.COLUMN_MANDAP, "15000");
        cvv.put(AppConstants.COLUMN_OUTDOORFLORAL, "35000");
        cvv.put(AppConstants.COLUMN_MUSICFACILITY, "25000");
        cvv.put(AppConstants.COLUMN_BARFACILITY, "35000");
        cvv.put(AppConstants.COLUMN_WEDDINGCAKE, "10000");
        cvv.put(AppConstants.COLUMN_ROOM, "4");
        sb.insert(AppConstants.TABLE_WEDDING,null,cvv);


        cvv.put(AppConstants.COLUMN_WED_CATEGORY, "Gold");
        cvv.put(AppConstants.COLUMN_FLORALSTAGE, "80000");
        cvv.put(AppConstants.COLUMN_OPENWEDDING, "95000");
        cvv.put(AppConstants.COLUMN_ETHNICSTAGE, "75000");
        cvv.put(AppConstants.COLUMN_BALLOONSTAGE, "100000");
        cvv.put(AppConstants.COLUMN_PEARLYWHITE, "75000");
        cvv.put(AppConstants.COLUMN_SATIN, "80000");
        cvv.put(AppConstants.COLUMN_REDNGOLD, "90000");
        cvv.put(AppConstants.COLUMN_WHITENPINK, "70000");
        cvv.put(AppConstants.COLUMN_MANDAP, "10000");
        cvv.put(AppConstants.COLUMN_OUTDOORFLORAL, "25000");
        cvv.put(AppConstants.COLUMN_MUSICFACILITY, "15000");
        cvv.put(AppConstants.COLUMN_BARFACILITY, "25000");
        cvv.put(AppConstants.COLUMN_WEDDINGCAKE, "7000");
        cvv.put(AppConstants.COLUMN_ROOM, "2");
        sb.insert(AppConstants.TABLE_WEDDING,null,cvv);


        cvv.put(AppConstants.COLUMN_WED_CATEGORY, "Silver");
        cvv.put(AppConstants.COLUMN_FLORALSTAGE, "40000");
        cvv.put(AppConstants.COLUMN_OPENWEDDING, "50000");
        cvv.put(AppConstants.COLUMN_ETHNICSTAGE, "35000");
        cvv.put(AppConstants.COLUMN_BALLOONSTAGE, "75000");
        cvv.put(AppConstants.COLUMN_PEARLYWHITE, "65000");
        cvv.put(AppConstants.COLUMN_SATIN, "70000");
        cvv.put(AppConstants.COLUMN_REDNGOLD, "75000");
        cvv.put(AppConstants.COLUMN_WHITENPINK, "72000");
        cvv.put(AppConstants.COLUMN_MANDAP, "5000");
        cvv.put(AppConstants.COLUMN_OUTDOORFLORAL, "15000");
        cvv.put(AppConstants.COLUMN_MUSICFACILITY, "8000");
        cvv.put(AppConstants.COLUMN_BARFACILITY, "20000");
        cvv.put(AppConstants.COLUMN_WEDDINGCAKE, "5000");
        cvv.put(AppConstants.COLUMN_ROOM, "1");
        sb.insert(AppConstants.TABLE_WEDDING,null,cvv);


    }

    public void addVenue() {
        ContentValues cv = new ContentValues();
        /*
        cv.put(AppConstants.COLUMN_MNAME,hm.getMname());
        cv.put(AppConstants.COLUMN_CHARGES,hm.getCrname());
        cv.put(AppConstants.COLUMN_CAPACITY,hm.getDes());
        cv.put(AppConstants.COLUMN_IMAGE,hm.getMimage());
        cv.put(AppConstants.COLUMN_CID,hm.getCid());
*/
        //Drawable drawable = this.getResources().getDrawable(R.drawable.yourDrawableID);
        //        Bitmap bitmap = ((BitmapDrawable)getResources().getDrawable(R.drawable.fiesta)).getBitmap();


        /*Context context = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.mocha);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] photo = baos.toByteArray();
*/
        cv.put(AppConstants.COLUMN_MNAME, "Taj");
        cv.put(AppConstants.COLUMN_ADDRESS, "Vipin Khand, Gomti Nagar, Lucknow, Uttar Pradesh 226010");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, path+photos[0]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Gomtinagar");
        cv.put(AppConstants.COLUMN_CATERING, "1800");
        cv.put(AppConstants.COLUMN_LAT, "26.851556");
        cv.put(AppConstants.COLUMN_LONG, "80.973262");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);

        cv.put(AppConstants.COLUMN_MNAME, "Chemistry");
        cv.put(AppConstants.COLUMN_ADDRESS, "1/09, Shahid Path, Viram Khand 1, Gomti Nagar, Lucknow, Uttar Pradesh 226010");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[2]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Gomtinagar");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.843329");
        cv.put(AppConstants.COLUMN_LONG, "80.997721");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);

        cv.put(AppConstants.COLUMN_MNAME, "Vintage");
        cv.put(AppConstants.COLUMN_ADDRESS, "1/09, Shahid Path, Viram Khand 1, Gomti Nagar, Lucknow, Uttar Pradesh 226010");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[4]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Gomtinagar");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.852802");
        cv.put(AppConstants.COLUMN_LONG, "81.000899");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);

        cv.put(AppConstants.COLUMN_MNAME, "Mocha");
        cv.put(AppConstants.COLUMN_ADDRESS, "1/09, Shahid Path, Viram Khand 1, Gomti Nagar, Lucknow, Uttar Pradesh 226010");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[0]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8853134067");
        cv.put(AppConstants.COLUMN_PLACENAME, "Gomtinagar");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.852802");
        cv.put(AppConstants.COLUMN_LONG, "81.000899");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);

        cv.put(AppConstants.COLUMN_MNAME, "Dayal");
        cv.put(AppConstants.COLUMN_ADDRESS, "1/09, Shahid Path, Viram Khand 1, Gomti Nagar, Lucknow, Uttar Pradesh 226010");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Gomtinagar");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.842559");
        cv.put(AppConstants.COLUMN_LONG, "80.991346");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);


        //hazratganj

        cv.put(AppConstants.COLUMN_MNAME, "RoyalInn");
        cv.put(AppConstants.COLUMN_ADDRESS, "2nd Floor 9/7 Lucknow, Shahnajaf Rd, Hazratganj, Lucknow, Uttar Pradesh 226001");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "05224047903");
        cv.put(AppConstants.COLUMN_PLACENAME, "Hazratganj");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.852794");
        cv.put(AppConstants.COLUMN_LONG, "80.944176");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);

        cv.put(AppConstants.COLUMN_MNAME, "RoyalCafe");
        cv.put(AppConstants.COLUMN_ADDRESS, "51, HAZRATGANJ,OPP SAHU CINEMA, Shahnajaf Rd, Prem Nagar, Hazratganj, Lucknow, Uttar Pradesh 226001");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "05224095555");
        cv.put(AppConstants.COLUMN_PLACENAME, "Hazratganj");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.856332");
        cv.put(AppConstants.COLUMN_LONG, "80.945687");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);

        cv.put(AppConstants.COLUMN_MNAME, "Blue");
        cv.put(AppConstants.COLUMN_ADDRESS, "1-A, Sapru Marg, Civil Lines, Prem Nagar, Hazratganj, Lucknow, Uttar Pradesh 226001");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Hazratganj");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.853617");
        cv.put(AppConstants.COLUMN_LONG, "80.945433");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);

        cv.put(AppConstants.COLUMN_MNAME, "SpiceFactory");
        cv.put(AppConstants.COLUMN_ADDRESS, "City Mall, City Mall, CP2, Vipul Khand 4, Hazratganj, Lucknow, Uttar Pradesh 226010");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Hazratganj");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.846188");
        cv.put(AppConstants.COLUMN_LONG, "80.986503");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);

        cv.put(AppConstants.COLUMN_MNAME, "Essence");
        cv.put(AppConstants.COLUMN_ADDRESS, "90 MG Marg, Off Park Road, Hazratganj, Raj Bhavan Colony, The Mall Avenue, Lucknow, Uttar Pradesh 226001");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Hazratganj");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.844095");
        cv.put(AppConstants.COLUMN_LONG, "80.947205");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);

        cv.put(AppConstants.COLUMN_MNAME, "Myraid");
        cv.put(AppConstants.COLUMN_ADDRESS, "VS Marg, Hazratganj, Lucknow, Uttar Pradesh 226001");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Hazratganj");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.840868");
        cv.put(AppConstants.COLUMN_LONG, "80.939533");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);

        //

        cv.put(AppConstants.COLUMN_MNAME, "Piccadily");
        cv.put(AppConstants.COLUMN_ADDRESS, "Kanpur Road, Sector B, Bara Birwa, Sector B, Bargawan, LDA Colony, Lucknow, Uttar Pradesh 226005");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "Across the street from a shopping mall and 1.9 km from Manak Nagar Railway Station, this modern hotel is 4.2 km from Chaudhary Charan Singh International Airport and 9 km from the 18th-century Bara Imambara shrine.");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Alambagh");
        cv.put(AppConstants.COLUMN_CATERING, "1500");
        cv.put(AppConstants.COLUMN_LAT, "26.798366");
        cv.put(AppConstants.COLUMN_LONG, "80.894558");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);


        cv.put(AppConstants.COLUMN_MNAME, "5Seasons");
        cv.put(AppConstants.COLUMN_ADDRESS, "1/09, Shahid Path, Viram Khand 1, Gomti Nagar, Lucknow, Uttar Pradesh 226010");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Alambagh");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.842559");
        cv.put(AppConstants.COLUMN_LONG, "80.991346");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);


        cv.put(AppConstants.COLUMN_MNAME, "SpiceCaves");
        cv.put(AppConstants.COLUMN_ADDRESS, "1/09, Shahid Path, Alambagh, Lucknow, Uttar Pradesh 226010");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Alambagh");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.842559");
        cv.put(AppConstants.COLUMN_LONG, "80.991346");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);


        cv.put(AppConstants.COLUMN_MNAME, "Skyhilton");
        cv.put(AppConstants.COLUMN_ADDRESS, "1/09, Shahid Path, Alambagh, Lucknow, Uttar Pradesh 226010");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Alambagh");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.842559");
        cv.put(AppConstants.COLUMN_LONG, "80.991346");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);



        cv.put(AppConstants.COLUMN_MNAME, "Ginger");
        cv.put(AppConstants.COLUMN_ADDRESS, "Block D, Rajajipuram, Lucknow, Uttar Pradesh 226017");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Rajajipuram");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.836389");
        cv.put(AppConstants.COLUMN_LONG, "80.879625");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);

        cv.put(AppConstants.COLUMN_MNAME, "Gulmohar");
        cv.put(AppConstants.COLUMN_ADDRESS, "Block D, Rajajipuram, Lucknow, Uttar Pradesh 226017");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Rajajipuram");
        cv.put(AppConstants.COLUMN_CATERING, "500");
        cv.put(AppConstants.COLUMN_LAT, "26.835844");
        cv.put(AppConstants.COLUMN_LONG, "80.881908");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);

        cv.put(AppConstants.COLUMN_MNAME, "Fuzion");
        cv.put(AppConstants.COLUMN_ADDRESS, "E-1772 First Floor Above Bata Showroom E- Black, Rajajipuram, Lucknow, Uttar Pradesh 226017");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Rajajipuram");
        cv.put(AppConstants.COLUMN_CATERING, "800");
        cv.put(AppConstants.COLUMN_LAT, "26.846853");
        cv.put(AppConstants.COLUMN_LONG, "80.876357");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);

        cv.put(AppConstants.COLUMN_MNAME, "Aryans");
        cv.put(AppConstants.COLUMN_ADDRESS, "CP-7/202, -Block,, Block C, Rajajipuram, Lucknow, Uttar Pradesh 226017");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Rajajipuram");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.843452");
        cv.put(AppConstants.COLUMN_LONG, "80.883744");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);

        cv.put(AppConstants.COLUMN_MNAME, "SecretBarn");
        cv.put(AppConstants.COLUMN_ADDRESS, "B 1/57, Sector P, Aliganj, Sector-P, Sector B, Aliganj, Lucknow, Uttar Pradesh 226024");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Aliganj");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.902206");
        cv.put(AppConstants.COLUMN_LONG, "80.944883");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);

        cv.put(AppConstants.COLUMN_MNAME, "Salt");
        cv.put(AppConstants.COLUMN_ADDRESS, "Kapoorthala Road, Kapoorthala,, Aliganj , Chandralok, Lucknow, Uttar Pradesh 226024");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Aliganj");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.884649");
        cv.put(AppConstants.COLUMN_LONG, "80.943566");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);

        cv.put(AppConstants.COLUMN_MNAME, "Cassia");
        cv.put(AppConstants.COLUMN_ADDRESS, "L.G.F Rohtas Ks, Civil Lines, Rana Pratap Marg, Lucknow 226001");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Aliganj");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.853806");
        cv.put(AppConstants.COLUMN_LONG, "80.952554");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);

        cv.put(AppConstants.COLUMN_MNAME, "SignInn");
        cv.put(AppConstants.COLUMN_ADDRESS, "B-35, 226024, Sector H, Sector-A, Sector L, Aliganj, Lucknow, Uttar Pradesh 226024");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Aliganj");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.896757");
        cv.put(AppConstants.COLUMN_LONG, "80.943399");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);

        cv.put(AppConstants.COLUMN_MNAME, "Heritage");
        cv.put(AppConstants.COLUMN_ADDRESS, "14, AP Sen Road, Beside Labour Court, Charbagh, Cash and Pay Colony, Charbagh, Lucknow, Uttar Pradesh 226001");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Charbagh");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.833747");
        cv.put(AppConstants.COLUMN_LONG, "80.929739");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);

        cv.put(AppConstants.COLUMN_MNAME, "Metro");
        cv.put(AppConstants.COLUMN_ADDRESS, "1/09, Shahid Path, Viram Khand 1, Charbagh, Lucknow, Uttar Pradesh 226010");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Charbagh");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.842559");
        cv.put(AppConstants.COLUMN_LONG, "80.991346");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);

        cv.put(AppConstants.COLUMN_MNAME, "Maharaja");
        cv.put(AppConstants.COLUMN_ADDRESS, "1/09, Shahid Path, Viram Khand 1, Charbagh, Lucknow, Uttar Pradesh 226010");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Charbagh");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.842559");
        cv.put(AppConstants.COLUMN_LONG, "80.991346");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);

        cv.put(AppConstants.COLUMN_MNAME, "LucknowLocal");
        cv.put(AppConstants.COLUMN_ADDRESS, "1/09, Shahid Path, Viram Khand 1, Charbagh, Lucknow, Uttar Pradesh 226010");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Charbagh");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.842559");
        cv.put(AppConstants.COLUMN_LONG, "80.991346");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);

        cv.put(AppConstants.COLUMN_MNAME, "DeepAvadh");
        cv.put(AppConstants.COLUMN_ADDRESS, "1/09, Shahid Path, Viram Khand 1, Charbagh, Lucknow, Uttar Pradesh 226010");
        cv.put(AppConstants.COLUMN_CHARGES, "500000");
        cv.put(AppConstants.COLUMN_CAPACITY, "400");
        //cv.put(AppConstants.COLUMN_IMAGE, pic[3]);
        cv.put(AppConstants.COLUMN_DESCRIPTION, "very nice place");
        cv.put(AppConstants.COLUMN_PHNO, "8960770445");
        cv.put(AppConstants.COLUMN_PLACENAME, "Charbagh");
        cv.put(AppConstants.COLUMN_CATERING, "700");
        cv.put(AppConstants.COLUMN_LAT, "26.842559");
        cv.put(AppConstants.COLUMN_LONG, "80.991346");
        sb.insert(AppConstants.TABLE_MNAME,null,cv);




    }

    public Cursor fetch(String name)
    {
        String agr[]={name};
        Cursor c=sb.query(AppConstants.TABLE_MNAME,null,AppConstants.COLUMN_PLACENAME +" =?",agr,null,null,null);

        return c;

    }

    public Cursor fetchuserbooking()
    {
        Cursor c=sb.query(AppConstants.TABLE_BOOK,null,null,null,null,null,null);
        return c;
    }

    public Cursor fetchbookingdescription(String usrname)
    {
        String agr[]={usrname};
        Cursor c=sb.query(AppConstants.TABLE_BOOK,null,AppConstants.COLUMN_USERBOOKID +" =?",agr,null,null,null);
        return c;
    }

    public long addBookingData(Booking_Class bc,String dat,String venn)
    {
        long l=0;

        /*String agr[]={dat};*/

        String sql = "SELECT * FROM book WHERE bookdate = ? AND bookvenuename = ?";
        Cursor c = sb.rawQuery(sql, new String[]{dat,venn});

       /* Cursor c=sb.query(AppConstants.TABLE_BOOK,null,AppConstants.COLUMN_BOOKDATE +" =?",agr,null,null,null);
*/
        if (c == null || !c.moveToFirst()) {
            //Insert new

            ContentValues addbook=new ContentValues();
            addbook.put(AppConstants.COLUMN_USERBOOKID,bc.getUserbookid());
            addbook.put(AppConstants.COLUMN_BOOKVENUENAME,bc.getBookvenuename());
            addbook.put(AppConstants.COLUMN_BOOKUSERNAME,bc.getBookusername());
            addbook.put(AppConstants.COLUMN_BOOKVENUECHARGES,bc.getBookvenuecharges());
            addbook.put(AppConstants.COLUMN_BOOKEVENTNAME,bc.getBookeventname());
            addbook.put(AppConstants.COLUMN_EVENTCHARGES,bc.getEventcharges());
            addbook.put(AppConstants.COLUMN_BOOKPEOPLE,bc.getBookpeople());
            addbook.put(AppConstants.COLUMN_BOOKCATERINGCHARGES,bc.getBookcateringcharges());
            addbook.put(AppConstants.COLUMN_BOOKDATE,bc.getBookdate());
            addbook.put(AppConstants.COLUMN_BOOKTIME,bc.getBooktime());
            addbook.put(AppConstants.COLUMN_BOOKBUDGET,bc.getBookbudget());

            l=sb.insert(AppConstants.TABLE_BOOK,null,addbook);
            int d= (int) (l+1);
            String paass=String.valueOf(d);
            updateData(paass);
            //Toast.makeText(context, bkid , Toast.LENGTH_LONG).show();


        }
        return l;


    }


    public void addBookid()
    {
        ContentValues cvvd = new ContentValues();

        cvvd.put(AppConstants.COLUMN_UPDATENAME,"first");
        cvvd.put(AppConstants.COLUMN_UPDATEID, "1");

        sb.insert(AppConstants.TABLE_BOOKIDD,null,cvvd);
    }


    public Cursor fetchBookId()
    {
        Cursor c=sb.query(AppConstants.TABLE_BOOKIDD,null,null,null,null,null,null);
        return c;

    }

    public void updateData(String pasas)
    {
        String name="first";
        ContentValues cup=new ContentValues();
        cup.put(AppConstants.COLUMN_UPDATEID, pasas);
        String []arg={name};
        sb.update(AppConstants.TABLE_BOOKIDD,cup,AppConstants.COLUMN_UPDATENAME+" =?",arg);



    }

}

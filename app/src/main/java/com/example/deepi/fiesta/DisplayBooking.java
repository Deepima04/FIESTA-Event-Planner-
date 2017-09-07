package com.example.deepi.fiesta;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DisplayBooking extends AppCompatActivity implements View.OnClickListener {


    AppDBManager adm=null;
    TextView showvenuename,textshowbookiid,textshowusername,textshoweventname,textshowvencharge,textshoweventcharge,textshowcatercharge,textshownofpeps,textshowbookingdate,textshowbookingtime,textshowtotalbudget;
    CheckBox checkpayment;
    Button btnpayment;
    String n,firstphone;
    String ussername,bkkbudget;
    String vencharr,evename,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_booking);
        Intent i=getIntent();
        n=i.getExtras().getString("keypass");

        adm=new AppDBManager(this);

        textshowbookiid=(TextView)findViewById(R.id.textshowbookiid);
        showvenuename=(TextView)findViewById(R.id.showvenuename);
        textshowusername=(TextView)findViewById(R.id.textshowusername);
        textshoweventname=(TextView)findViewById(R.id.textshoweventname);
        textshowvencharge=(TextView)findViewById(R.id.textshowvencharge);
        textshoweventcharge=(TextView)findViewById(R.id.textshoweventcharge);
        textshowcatercharge=(TextView)findViewById(R.id.textshowcatercharge);
        textshownofpeps=(TextView)findViewById(R.id.textshownofpeps);
        textshowbookingdate=(TextView)findViewById(R.id.textshowbookingdate);
        textshowbookingtime=(TextView)findViewById(R.id.textshowbookingtime);
        textshowtotalbudget=(TextView)findViewById(R.id.textshowtotalbudget);

        populatedescription();
        btnpayment=(Button)findViewById(R.id.btnpayment);
        btnpayment.setEnabled(false);

        checkpayment=(CheckBox)findViewById(R.id.checkpayment);
        checkpayment.setOnClickListener(this);
    }

    public void populatedescription()
    {
        adm.openDb();


        Cursor c=adm.fetchbookingdescription(n);

        if (c != null && c.moveToFirst()) {
            do {
                String bkid=c.getString(c.getColumnIndex(AppConstants.COLUMN_USERBOOKID));
                name=c.getString(c.getColumnIndex(AppConstants.COLUMN_BOOKVENUENAME));
                ussername=c.getString(c.getColumnIndex(AppConstants.COLUMN_BOOKUSERNAME));
                vencharr=c.getString(c.getColumnIndex(AppConstants.COLUMN_BOOKVENUECHARGES));
                evename=c.getString(c.getColumnIndex(AppConstants.COLUMN_BOOKEVENTNAME));
                String evecharge=c.getString(c.getColumnIndex(AppConstants.COLUMN_EVENTCHARGES));
                String peepps=c.getString(c.getColumnIndex(AppConstants.COLUMN_BOOKPEOPLE));
                String caterchargess=c.getString(c.getColumnIndex(AppConstants.COLUMN_BOOKCATERINGCHARGES));
                String bkkdate=c.getString(c.getColumnIndex(AppConstants.COLUMN_BOOKDATE));
                String bkktime=c.getString(c.getColumnIndex(AppConstants.COLUMN_BOOKTIME));
                bkkbudget=c.getString(c.getColumnIndex(AppConstants.COLUMN_BOOKBUDGET));

                textshowbookiid.setText(bkid);
                showvenuename.setText(name);
                textshowusername.setText(ussername);
                textshoweventname.setText(evename);
                textshowvencharge.setText(vencharr);
                textshoweventcharge.setText(evecharge);
                textshowcatercharge.setText(caterchargess);
                textshownofpeps.setText(peepps);
                textshowbookingdate.setText(bkkdate);
                textshowbookingtime.setText(bkktime);
                textshowtotalbudget.setText(bkkbudget);
            }while (c.moveToNext());
        }
        c.close();

    }


    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.checkpayment:

                if (checkpayment.isChecked()) {

                    btnpayment.setEnabled(true);

                }
                else
                {
                    btnpayment.setEnabled(false);

                }

            break;

        }
    }

    public void paymentconfirm(View v)
    {
        usernamepopulate();

        String msg="hie "+ussername+"! Your "+evename+" booking for"+name+" is done. Payment Recieved of "+bkkbudget+ "Rs.";
        String number=firstphone;
        SmsManager sm=SmsManager.getDefault();
        /*Intent i=new Intent(this,DisplayBooking.class);
        PendingIntent p=PendingIntent.getActivity(this,1,i,0);
*/
        sm.sendTextMessage(number,null,msg,null,null);
        Toast.makeText(this,"msg sent",Toast.LENGTH_LONG).show();

    }

    public void usernamepopulate()
    {

        adm.openDb();


        Cursor c=adm.fetchusername(ussername);

        if (c != null && c.moveToFirst()) {
            do {
                firstphone=c.getString(c.getColumnIndex(AppConstants.LOGIN_PHONENUMBER));


            }while (c.moveToNext());
        }
        c.close();


    }



}

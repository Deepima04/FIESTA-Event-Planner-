package com.example.deepi.fiesta;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity /*implements DialogInterface.OnClickListener*/{

    AlertDialog ad=null;

    AppDBManager adm=null;
    EditText txtname, txtpass, txtconpass, txtmailid, txtphnumber;
    String name;
    String pass;
    String conpass;
    String mail;
    String phhn,otp;

  /*  SharedPreferences sp=null;
    SharedPreferences.Editor se=null;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        adm=new AppDBManager(this);
        adm.openDb();
        txtname = (EditText) findViewById(R.id.txtname);
        txtpass = (EditText) findViewById(R.id.txtpass);
        txtconpass=(EditText)findViewById(R.id.txtconpass);
        txtmailid=(EditText)findViewById(R.id.txtmailid);
        txtphnumber=(EditText)findViewById(R.id.txtphnumber);
/*
        sp=getSharedPreferences("phone",MODE_PRIVATE);
        se=sp.edit();*/

    }

    public void verify_sms(View v)
    {

        name=txtname.getText().toString();
        pass=txtpass.getText().toString();
        conpass=txtconpass.getText().toString();
        mail=txtmailid.getText().toString();
        phhn=txtphnumber.getText().toString();



        // check if any of the fields are vaccant
        if(name.equals("")||pass.equals("")||conpass.equals("")||mail.equals("")||phhn.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
            return;
        }
        // check if both password matches

        if(!pass.equals(conpass))
        {
            Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {

//msg sent
            String msg="Your One Time PassWord is- 77533";
            String number=phhn;
            SmsManager sm=SmsManager.getDefault();
        /*Intent i=new Intent(this,DisplayBooking.class);
        PendingIntent p=PendingIntent.getActivity(this,1,i,0);
*/
            sm.sendTextMessage(number,null,msg,null,null);
            Toast.makeText(this,"msg sent",Toast.LENGTH_LONG).show();

            showLoginDialog();


        }
    }


    protected void showLoginDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Get the layout inflater
        LayoutInflater inflater = this.getLayoutInflater();



        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.signin_authentication, null))
                // Add action buttons
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Dialog f = (Dialog) dialog;
                        // Save the Data in Database
                        EditText edotp=(EditText)f.findViewById(R.id.otp);
                        otp=edotp.getText().toString();
            /* STOP */

                        if(otp.equalsIgnoreCase("77533")) {

                            LoginCredentials lc = new LoginCredentials();
                            lc.setName(name);
                            lc.setPassword(pass);
                            lc.setMailid(mail);
                            lc.setPhonenumber(phhn);
                            long l = adm.insertEntry(lc);

                            if (l > 0) {
                                /*se.putString("phone_fetch", phhn);
                                se.putString("name_fetch", name);
                                se.commit();*/

                                Toast.makeText(Signup.this, "" + l + "inserted successfully", Toast.LENGTH_LONG).show();
                            }

                            Toast.makeText(Signup.this,"matched",Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Signup.this,"not matched",Toast.LENGTH_LONG).show();

                        }
                    }
                })
                .setNegativeButton("cancel",  new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }


/*
    public void verify_mail(View v)
    {

        name=txtname.getText().toString();
        pass=txtpass.getText().toString();
        conpass=txtconpass.getText().toString();
        mail=txtmailid.getText().toString();
        phhn=txtphnumber.getText().toString();



        // check if any of the fields are vaccant
        if(name.equals("")||pass.equals("")||conpass.equals("")||mail.equals("")||phhn.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
            return;
        }
        // check if both password matches

        if(!pass.equals(conpass))
        {
            Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {


            //msg sent
            sendEmail();
            showLoginDialog();



            */
/*//*
/ Save the Data in Database
            LoginCredentials lc=new LoginCredentials();
            lc.setName(name);
            lc.setPassword(pass);
            lc.setMailid(mail);
            lc.setPhonenumber(phhn);
            long l=adm.insertEntry(lc);

            if (l>0)
            {
                Toast.makeText(this,""+l+"inserted successfully",Toast.LENGTH_LONG).show();
            }*//*


        }
    }




    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {"deepima.dwivedi@gmail.com"};
        String[] CC = {"deepima.494@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "One Time Password");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "OTP is 77533");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Signup.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
*/

    @Override
    protected void onDestroy() {

        // TODO Auto-generated method stub
        super.onDestroy();
        adm.closeDb();

    }

}
    /*public void createAccount(View v)
    {

        String name=txtname.getText().toString();
        String pass=txtpass.getText().toString();
        String conpass=txtconpass.getText().toString();
        String mail=txtmailid.getText().toString();
        String phhn=txtphnumber.getText().toString();



        // check if any of the fields are vaccant
        if(name.equals("")||pass.equals("")||conpass.equals("")||mail.equals("")||phhn.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
            return;
        }
        // check if both password matches

        if(!pass.equals(conpass))
        {
            Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {


        showDialogu();



            // Save the Data in Database
    *//*        LoginCredentials lc=new LoginCredentials();
            lc.setName(name);
            lc.setPassword(pass);
            lc.setMailid(mail);
            lc.setPhonenumber(phhn);
            long l=adm.insertEntry(lc);

            if (l>0)
            {
                Toast.makeText(this,""+l+"inserted successfully",Toast.LENGTH_LONG).show();
            }
    *//*
        }
    }
*/

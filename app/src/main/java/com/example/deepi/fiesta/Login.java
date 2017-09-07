package com.example.deepi.fiesta;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements DialogInterface.OnClickListener{

    EditText txtid,txtpass;
    AlertDialog ad=null;
    AppDBManager adm=null;
    Session session;


    SharedPreferences sp=null;
    SharedPreferences.Editor se=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        adm=new AppDBManager(this);
        adm.openDb();
        session=new Session(this);
        txtid=(EditText)findViewById(R.id.txtid);
        txtpass=(EditText)findViewById(R.id.txtpass);

        sp=getSharedPreferences("info",MODE_PRIVATE);
        se=sp.edit();
        /*if(session.loggedin())
        {
            startActivity(new Intent(Login.this,HomeScreen.class));
            finish();
        }*/
    }
    public void account(View v)
    {

        Intent j=new Intent(Login.this,Signup.class);
        startActivity(j);
    }

    public void checklogin(View v)
    {
        String ui=txtid.getText().toString();
         String upass=txtpass.getText().toString();

        String storedPassword = adm.getSingleEntry(ui);
        if(ui.length()==0|| upass.length()==0)
        {
            showDialog();
        }

        else if (upass.equals(storedPassword)) {

            session.setLoggedin(true);
            Toast.makeText(Login.this, "Congrats: Login Successful", Toast.LENGTH_LONG).show();
            se.putString("user_name_fetch", ui);
            se.commit();
            startActivity(new Intent(getApplicationContext(), HomeScreen.class));
        }

        else if(ui.equals("admin")&&upass.equals("admin"))
        {
            Intent i=new Intent(this,Admin.class);
            //String data=ui+","+upass;
            //i.putExtra("user",data);
            startActivity(i);

        }

        else
        {
            Toast.makeText(Login.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
        }

    }


    public void showDialog()
    {

        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setTitle("info");
        adb.setMessage("Data Required");
        adb.setPositiveButton("ok",this);
        ad=adb.create();
        ad.show();

    }

    @Override
    public void onClick(DialogInterface dialog, int which)
    {

        switch (which)
        {
            case DialogInterface.BUTTON_POSITIVE:
                Toast.makeText(this,"please enter",Toast.LENGTH_LONG).show();
                break;
        }

    }

}

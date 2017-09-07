package com.example.deepi.fiesta;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends AppCompatActivity {


    ViewPager viewPagerrr;
    CustomAdapterMain customAdapterMain;
    Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        session=new Session(this);
        if(session.loggedin())
        {
            startActivity(new Intent(Main.this,HomeScreen.class));
            finish();
        }
        customAdapterMain= new CustomAdapterMain(this);
        viewPagerrr=(ViewPager)findViewById(R.id.viewpagerrrr);
        viewPagerrr.setAdapter(customAdapterMain);

        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new MyTimerClass(),2000,4000);
    }


    public class MyTimerClass extends TimerTask
    {
        @Override
        public void run() {

            Main.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPagerrr.getCurrentItem()==0)
                    {
                        viewPagerrr.setCurrentItem(1);
                    }else if (viewPagerrr.getCurrentItem()==1)
                    {
                        viewPagerrr.setCurrentItem(2);
                    }
                    else if (viewPagerrr.getCurrentItem()==2)
                    {
                        viewPagerrr.setCurrentItem(0);
                    }

                }
            });
        }
    }

    public void login(View v)
    {
        Intent i=new Intent(this,Login.class);
        startActivity(i);
    }

    public void skip(View v)
    {
        Intent i=new Intent(this,Signup.class);
        startActivity(i);
    }

}

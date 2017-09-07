package com.example.deepi.fiesta;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * Created by Deepi on 2/12/2017.
 */
public class MyAdapter extends BaseAdapter
{
    private final List<Venue> ml;
    String n;

    private LayoutInflater lf=null;
    Context ctx=null;
    public MyAdapter(Activity activity, List<Venue>l)
    {
        ctx= activity.getApplicationContext();
        ml=l;
        lf=LayoutInflater.from(activity);
    }



    @Override
    public int getCount() {
        return ml.size();
    }

    @Override
    public Object getItem(int i) {
        return ml.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent)
    {

        //Toast.makeText(ctx, "view created", Toast.LENGTH_SHORT).show();
        if (view == null) {
            view = lf.inflate(R.layout.mycustom, parent, false);
        }
        TextView tv = (TextView) view.findViewById(R.id.tv);
//        ImageView im = (ImageView) view.findViewById(R.id.img1);
        Venue hm = ml.get(i);
        n=hm.getMname();
        tv.setText(hm.getMname());
        // im.setImageResource(hm.getMimage());
  //      byte[]img=hm.getMimage();
        /*Bitmap b= BitmapFactory.decodeByteArray(img,0,img.length);*/
    //    ByteArrayInputStream bis=new ByteArrayInputStream(img);
      //  Bitmap b= BitmapFactory.decodeStream(bis);
        //im.setImageBitmap(b);
        return view;
    }
}

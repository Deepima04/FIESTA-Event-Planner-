package com.example.deepi.fiesta;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Deepi on 3/18/2017.
 */
public class CustomAdapterMain extends PagerAdapter
{
    private int[] img={R.drawable.images,R.drawable.event1,R.drawable.event2,R.drawable.event3};
    private LayoutInflater inflater;
    private Context context;

    public CustomAdapterMain(Context context)
    {
        this.context=context;
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.swipe,container,false);
        ImageView im=(ImageView)v.findViewById(R.id.photo);
        im.setImageResource(img[position]);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }

}

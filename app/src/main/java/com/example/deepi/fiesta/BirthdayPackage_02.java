package com.example.deepi.fiesta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Deepi on 3/23/2017.
 */
public class BirthdayPackage_02 extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_birthday_packages02, container, false);
        Button b1=(Button)rootView.findViewById(R.id.goldbirthday);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namebirthday="Gold";
                Intent i=new Intent(getActivity(),CustomizeBirthday.class);
                i.putExtra("birthdaykey",namebirthday);
                startActivity(i);
            }
        });
        return rootView;

    }
}

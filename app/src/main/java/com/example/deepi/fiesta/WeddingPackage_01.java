package com.example.deepi.fiesta;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Deepi on 3/23/2017.
 */
public class WeddingPackage_01 extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_wedding_packages01, container, false);
        Button b1=(Button)rootView.findViewById(R.id.platinumwedding);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namewedding="Platinum";
                Intent i=new Intent(getActivity(),CustomizeWedding.class);
                i.putExtra("weddingkey",namewedding);
                startActivity(i);
            }
        });
        return rootView;

    }
}

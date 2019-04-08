package com.example.projecttest2;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class plantDetail extends Fragment {

    TextView plantName1, water1, sun1, loc1;
    ImageView plantpic1;
    FloatingActionButton addbtn;
    String name ,water, sun, loc, plantpic;

    public plantDetail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_plant_detail, container, false);

        plantName1 = v.findViewById(R.id.plantname);
        water1 = v.findViewById(R.id.watertx);
        sun1 = v.findViewById(R.id.suntx);
        loc1 = v.findViewById(R.id.loctx);
        plantpic1 = v.findViewById(R.id.Image_ret);
        addbtn = v.findViewById(R.id.add_to_user);

          name = getArguments().getString("name");
         water = getArguments().getString("water");
         sun = getArguments().getString("sun");
         loc = getArguments().getString("loc");
         plantpic = getArguments().getString("image");

        plantName1.setText(name);
        water1.setText(water);
        sun1.setText(sun);
        loc1.setText(loc);
        Picasso.get().load(plantpic).into(plantpic1);



        return v;
    }




}

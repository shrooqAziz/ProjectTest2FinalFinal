package com.example.projecttest2;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class plantDetailSearch extends Fragment {


    public plantDetailSearch() {
        // Required empty public constructor
    }

    TextView plantName1, water1, sun1, loc1;
    ImageView plantpic1 ,backbtnsearch;
    FloatingActionButton addbtn;
    String plantname, water, sun, loc, plantpic;


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

        plantname = getArguments().getString("name");
        water = getArguments().getString("water");
        sun = getArguments().getString("sun");
        loc = getArguments().getString("loc");
        plantpic = getArguments().getString("image");

        plantName1.setText(plantname);
        water1.setText(water);
        sun1.setText(sun);
        loc1.setText(loc);
        Picasso.get().load(plantpic).into(plantpic1);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adduserplants();


            }
        });
        backbtnsearch = v.findViewById(R.id.backbsearchtn);
        backbtnsearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Search gotosearch = new Search();
                FragmentManager mn = getFragmentManager();
                mn.beginTransaction().replace(R.id.countainer, gotosearch, gotosearch.getTag()).commit();
            }
        });

        return v;
    }

    private void adduserplants() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference mRefusr;
        mRefusr = firebaseDatabase.getInstance().getReference().child("user plants");

        final HashMap<String, Object> usrplant = new HashMap<>();
        usrplant.put("name", plantname);
        usrplant.put("water", water);
        usrplant.put("sun", sun);
        usrplant.put("loc", loc);
        usrplant.put("image", plantpic);


        mRefusr.child(prevalebt.onlineuser.getName())
                .child("userlist").child(plantname).updateChildren(usrplant)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getActivity(), " plant added ..", Toast.LENGTH_LONG).show();

                        } else
                            Toast.makeText(getActivity(), "sorry try again .. ", Toast.LENGTH_LONG).show();
                    }
                });

    }
}

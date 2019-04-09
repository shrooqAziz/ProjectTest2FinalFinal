package com.example.projecttest2;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
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
    String name, water, sun, loc, plantpic;

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


        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adduserplants();


            }
        });


        return v;
    }

    private void adduserplants() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mRef = firebaseDatabase.getReferenceFromUrl("https://project-test-5c4a5.firebaseio.com/").child("user plants");
        final HashMap<String, Object> usrplant = new HashMap<>();
        usrplant.put("name",name);
        usrplant.put("water",water);
        usrplant.put("sun",sun);
        usrplant.put("loc",loc);

        mRef.child(prevalebt.onlineuser.getName()).updateChildren(usrplant)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getActivity(), " plant added ..", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getActivity(),HomeActivity.class);
                            startActivity(i);
                        }
                        else
                            Toast.makeText(getActivity(), "sorry try again .. ", Toast.LENGTH_LONG).show();
                    }
                });
    }
}



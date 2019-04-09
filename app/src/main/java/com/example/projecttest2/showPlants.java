package com.example.projecttest2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class showPlants extends Fragment {

    RecyclerView mRecyclerView;
    DatabaseReference mRef;
    View v;
    ImageView backbtn;


    public showPlants() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_show_plants, container, false);

        mRecyclerView = v.findViewById(R.id.recycle_viewout);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));




        backbtn = v.findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Home gotohome = new Home();
                FragmentManager mn = getFragmentManager();
                mn.beginTransaction().replace(R.id.countainer, gotohome, gotohome.getTag()).commit();
            }
        });

        return v;
    }
    @Override
    public void onStart() {

        super.onStart();

        mRef = FirebaseDatabase.getInstance().getReference("plants");
        FirebaseRecyclerAdapter<Model , ImageViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ImageViewHolder>(
                        Model.class,
                        R.layout.viewimagehold,
                        ImageViewHolder.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(ImageViewHolder viewHolder, final Model model, int position) {

                        viewHolder.setImages(model.getImage(), model.getName());


                        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Bundle data = new Bundle();
                                data.putString("name", model.getName());
                                data.putString("water", model.getWater());
                                data.putString("sun", model.getSun());
                                data.putString("loc", model.getLoc());
                                data.putString("image", model.getImage());
                                plantDetail frag = new plantDetail();
                                frag.setArguments(data);
                                getFragmentManager().beginTransaction().replace(R.id.countainer, frag).addToBackStack(null).commit();
                                frag.setArguments(data);

                            }
                        });
                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);



    }
}



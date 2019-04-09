package com.example.projecttest2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class Search extends Fragment {

    public Search() {
        // Required empty public constructor
    }

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRefs;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search,container, false);
        mRecyclerView = v.findViewById(R.id.recycle_viewin);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        mFirebaseDatabase= FirebaseDatabase.getInstance();


        return v;

    }
    public void onStart() {

        super.onStart();
        mRefs = mFirebaseDatabase.getReferenceFromUrl("https://project-test-5c4a5.firebaseio.com/");

        FirebaseRecyclerAdapter<Model , ImageViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ImageViewHolder>(
                        Model.class,
                        R.layout.viewimagehold,
                        ImageViewHolder.class,
                        mRefs
                ) {
                    @Override
                    protected void populateViewHolder(ImageViewHolder viewHolder, Model model, int position) {

                        viewHolder.setImages( model.getImage(), model.getName());
                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);


    }

}



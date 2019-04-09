package com.example.projecttest2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


/**
 * A simple {@link Fragment} subclass.
 */
public class Search extends Fragment {

    public Search() {
        // Required empty public constructor
    }

     DatabaseReference mRefs;
     RecyclerView result;
    private ImageButton searchbtn;
    private EditText searchtx;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        result = v.findViewById(R.id.search_recycle_view);
        result.setHasFixedSize(true);
        result.setLayoutManager(new LinearLayoutManager(getActivity()));


        mRefs = FirebaseDatabase.getInstance().getReference("plants");


        searchbtn = v.findViewById(R.id.search_bar);
        searchtx = v.findViewById(R.id.searchtext);


        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchText = searchtx.getText().toString();

                firebaseSearch(searchText);

            }
        });



        setHasOptionsMenu(true);
        return v;

    }

    private void firebaseSearch(String searchText) {

        Toast.makeText(getActivity(), "Started Search", Toast.LENGTH_LONG).show();

        Query firebaseSearchQuery = mRefs.orderByChild("name").startAt(searchText).endAt(searchText + "\uf8ff");

        FirebaseRecyclerAdapter<Model, ImageViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ImageViewHolder>(
                        Model.class,
                        R.layout.viewimagehold,
                        ImageViewHolder.class,
                        firebaseSearchQuery

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
        result.setAdapter(firebaseRecyclerAdapter);
    }

    public void onStart() {

        super.onStart();


        FirebaseRecyclerAdapter<Model, ImageViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ImageViewHolder>(
                        Model.class,
                        R.layout.viewimagehold,
                        ImageViewHolder.class,
                        mRefs
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
        result.setAdapter(firebaseRecyclerAdapter);


    }

}
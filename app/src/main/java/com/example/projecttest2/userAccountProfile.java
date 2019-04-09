package com.example.projecttest2;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class userAccountProfile extends Fragment {


    public userAccountProfile() {
        // Required empty public constructor
    }

    RecyclerView mRecyclerView;
    DatabaseReference mRef;
    TextView name;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_user_account_profile, container, false);

        name = v.findViewById(R.id.user_name_profil);
        name.setText(prevalebt.onlineuser.getName());


        mRecyclerView = v.findViewById(R.id.user_plant_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        return v;
    }
    @Override
    public void onStart() {

        super.onStart();

        mRef = FirebaseDatabase.getInstance(). getReference("user plants")
                .child(prevalebt.onlineuser.getName()).child("userlist");

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
                                CharSequence options[]= new CharSequence[]{
                                        "Delete"
                                };
                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                                builder.setItems(options, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                            mRef.child(model.getName())
                                                    .removeValue()
                                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            if(task.isSuccessful()){
                                                                Toast.makeText(getActivity().getApplicationContext(), "plant removed .. ", Toast.LENGTH_SHORT).show();
                                                            } }
                                                    });
                                    }
                                });
                                builder.show();
                            }
                        });
                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);



    }

}


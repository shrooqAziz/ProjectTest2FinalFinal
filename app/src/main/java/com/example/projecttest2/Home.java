package com.example.projecttest2;




import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {


    public Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

       Button showbtn = (Button)rootView.findViewById(R.id.show_plant_btn);
        showbtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                showPlants gotoplants = new showPlants();
                FragmentManager mn = getFragmentManager();
                mn.beginTransaction().replace(R.id.countainer ,gotoplants).addToBackStack(Home.class.getSimpleName()).commit();

            }

        });

        return rootView;
    }
}



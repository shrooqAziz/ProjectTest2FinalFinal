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

       Button btnOut = (Button)rootView.findViewById(R.id.btnOut);
        btnOut.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                outdoor gotooutdoor = new outdoor();
                FragmentManager mn = getFragmentManager();
                mn.beginTransaction().replace(R.id.countainer ,gotooutdoor).addToBackStack(Home.class.getSimpleName()).commit();

            }

        });
        Button btnIN = (Button)rootView.findViewById(R.id.btIN);
        btnIN.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                indoor gotoIndoor = new indoor();
                FragmentManager mn = getFragmentManager();
                mn.beginTransaction().replace(R.id.countainer ,gotoIndoor).addToBackStack(Home.class.getSimpleName()).commit();

            }

        });
        Button btnflow = (Button)rootView.findViewById(R.id.btnflo);
        btnflow.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                flower gotoflower = new flower();
                FragmentManager mn = getFragmentManager();
                mn.beginTransaction().replace(R.id.countainer ,gotoflower).addToBackStack(Home.class.getSimpleName()).commit();

            }

        });
        return rootView;
    }
}



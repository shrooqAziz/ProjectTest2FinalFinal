package com.example.projecttest2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Account extends Fragment {
//https://github.com/firebase/quickstart-android/tree/fabbbda18070150eec4770e5346c0442844e85a9
//https://github.com/googlesamples/google-services/tree/master/android

    public Account() {
        // Required empty public constructor
    }

    TextView signInbtn , signUPbtn, logOut;

    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_account, container, false);
        signInbtn = v.findViewById(R.id.signIntx);
        signUPbtn = v.findViewById(R.id.SignUptx);
       // logOut = v.findViewById(R.id.log_out);

        final Intent signUPpage = new Intent(getActivity(),SignUPActivity.class);
        signUPbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(signUPpage);
            }
        });
        final Intent signInpage = new Intent(getActivity(), SignInActivity.class);
        signInbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(signInpage);

            }

        });


        return v;
    }
}

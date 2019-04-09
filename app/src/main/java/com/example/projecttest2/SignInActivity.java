package com.example.projecttest2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class SignInActivity extends AppCompatActivity {
    EditText userinput;
    EditText passinput;
    Button signIn;
    private String parentDbname = "user";
    String username ;
    String password;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        userinput = findViewById(R.id.namein);
        passinput = findViewById(R.id.passwordin);
        signIn = findViewById(R.id.signInbtn);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

    }

    private void loginUser() {

         username =userinput.getText().toString();
         password = passinput.getText().toString();

         if(TextUtils.isEmpty(username)){
            Toast.makeText(this,"please enter your username .. ",Toast.LENGTH_LONG).show();
          }
         else  if(TextUtils.isEmpty(password)) {
             Toast.makeText(this, "please enter your password .. ", Toast.LENGTH_LONG).show();
         }
         else
             AllowAccessToAcount(username,password);


    }

    private void AllowAccessToAcount(final String username, final String password) {

        final DatabaseReference mRef;
        mRef = FirebaseDatabase.getInstance().getReference();

        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(parentDbname).child(username).exists()){
                    Usermodel userData = dataSnapshot.child(parentDbname).child(username).getValue(Usermodel.class);

                    if(userData.getName().equals(username)){

                        if(userData.getPassword().equals(password)){
                            Toast.makeText(getApplicationContext(), "Sign in successfully .. ", Toast.LENGTH_LONG).show();
                            prevalebt.onlineuser=userData;

                            Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                            startActivity(i);

                        }
                        else
                            Toast.makeText(getApplicationContext(), "password wrong .. ", Toast.LENGTH_LONG).show();
                    }
                }
                else
                    Toast.makeText(getApplicationContext(), "the username not exists", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}

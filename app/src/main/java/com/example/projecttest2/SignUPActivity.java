package com.example.projecttest2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;


public class SignUPActivity extends AppCompatActivity  {

    EditText getemail , getpass, getname ;
    Button createbtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getemail = findViewById(R.id.fieldEmail);
        getname = findViewById(R.id.nameIN);
        getpass = findViewById(R.id.fieldPassword);

        createbtn = findViewById(R.id.emailCreateAccountButton);

        createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAccount();
            }
        });
    }

    private void CreateAccount() {
        String name = getname.getText().toString();
        String email = getemail.getText().toString();
        String password = getpass.getText().toString();

        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"please enter your name .. ",Toast.LENGTH_LONG).show();
        }
        else if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"please enter your email .. ",Toast.LENGTH_LONG).show();
        }
       else  if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"please enter your password .. ",Toast.LENGTH_LONG).show();
        }
        else {
            Validateusername(name,email,password);

        }
    }

    private void Validateusername(final String name, final String email, final String password) {
        final DatabaseReference mRef;
        mRef = FirebaseDatabase.getInstance().getReference();
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!(dataSnapshot.child("user").child(name).exists())){
                    HashMap<String,Object> userdataMap = new HashMap<>();
                    userdataMap.put("name", name);
                    userdataMap.put("email", email);
                    userdataMap.put("password", password);

                    mRef.child("user").child(name).updateChildren(userdataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(getApplicationContext(), "Account created .. ", Toast.LENGTH_LONG).show();
                                        Intent gotosignIn =new Intent(getApplicationContext(),SignInActivity.class);
                                        startActivity(gotosignIn);
                                    }
                                    else
                                        Toast.makeText(getApplicationContext(), "Account Not created .. ", Toast.LENGTH_LONG).show();
                                }
                            });
                }
                else
                    Toast.makeText(getApplicationContext(), name + "  username Already exists ...", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}

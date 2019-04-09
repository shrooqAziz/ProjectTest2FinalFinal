package com.example.projecttest2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tx1;
    private TextView tx2;
    private ImageView iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //https://www.youtube.com/watch?v=h_hTuaEpc-8
        tx1=(TextView) findViewById(R.id.title1);
        tx2=(TextView) findViewById(R.id.title2);
        iv=(ImageView) findViewById(R.id.logo);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tx1.startAnimation(myanim);
        tx2.startAnimation(myanim);
        iv.startAnimation(myanim);

        final Intent tohome = new Intent(this,HomeActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(tohome);
                    finish();
                }

            }
        };
        timer.start();
    }
}


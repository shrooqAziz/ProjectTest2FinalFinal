package com.example.projecttest2;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.Bottom_navigation_view);


        final Home homefrag = new Home();
        final Account Accountfrag = new Account();
        final Search searchfrag = new Search();
        final Profile profilefrag = new Profile();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected (@NonNull MenuItem menuItem){

                switch (menuItem.getItemId()) {
                    case R.id.homenav:
                        setFragment(homefrag);
                        return true;
                    case R.id.searchnav:
                        setFragment(searchfrag);
                        return true;
                    case R.id.user_profile:
                        setFragment(profilefrag);
                        return true;
                    case R.id.usernav:
                        setFragment(Accountfrag);
                        return true;

                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.homenav);

    }
    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction =  getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.countainer, fragment);
        fragmentTransaction.commit();
    }
}

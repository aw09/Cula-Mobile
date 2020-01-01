package com.example.cula_mobile;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.cula_mobile.module.mytask.MyCardFragment;
import com.example.cula_mobile.module.profile.AccountFragment;
import com.example.cula_mobile.module.project.ProjectsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityBottom_navigation extends AppCompatActivity {
    private TextView mTextMessage;
    private ActionBar actionBar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_myprojects:
                    return fragmentTransaction(new ProjectsFragment());
                case R.id.navigation_mytask:
                    return fragmentTransaction(new MyCardFragment());
//                case R.id.navigation_notifications:
//                    return fragmentTransaction(new NotificationsFragment());
                case R.id.navigation_account:
                    return fragmentTransaction(new AccountFragment());
            }
            return false;
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        fragmentTransaction(new ProjectsFragment());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mTextMessage = findViewById(R.id.message);


    }

    private boolean fragmentTransaction(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        String backStackStateName = null;
        fragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout_container, fragment, "")
                .commit();
        return true;
    }



}

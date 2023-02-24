package com.example.courseworkandroid7api25.Likes;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import com.example.courseworkandroid7api25.R;
import com.example.courseworkandroid7api25.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;


public class LikesActivity extends AppCompatActivity {
    private static final String TAG = "LikesActivity";
    private Context mContext= LikesActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d(TAG, "onCreate: ");
//        setupNavigationView();
    }
    private void setupNavigationView(){
        Log.d(TAG, "setupNavigationView: setting up BottomnavigationView");
        BottomNavigationViewEx bottomNavigationView =(BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomnavigationView(bottomNavigationView);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationView);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);
    }
}

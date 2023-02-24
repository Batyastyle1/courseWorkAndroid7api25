package com.example.courseworkandroid7api25.Share;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

 ;

import com.example.courseworkandroid7api25.R;
import com.example.courseworkandroid7api25.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;


public class ShareActivity extends AppCompatActivity
{
    private static final String TAG = "ShareActivity";
    private Context mContext = ShareActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        setupNavigationView();
    }

    private void setupNavigationView()
    {
        Log.d(TAG, "setupNavigationView: setting up BottomnavigationView");
        BottomNavigationViewEx bottomNavigationViewEx =(BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomnavigationView(bottomNavigationViewEx);

        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);

        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

    }
}

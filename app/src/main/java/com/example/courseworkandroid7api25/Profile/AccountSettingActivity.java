package com.example.courseworkandroid7api25.Profile;

import android.content.Context;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;


import com.example.courseworkandroid7api25.R;
import com.example.courseworkandroid7api25.Utils.BottomNavigationViewHelper;
import com.example.courseworkandroid7api25.Utils.SectionStatePagerAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class AccountSettingActivity extends AppCompatActivity {
    private static final String TAG = "AccountSettingActivity";
    private Context mContext;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);
        Log.d(TAG, "onCreate: started.");

        mContext = AccountSettingActivity.this;
        mViewPager = (ViewPager) findViewById(R.id.container);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relLayout1);

        setupSettingsList();
        setupFragment();

        //back arrow nado ebanut dlya profileActivity
        ImageView backArrow = (ImageView) findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: nav dlya backArrow");
                finish();
            }
        });


        setupBottomNavigationView();
    }
    //
    private SectionStatePagerAdapter pagerAdapter;
    private ViewPager mViewPager;
    private RelativeLayout mRelativeLayout;

    private void setupFragment(){
        pagerAdapter=new SectionStatePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new EditProfileFragment(),getString(R.string.edit_profile_fragment));
        pagerAdapter.addFragment(new SignOutFragment(),getString(R.string.sign_uot_fragment));

    }
    private void setViewPager(int fragmentNumber){
        mRelativeLayout.setVisibility(View.GONE);
        Log.d(TAG, "setViewPager: navigating to fragment " + fragmentNumber);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setCurrentItem(fragmentNumber);
    }


    //

    private void setupBottomNavigationView() {
        Log.d(TAG, "setupNavigationView: setting up BottomnavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomnavigationView(bottomNavigationViewEx);

        BottomNavigationViewHelper.enableNavigation(AccountSettingActivity.this, bottomNavigationViewEx);


        Menu menu = bottomNavigationViewEx.getMenu();

        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);


    }

    //

    private void setupSettingsList() {
        Log.d(TAG, "setupSettingsList: initializing 'Account setting ' list ");
        ListView listView = (ListView) findViewById(R.id.lvAccountSettings);

        ArrayList<String> options = new ArrayList<>();
        options.add(getString(R.string.edit_profile_fragment));
        options.add(getString(R.string.sign_uot_fragment));

        ArrayAdapter adapter = new ArrayAdapter(mContext, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.d(TAG, "onItemClick: nav" + position);
                setViewPager(position);
            }
        });


    }
}

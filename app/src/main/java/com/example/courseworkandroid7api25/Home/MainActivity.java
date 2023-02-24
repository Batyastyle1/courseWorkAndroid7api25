package com.example.courseworkandroid7api25.Home;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.courseworkandroid7api25.R;
import com.example.courseworkandroid7api25.Utils.BottomNavigationViewHelper;
import com.example.courseworkandroid7api25.Utils.SectionPagerAdapter;
import com.example.courseworkandroid7api25.Utils.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nostra13.universalimageloader.core.ImageLoader;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Context mContext = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: starting.");
        initImageLoader();
        //nijnie 5 figushek
        setupBottomNavigationView();
        //vverchnie tri figushki na glavnom ekrane
        setupViewPager();


    }

    private void initImageLoader(){
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(mContext);
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }
    //vverchnie tri figushki na glavnom ekrane
    private void setupViewPager( ) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CameraFragment()); //index 0
        adapter.addFragment(new HomeFragment());//index 1
        adapter.addFragment(new MessagesFragment());//index 2

        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera_camera);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_camera);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_send);

    }

    // bottom_navView

    private void setupBottomNavigationView() {
        Log.d(TAG, "setupNavigationView: setting up BottomnavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomnavigationView(bottomNavigationViewEx);

        BottomNavigationViewHelper.enableNavigation(MainActivity.this,bottomNavigationViewEx);

//        Intent intent = new Intent(MainActivity.this,MainActivity.class);
//        startActivity(intent);


        Menu menu = bottomNavigationViewEx.getMenu();

        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);


    }
}
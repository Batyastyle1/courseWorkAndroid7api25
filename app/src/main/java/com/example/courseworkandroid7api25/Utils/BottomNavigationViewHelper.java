package com.example.courseworkandroid7api25.Utils;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;


import com.example.courseworkandroid7api25.Home.MainActivity;
import com.example.courseworkandroid7api25.Likes.LikesActivity;
import com.example.courseworkandroid7api25.Profile.ProfileActivity;
import com.example.courseworkandroid7api25.R;
import com.example.courseworkandroid7api25.Search.SearchActivity;
import com.example.courseworkandroid7api25.Share.ShareActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;


public class BottomNavigationViewHelper {


    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomnavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        Log.d(TAG, "setupBottomnavigationViewEx: Setting up BottomnavigationView");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);



    }
    public static void enableNavigation(final Context context,BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {

                    case R.id.ic_home:
                        Intent intent1=new Intent(context, MainActivity.class);
                        context.startActivity(intent1); // index 0
                        break;
                    case R.id.ic_search:
                        Intent intent2=new Intent(context, SearchActivity.class);
                        context.startActivity(intent2);
                        break;
                    case R.id.ic_heart:
                        Intent intent3=new Intent(context, ShareActivity.class);
                        context.startActivity(intent3);
                        break;
                    case R.id.ic_alert:
                        Intent intent4=new Intent(context, LikesActivity.class);
                        context.startActivity(intent4);
                        break;
                    case R.id.ic_profil:
                        Intent intent5=new Intent(context, ProfileActivity.class);
                        context.startActivity(intent5);
                        break;

                }

                return false;
            }
        });
    }

}

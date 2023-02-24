package com.example.courseworkandroid7api25.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SectionStatePagerAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final HashMap<Fragment, Integer> mFragmens = new HashMap<>();
    private final HashMap<String, Integer> mFragmenNumbers = new HashMap<>();
    private final HashMap<Integer, String> mFragmenNames = new HashMap<>();

    public SectionStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment,String fragmentName){
        mFragmentList.add(fragment);
        mFragmens.put(fragment,mFragmentList.size()-1);
        mFragmenNumbers.put(fragmentName,mFragmentList.size()-1);
        mFragmenNames.put(mFragmentList.size()-1,fragmentName);
    }

    //vosvrashaet fragment s imenem
    public Integer getFragmentNumber(String fragmentName)
    {
        if (mFragmenNumbers.containsKey(fragmentName)){
            return mFragmenNumbers.get(fragmentName);


        }else {
            return null;
        }
    }

    public String getFragmentName(Integer fragmentNumber)
    {
        if (mFragmenNames.containsKey(fragmentNumber)){
            return mFragmenNames.get(fragmentNumber );
        }else {
            return null;
        }
    }

}

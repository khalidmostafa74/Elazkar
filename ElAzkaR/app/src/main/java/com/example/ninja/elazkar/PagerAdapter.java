package com.example.ninja.elazkar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by ninja on 19/02/2018.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    Fragment fr[] = new Fragment[]{new F1(),new F2(),new F3()};
//    String title[]=new String[]{"General","Notification","Alarm"};
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fr[position];
    }

    @Override
    public int getCount() {
        return fr.length;
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        return title[position];
//    }
}

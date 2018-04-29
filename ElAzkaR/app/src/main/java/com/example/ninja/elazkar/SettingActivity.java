package com.example.ninja.elazkar;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SettingActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabLayout = findViewById(R.id.tab);
        pager = findViewById(R.id.pager);
        pager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(pager);
        int imgs[]={R.drawable.ic_settings,R.drawable.ic_notifications,R.drawable.ic_alarm};
        for (int i = 0 ; i < tabLayout.getTabCount();i++){
            tabLayout.getTabAt(i).setIcon(imgs[i]);
        }


    }
}

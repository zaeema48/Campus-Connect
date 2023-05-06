package com.example.campusconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.campusconnect.Adapter.ParentPagerAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class ParentPage extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem homeFragment, noticeFragment, profileFragment;
    ViewPager viewPager;

    ParentPagerAdapter parentPagerAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_page);

        tabLayout = findViewById(R.id.tabLayout);
        homeFragment = findViewById(R.id.home);
        noticeFragment = findViewById(R.id.notice);
        profileFragment = findViewById(R.id.profile);
        viewPager = findViewById(R.id.fragment_container);

        parentPagerAdapter = new ParentPagerAdapter(getSupportFragmentManager(), 3);
        viewPager.setAdapter(parentPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
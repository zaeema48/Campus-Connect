package com.example.campusconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.campusconnect.Adapter.PagerAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class TeacherPage extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem homeFragment, noticeFragment, profileFragment;
    ViewPager viewPager;
    PagerAdapter teacherPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_page);

        tabLayout = findViewById(R.id.tabLayout);
        homeFragment = findViewById(R.id.home);
        noticeFragment = findViewById(R.id.notice);
        profileFragment = findViewById(R.id.profile);
        viewPager = findViewById(R.id.fragment_container);

        teacherPagerAdapter = new PagerAdapter(getSupportFragmentManager(), 3);
        viewPager.setAdapter(teacherPagerAdapter);


    }
}
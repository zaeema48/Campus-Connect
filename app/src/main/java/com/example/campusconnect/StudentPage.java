package com.example.campusconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.campusconnect.Adapter.StudentPagerAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class StudentPage extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem homeFragment, noticeFragment, profileFragment;
    ViewPager viewPager;

    StudentPagerAdapter studentPagerAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_page);

        tabLayout = findViewById(R.id.tabLayout);
        homeFragment = findViewById(R.id.home);
        noticeFragment = findViewById(R.id.notice);
        profileFragment = findViewById(R.id.profile);
        viewPager = findViewById(R.id.fragment_container);

        studentPagerAdapter = new StudentPagerAdapter(getSupportFragmentManager(), 3);
        viewPager.setAdapter(studentPagerAdapter);

    }
}
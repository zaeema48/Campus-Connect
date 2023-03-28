package com.example.campusconnect.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.campusconnect.Fragments.NoticeFragment;
import com.example.campusconnect.Fragments.ProfileFragment;
import com.example.campusconnect.Fragments.TeacherHomeFragment;

public class TeacherPagerAdapter extends FragmentPagerAdapter {
    int count;
    public TeacherPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        count=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       switch(position){
           case 0:
               return new TeacherHomeFragment();

           case 1:
               return new NoticeFragment();

           case 2:
               return new ProfileFragment();

           default:
               return null;
       }
    }

    @Override
    public int getCount() {
        return count;
    }
}

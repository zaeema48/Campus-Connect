package com.example.campusconnect.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.campusconnect.Fragments.HomeFragment;
import com.example.campusconnect.Fragments.NotificationFragment;
import com.example.campusconnect.Fragments.ProfileFragment;

public class PagerAdapter extends FragmentPagerAdapter {
    int count;
    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        count=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new HomeFragment();

            case 1:
                return new NotificationFragment();

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

package com.example.campusconnect.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.campusconnect.Fragments.ParentHomeFragment;
import com.example.campusconnect.Fragments.ParentProfile;
import com.example.campusconnect.Fragments.StudentHomeFragment;
import com.example.campusconnect.Fragments.StudentProfile;
import com.example.campusconnect.Fragments.ViewNoticeFragment;

public class ParentPagerAdapter extends FragmentPagerAdapter {
    int count;

    public ParentPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        count=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new ParentHomeFragment();

            case 1:
                return new ViewNoticeFragment();

            case 2:
                return new ParentProfile();

            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return count;
    }
}

package com.example.campusconnect.Adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;

public class ParentPagerAdapter extends PagerAdapter {
    public ParentPagerAdapter(FragmentManager supportFragmentManager, int i) {
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }
}

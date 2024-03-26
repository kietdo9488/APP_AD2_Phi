package com.example.myapplication.ViewPager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.fragment.AbstractFragment;

import java.util.LinkedList;

public class ViewPager2Adapter extends FragmentStateAdapter {
    public static final int HOME = 0;
    public static final int CATEGORY = 1;
    public static final int CART =2;
    public static final int PROFILE = 3;

    private LinkedList<AbstractFragment> fragments;
    private FragmentActivity fragmentActivity;

    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.fragmentActivity = fragmentActivity;
    }

    public void setFragments(LinkedList<AbstractFragment> fragments) {
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}

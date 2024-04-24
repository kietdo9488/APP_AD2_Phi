package com.example.myapplication.QuanLy.ViewPaper2Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.QuanLy.fragment.DanhMucManageFragment;
import com.example.myapplication.QuanLy.fragment.SanPhamManageFragment;
import com.example.myapplication.fragment.AbstractFragment;

public class ManageViewPaper2Adapter extends FragmentStateAdapter {

    public static final int MANAGE_SANPHAM = 0;
    public static final int MANAGE_DANHMUC = 1;

    FragmentActivity fragmentActivity;
    AbstractFragment fragment;

    public ManageViewPaper2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.fragmentActivity = fragmentActivity;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return replaceFragment(position);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    private Fragment replaceFragment(int screenID){
        FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
        if (fragmentManager.findFragmentByTag(screenID + "") != null) {
            fragment = (AbstractFragment) fragmentManager.findFragmentByTag(screenID + "");
        } else {

            switch (screenID){
                case MANAGE_SANPHAM:
                    fragment = new SanPhamManageFragment();
                    break;
                case MANAGE_DANHMUC:
                    fragment = new DanhMucManageFragment();
                    break;
            }
        }
        return fragment;
    }
}

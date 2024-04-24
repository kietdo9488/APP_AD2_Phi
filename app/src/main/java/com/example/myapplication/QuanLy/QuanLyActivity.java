package com.example.myapplication.QuanLy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TableLayout;

import com.example.myapplication.QuanLy.ViewPaper2Adapter.ManageViewPaper2Adapter;
import com.example.myapplication.R;
import com.example.myapplication.ViewPager.ViewPager2Adapter;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuanLyActivity extends AppCompatActivity {

    private TabLayout mTablayout;
    private ViewPager2 mViewPager2;
    private ManageViewPaper2Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly);

        mTablayout = findViewById(R.id.tab_layout);
        mViewPager2 = findViewById(R.id.view_pager2);
        adapter = new ManageViewPaper2Adapter(this);
        mViewPager2.setAdapter(adapter);

        new TabLayoutMediator(mTablayout, mViewPager2, (tab, position) ->{
            switch (position){
                case 0:
                    tab.setText("Sản Phẩm");
                    break;
                case 1:
                    tab.setText("Danh Mục");
                    break;
            }
        }).attach();
    }
}
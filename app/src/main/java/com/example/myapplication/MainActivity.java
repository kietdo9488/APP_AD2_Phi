package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.myapplication.ViewPager.ViewPager2Adapter;
import com.example.myapplication.fragment.AbstractFragment;
import com.example.myapplication.fragment.CartFragment;
import com.example.myapplication.fragment.CategoryFragment;
import com.example.myapplication.fragment.HomeFragment;
import com.example.myapplication.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    public static ViewPager2 vp2;

    private BottomNavigationView bnv;

    private ViewPager2Adapter viewPager2Adapter;

    LinkedList<AbstractFragment> fragments;

    private AbstractFragment fragment = null;

    private FragmentTransaction transaction;

    private int uiId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragments = new LinkedList<>();
        vp2 = findViewById(R.id.vp2);
        bnv = findViewById(R.id.bnv);
        viewPager2Adapter = new ViewPager2Adapter(this);

        fragments.add(new HomeFragment());
        fragments.add(new CategoryFragment());
        fragments.add(new CartFragment());
        fragments.add(new ProfileFragment());

        viewPager2Adapter.setFragments(fragments);
        vp2.setAdapter(viewPager2Adapter);

        vp2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case ViewPager2Adapter.HOME:
                        bnv.getMenu().findItem(R.id.nvaHome).setChecked(true);
                        break;
                    case ViewPager2Adapter.CATEGORY:
                        bnv.getMenu().findItem(R.id.nvaCategory).setChecked(true);
                        break;
                    case ViewPager2Adapter.CART:
                        bnv.getMenu().findItem(R.id.nvaCart).setChecked(true);
                        break;
                    case ViewPager2Adapter.PROFILE:
                        bnv.getMenu().findItem(R.id.nvaProfile).setChecked(true);
                        break;
                }
            }
        });

//        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.nvaHome:
//                        vp2.setCurrentItem(ViewPager2Adapter.HOME);
//                        break;
//                    case R.id.nvaCategory:
//                        vp2.setCurrentItem(ViewPager2Adapter.CATEGORY);
//                        break;
//                    case R.id.nvaCart:
//                        vp2.setCurrentItem(ViewPager2Adapter.CART);
//                        break;
//                    case R.id.nvaProfile:
//                        vp2.setCurrentItem(ViewPager2Adapter.PROFILE);
//                        break;
//                }
//                return true;
//            }
//        });
    }

    private void updateUI(int abstractFragment) {
        uiId = abstractFragment;
        if (getSupportFragmentManager().findFragmentByTag(uiId + "") != null) {
            fragment = (AbstractFragment) getSupportFragmentManager().findFragmentByTag(uiId + "");
        } else {
            switch (abstractFragment) {
                case 1:
                    Log.d("TAG", "updateUI: 1");
                    fragment = new HomeFragment();
                    break;
                case 2:
                    Log.d("TAG", "updateUI: 2");
                    fragment = new CategoryFragment();
                    break;
                case 3:
                    Log.d("TAG", "updateUI: 3");
                    fragment = new CartFragment();
                    break;
                case 4:
                    Log.d("TAG", "updateUI: 4");
                    fragment = new ProfileFragment();
                    break;
            }
        }
        if (fragment != null) {
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.vp2, fragment, uiId + "");
            if (getSupportFragmentManager().findFragmentByTag(uiId + "") == null) {
                transaction.addToBackStack(null);
            }
            transaction.commit();
        }
    }
}
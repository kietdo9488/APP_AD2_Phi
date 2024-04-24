package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapplication.adapter.SanPhamAdapter;
import com.example.myapplication.api.ApiService;
import com.example.myapplication.model.SanPham;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SanPhamByIdDanhMuc extends AppCompatActivity {
    int id;

    RecyclerView recyclerView;
    List<SanPham> list;
    SanPhamAdapter sanPhamAdapter;

    Activity activity = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham_by_id_danh_muc);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);

        recyclerView = findViewById(R.id.rvSanPhamByIdDanhMuc);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(gridLayoutManager);
        list = new ArrayList<>();

        listSanPham(id);


    }

    private void listSanPham(int id)
    {
        ApiService.apiService.getSanPhamByIdCategory(id).enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                if (response.body()!=null) {
                    list = response.body();
                    sanPhamAdapter = new SanPhamAdapter(activity, list, R.layout.cardview_sanpham);
                    recyclerView.setAdapter(sanPhamAdapter);
                    sanPhamAdapter.setOnClickItemListener(new SanPhamAdapter.OnClickItemListener() {
                        @Override
                        public void onClickItem(int position, View v) {
                            nextActivity(list.get(position).getId());
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {

            }
        });

    }

    private void nextActivity(int id)
    {
        Intent intent = new Intent(this, ChiTietSanPhamActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}
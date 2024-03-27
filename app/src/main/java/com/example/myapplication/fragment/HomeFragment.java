package com.example.myapplication.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.ChiTietSanPhamActivity;
import com.example.myapplication.R;
import com.example.myapplication.adapter.SanPhamAdapter;
import com.example.myapplication.api.ApiService;
import com.example.myapplication.model.SanPham;
import com.example.myapplication.model.TaiKhoan;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends AbstractFragment {

    RecyclerView recyclerView;
    List<SanPham> list;
    SanPhamAdapter sanPhamAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentLayout = null;
        fragmentLayout = inflater.inflate(R.layout.home_fragment, container, false);

//        recyclerView = fragmentLayout.findViewById(R.id.rvHome);
//        layoutManager = new LinearLayoutManager(getActivity());
//        layoutManager.setOrientation(RecyclerView.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(sanPhamAdapter);
//        list = new ArrayList<>();

        recyclerView = fragmentLayout.findViewById(R.id.rvHome);
        recyclerView.setLayoutManager(new LinearLayoutManager(fragmentLayout.getContext()));
        LinearLayoutManager layoutManager = new LinearLayoutManager(fragmentLayout.getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(fragmentLayout.getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(sanPhamAdapter);

        listSanPham();

        return fragmentLayout;
    }

    private void listSanPham()
    {
        ApiService.apiService.getListSanPham().enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {
                if (response.body()!=null) {
                    list = response.body();
                    sanPhamAdapter = new SanPhamAdapter(getActivity(), list, R.layout.cardview_sanpham);
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
        Intent intent = new Intent(getActivity(), ChiTietSanPhamActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}
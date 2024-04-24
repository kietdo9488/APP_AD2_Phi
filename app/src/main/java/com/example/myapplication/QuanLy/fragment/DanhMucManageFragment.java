package com.example.myapplication.QuanLy.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.ChiTietSanPhamActivity;
import com.example.myapplication.QuanLy.DanhMucChiTiet;
import com.example.myapplication.R;
import com.example.myapplication.SanPhamByIdDanhMuc;
import com.example.myapplication.adapter.DanhMucAdapter;
import com.example.myapplication.api.ApiService;
import com.example.myapplication.fragment.AbstractFragment;
import com.example.myapplication.model.DanhMuc;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhMucManageFragment extends AbstractFragment {

    RecyclerView recyclerView;
    List<DanhMuc> list;
    DanhMucAdapter danhMucAdapter;
    LinearLayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentLayout = null;
        fragmentLayout = inflater.inflate(R.layout.activity_danh_muc_manage_fragment, container, false);

        recyclerView = fragmentLayout.findViewById(R.id.rvCategory);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(danhMucAdapter);
        list = new ArrayList<>();

        listDanhMuc();

        return fragmentLayout;
    }

    private void listDanhMuc()
    {
        ApiService.apiService.getListDanhMuc().enqueue(new Callback<List<DanhMuc>>() {
            @Override
            public void onResponse(Call<List<DanhMuc>> call, Response<List<DanhMuc>> response) {
                if (response.body() != null) {
                    list = response.body();
                    danhMucAdapter = new DanhMucAdapter(getActivity(), list, R.layout.cardview_danhmuc);
                    recyclerView.setAdapter(danhMucAdapter);
                    danhMucAdapter.setOnClickItemListener(new DanhMucAdapter.OnClickItemListener() {
                        @Override
                        public void onClickItem(int position, View v) {
                            nextActivity(list.get(position).getId());
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<DanhMuc>> call, Throwable t) {

            }
        });
    }

    private void nextActivity(int id)
    {
        Intent intent = new Intent(getActivity(), DanhMucChiTiet.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}
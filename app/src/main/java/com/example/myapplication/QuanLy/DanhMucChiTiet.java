package com.example.myapplication.QuanLy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.api.ApiService;
import com.example.myapplication.model.DanhMuc;
import com.example.myapplication.model.SanPham;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhMucChiTiet extends AppCompatActivity {

    ImageView imgBack;
    EditText edtTenDanhMuc;

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_muc_chi_tiet);

        imgBack = findViewById(R.id.imgBack);
        edtTenDanhMuc = findViewById(R.id.edt_tenDanhMuc);
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);

        getDanhMucById(id);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void getDanhMucById(int id)
    {
        ApiService.apiService.getDanhMucById(id).enqueue(new Callback<DanhMuc>() {
            @Override
            public void onResponse(Call<DanhMuc> call, Response<DanhMuc> response) {
                if (response.body()!=null) {
                    DanhMuc data = response.body();
                    edtTenDanhMuc.setText(data.getTenDanhMuc());
                }
            }

            @Override
            public void onFailure(Call<DanhMuc> call, Throwable t) {

            }
        });
    }
}
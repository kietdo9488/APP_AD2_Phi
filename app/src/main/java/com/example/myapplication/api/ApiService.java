package com.example.myapplication.api;

import com.example.myapplication.Until;
import com.example.myapplication.model.DanhMuc;
import com.example.myapplication.model.SanPham;
import com.example.myapplication.model.TaiKhoan;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    ApiService apiService = new Retrofit.Builder()
            .baseUrl(Until.DOMAIN)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);
    @GET("TaiKhoanAll.php")
    Call<List<TaiKhoan>> getListTaiKhoan();

    @GET("SanPhamAll.php")
    Call<List<SanPham>> getListSanPham();
    @GET("SanPhamById.php")
    Call<SanPham> getSanPhamById(@Query("Id") int id);
    @GET("SanPhamByIDCategory.php")
    Call<List<SanPham>> getSanPhamByIdCategory(@Query("Id") int id);

    @GET("DanhMucAll.php")
    Call<List<DanhMuc>> getListDanhMuc();
}

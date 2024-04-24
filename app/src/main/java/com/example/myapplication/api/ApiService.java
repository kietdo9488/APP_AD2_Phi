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
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    ApiService apiService = new Retrofit.Builder()
            .baseUrl(Until.DOMAIN)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);
    @GET("TaiKhoanAll.php")
    Call<List<TaiKhoan>> getListTaiKhoan();
    @GET("TaiKhoanById.php")
    Call<TaiKhoan> getTaiKhoanById(@Query("Id") int id);
    @GET("TaiKhoanByName.php")
    Call<TaiKhoan> getTaiKhoanByNameAndPass(@Query("Key1") String key1, @Query("Key2") String key2);

    @GET("SanPhamAll.php")
    Call<List<SanPham>> getListSanPham();
    @GET("SanPhamById.php")
    Call<SanPham> getSanPhamById(@Query("Id") int id);
    @GET("SanPhamByIDCategory.php")
    Call<List<SanPham>> getSanPhamByIdCategory(@Query("Id") int id);

    @GET("DanhMucAll.php")
    Call<List<DanhMuc>> getListDanhMuc();
    @GET("DanhMucByID.php")
    Call<DanhMuc> getDanhMucById(@Query("Id") int id);

    @POST("DangKyTaiKhoan.php")
    Call<TaiKhoan> dangKyTaiKhoan(@Query("TenTaiKhoan") String tenTaiKhoan, @Query("MatKhauTaiKhoan") String matKhauTaiKhoan);
}

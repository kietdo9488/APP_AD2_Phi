package com.example.myapplication.api;

import com.example.myapplication.Until;
import com.example.myapplication.model.TaiKhoan;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    ApiService apiServiceKiet = new Retrofit.Builder()
            .baseUrl(Until.DOMAIN)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);
    @GET("TaiKhoanAll.php")
    Call<List<TaiKhoan>> getListTaiKhoan();
}

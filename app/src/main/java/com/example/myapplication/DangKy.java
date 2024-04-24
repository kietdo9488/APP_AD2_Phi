package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.api.ApiService;
import com.example.myapplication.model.TaiKhoan;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DangKy extends AppCompatActivity {

    Button btnDangKy;
    EditText edtTenDangNhap;
    EditText edtMatKhauDangNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        btnDangKy = findViewById(R.id.btn_dangKyTaiKhoan);
        edtTenDangNhap = findViewById(R.id.edt_tenTaiKhoanDangNhap);
        edtMatKhauDangNhap = findViewById(R.id.edt_matKhauTaiKhoanDangNhap);

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DangKyTaiKhoan(edtTenDangNhap.getText().toString(), edtMatKhauDangNhap.getText().toString());
                finish();
            }
        });

    }

    public void DangKyTaiKhoan(String tenTaiKhoan, String matKhauTaiKhoan)
    {
        ApiService.apiService.dangKyTaiKhoan(tenTaiKhoan, matKhauTaiKhoan).enqueue(new Callback<TaiKhoan>() {
            @Override
            public void onResponse(Call<TaiKhoan> call, Response<TaiKhoan> response) {

            }

            @Override
            public void onFailure(Call<TaiKhoan> call, Throwable t) {

            }
        });
    }
}
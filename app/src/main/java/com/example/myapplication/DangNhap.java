package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.QuanLy.QuanLyActivity;
import com.example.myapplication.adapter.SanPhamAdapter;
import com.example.myapplication.api.ApiService;
import com.example.myapplication.fragment.HomeFragment;
import com.example.myapplication.model.SanPham;
import com.example.myapplication.model.TaiKhoan;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DangNhap extends AppCompatActivity {

    Button btnDanhNhap;
    Button btnDangKy;
    EditText edtTenDangNhap;
    EditText edtMatKhauDangNhap;
    List<TaiKhoan> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        btnDanhNhap = findViewById(R.id.btn_dangNhap2);
        btnDangKy = findViewById(R.id.btn_dangKy);
        edtTenDangNhap = findViewById(R.id.edt_tenTaiKhoanDangNhap);
        edtMatKhauDangNhap = findViewById(R.id.edt_matKhauTaiKhoanDangNhap);

        btnDanhNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String strTK = edtTenDangNhap.getText().toString();
                if (edtTenDangNhap.getText().toString().isEmpty() && edtMatKhauDangNhap.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Dien day du thong tin", Toast.LENGTH_SHORT);
                }
                else
                {
                    dangNhap(edtTenDangNhap.getText().toString(), edtMatKhauDangNhap.getText().toString());
                }
            }
        });

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), DangKy.class);
                    startActivity(intent);
            }
        });
    }

        public void dangNhap(String key1, String key2)
    {
        ApiService.apiService.getTaiKhoanByNameAndPass(key1, key2).enqueue(new Callback<TaiKhoan>() {
            @Override
            public void onResponse(Call<TaiKhoan> call, Response<TaiKhoan> response) {
                TaiKhoan taiKhoan = response.body();
                    Until.IDTAIKHOAN = taiKhoan.getId();
                    finish();
            }

            @Override
            public void onFailure(Call<TaiKhoan> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Tai khoan khong ton tai", Toast.LENGTH_SHORT);
            }
        });
    }


}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.api.ApiService;
import com.example.myapplication.model.SanPham;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChiTietSanPhamActivity extends AppCompatActivity {
    int id;
    ImageView imgSanPhamChiTiet;
    TextView tenSanPhamChiTiet;
    TextView giaSanOhamChiTiet;
    TextView moTaSanPhamChiTiet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);

        ImageView imgBack = findViewById(R.id.imgBack);
        imgSanPhamChiTiet = findViewById(R.id.img_sanpham_chitiet);
        tenSanPhamChiTiet = findViewById(R.id.ten_sanpham_chitiet);
        giaSanOhamChiTiet = findViewById(R.id.gia_sanpham_chitiet);
        moTaSanPhamChiTiet = findViewById(R.id.mota_sanpham_chitiet);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        getSanPhamById(id);

    }

    private void getSanPhamById(int id)
    {
        ApiService.apiService.getSanPhamById(id).enqueue(new Callback<SanPham>() {
            @Override
            public void onResponse(Call<SanPham> call, Response<SanPham> response) {
                if (response.body()!=null) {
                    SanPham data = response.body();
                    Glide.with(getApplicationContext()).load(data.getHinhSanPham()).into(imgSanPhamChiTiet);
                    tenSanPhamChiTiet.setText(data.getTenSanPham());
                    giaSanOhamChiTiet.setText(String.valueOf(data.getGiaSanPham()));
                    moTaSanPhamChiTiet.setText(data.getMoTaSanPham());

                }
            }

            @Override
            public void onFailure(Call<SanPham> call, Throwable t) {

            }
        });
    }
}
package com.example.myapplication.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.ChiTietSanPhamActivity;
import com.example.myapplication.DangNhap;
import com.example.myapplication.QuanLy.QuanLyActivity;
import com.example.myapplication.R;
import com.example.myapplication.Until;
import com.example.myapplication.api.ApiService;
import com.example.myapplication.model.TaiKhoan;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends AbstractFragment {
    Button btnDangNhap;
    TextView tvTenTaiKhoan;
    LinearLayout llChuaDangNhap;
    LinearLayout llDaDangNhap;
    CardView cvDangXuat;
    CardView cvQuanLy;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentLayout = null;
        fragmentLayout = inflater.inflate(R.layout.profile_fragment, container, false);

        cvDangXuat = fragmentLayout.findViewById(R.id.cvDangXuat);
        cvQuanLy = fragmentLayout.findViewById(R.id.cvQuanLy);
        tvTenTaiKhoan = fragmentLayout.findViewById(R.id.tv_tenTK);
        btnDangNhap = fragmentLayout.findViewById(R.id.btn_dangNhap);
        llChuaDangNhap = fragmentLayout.findViewById(R.id.llChuaDangNhap);
        llDaDangNhap = fragmentLayout.findViewById(R.id.llDaDangNhap);

        kiemTraDangNhap();
    btnDangNhap.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            nextDangNhapActivity();
        }
    });

    cvQuanLy.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            nextQuanLyActivity();
        }
    });

    cvDangXuat.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Until.IDTAIKHOAN = 0;
            kiemTraDangNhap();
        }
    });

        return fragmentLayout;
    }

    private void nextDangNhapActivity()
    {
        Intent intent = new Intent(getActivity(), DangNhap.class);
        startActivity(intent);
    }

    private void nextQuanLyActivity()
    {
        Intent intent = new Intent(getActivity(), QuanLyActivity.class);
        startActivity(intent);
    }

    public void getTaiKhoan()
    {
        if(Until.IDTAIKHOAN != 0)
        {
            ApiService.apiService.getTaiKhoanById(Until.IDTAIKHOAN).enqueue(new Callback<TaiKhoan>() {
                @Override
                public void onResponse(Call<TaiKhoan> call, Response<TaiKhoan> response) {
                    TaiKhoan taiKhoan = response.body();
                    tvTenTaiKhoan.setText("Xin Chào " + taiKhoan.getTaiKhoan());
                    Until.ISADMIN = taiKhoan.getLoaiTaiKhoan();
                    if (Until.ISADMIN == 1)
                    {
                        cvQuanLy.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        cvQuanLy.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onFailure(Call<TaiKhoan> call, Throwable t) {

                }
            });
        }
    }

    public void kiemTraDangNhap()
    {

        if (Until.IDTAIKHOAN == 0)
        {
            llDaDangNhap.setVisibility(View.GONE);
            llChuaDangNhap.setVisibility(View.VISIBLE);
        }
        else
        {
            llChuaDangNhap.setVisibility(View.GONE);
            llDaDangNhap.setVisibility(View.VISIBLE);
        }
        getTaiKhoan();
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextDangNhapActivity();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        kiemTraDangNhap();
    }
}
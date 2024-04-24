package com.example.myapplication.model;

public class TaiKhoan {
    private int id;
    private String taiKhoan;
    private String matKhau;
    private int loaiTaiKhoan;

    public TaiKhoan(int id, String taiKhoan, String matKhau, int loaiTaiKhoan) {
        this.id = id;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.loaiTaiKhoan = loaiTaiKhoan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getLoaiTaiKhoan() {
        return loaiTaiKhoan;
    }

    public void setLoaiTaiKhoan(int loaiTaiKhoan) {
        this.loaiTaiKhoan = loaiTaiKhoan;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "id=" + id +
                ", taiKhoan='" + taiKhoan + '\'' +
                ", matKhau='" + matKhau + '\'' +
                ", loaiTaiKhoan=" + loaiTaiKhoan +
                '}';
    }
}

package com.example.myapplication.model;

public class SanPham {
    private int id;
    private String tenSanPham;
    private String hinhSanPham;
    private String moTaSanPham;
    private int giaSanPham;
    private int idDanhMuc;

    public SanPham(int id, String tenSanPham, String hinhSanPham, String moTaSanPham, int giaSanPham, int idDanhMuc) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.hinhSanPham = hinhSanPham;
        this.moTaSanPham = moTaSanPham;
        this.giaSanPham = giaSanPham;
        this.idDanhMuc = idDanhMuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getHinhSanPham() {
        return hinhSanPham;
    }

    public void setHinhSanPham(String hinhSanPham) {
        this.hinhSanPham = hinhSanPham;
    }

    public String getMoTaSanPham() {
        return moTaSanPham;
    }

    public void setMoTaSanPham(String moTaSanPham) {
        this.moTaSanPham = moTaSanPham;
    }

    public int getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(int giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public int getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(int idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "id=" + id +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", hinhSanPham='" + hinhSanPham + '\'' +
                ", moTaSanPham='" + moTaSanPham + '\'' +
                ", giaSanPham=" + giaSanPham +
                ", idDanhMuc=" + idDanhMuc +
                '}';
    }
}

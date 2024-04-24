package com.example.myapplication.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.Until;
import com.example.myapplication.model.SanPham;

import java.util.List;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.MyViewHolder>  {

    private Activity activity;
    private List<SanPham> list;
    private int layoutID;

    public SanPhamAdapter(Activity activity, List<SanPham> list, int layoutID) {
        this.activity = activity;
        this.list = list;
        this.layoutID = layoutID;
    }

    OnClickItemListener onClickItemListener;


    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        CardView view = (CardView) inflater.inflate(layoutID, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SanPham data =list.get(position);
        Glide.with(activity.getLayoutInflater().getContext()).load(list.get(position).getHinhSanPham()).into(holder.imgSanPham);
        holder.tenSanPham.setText(data.getTenSanPham());
        holder.giaSanPham.setText(String.valueOf(data.getGiaSanPham()));
        holder.onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemListener.onClickItem(position, v);
            }
        };
    }

    @Override
    public int getItemCount() {
        if(list==null){
            return 0;
        }
        return list.size();
    }

    public interface OnClickItemListener{
        void onClickItem(int position, View v);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgSanPham;
        TextView tenSanPham;
        TextView giaSanPham;

        View.OnClickListener onClickListener;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSanPham = itemView.findViewById(R.id.img_sanpham);
            tenSanPham = itemView.findViewById(R.id.ten_sanpham);
            giaSanPham = itemView.findViewById(R.id.gia_sanpham);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onClickListener.onClick(v);
        }
    }
}

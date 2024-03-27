package com.example.myapplication.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.DanhMuc;
import com.example.myapplication.model.SanPham;

import java.util.List;

public class DanhMucAdapter extends RecyclerView.Adapter<DanhMucAdapter.MyViewHolder> {

    private Activity activity;
    private List<DanhMuc> list;
    private int layoutID;

    OnClickItemListener onClickItemListener;

    public DanhMucAdapter(Activity activity, List<DanhMuc> list, int layoutID) {
        this.activity = activity;
        this.list = list;
        this.layoutID = layoutID;
    }

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        CardView view = (CardView) inflater.inflate(layoutID, parent,false);
        return new DanhMucAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DanhMuc data =list.get(position);
        holder.tenDanhMuc.setText(data.getTenDanhMuc());
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
        TextView tenDanhMuc;

        View.OnClickListener onClickListener;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tenDanhMuc = itemView.findViewById(R.id.ten_danhmuc);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onClickListener.onClick(v);
        }
    }
}

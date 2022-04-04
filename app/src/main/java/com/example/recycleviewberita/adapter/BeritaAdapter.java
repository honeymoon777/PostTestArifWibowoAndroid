package com.example.recycleviewberita.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recycleviewberita.R;
import com.example.recycleviewberita.model.BeritaModel;

import java.util.List;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder> {

    private List<BeritaModel> listBerita;
    private Context context;

    public BeritaAdapter(List<BeritaModel> listBerita, Context context) {
        this.listBerita = listBerita;
        this.context = context;
    }

    //untuk deklarasi layout item
    @NonNull
    @Override
    public BeritaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_layout,parent,false);
        return new BeritaViewHolder(view);
    }

    //untuk setting view seperti set text button onclick set image dan sebagainya
    @Override
    public void onBindViewHolder(@NonNull BeritaViewHolder holder, int position) {
        Glide.with(context).load(listBerita.get(position).getImages()).into(holder.imageBerita);
        holder.txtJudul.setText(listBerita.get(position).getJudul());
        holder.txtKategori.setText(listBerita.get(position).getKategori());
    }

    //IMPORTANT! jumlah looping dari LIST
    @Override
    public int getItemCount() {
        return listBerita.size();
    }

    //Kelas view holder yang berguna untuk menginialisasi kebutuhan didalam item layout
    public class BeritaViewHolder extends RecyclerView.ViewHolder{

        ImageView imageBerita;
        TextView txtJudul,txtBullet,txtKategori;

        public BeritaViewHolder(@NonNull View itemView) {
            super(itemView);
            imageBerita = itemView.findViewById(R.id.imageBerita);
            txtJudul = itemView.findViewById(R.id.txtJudul);
            txtBullet = itemView.findViewById(R.id.txtBullet);
            txtKategori = itemView.findViewById(R.id.txtKategori);
        }
    }
}
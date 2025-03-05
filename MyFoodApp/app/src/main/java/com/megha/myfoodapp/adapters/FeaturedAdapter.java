package com.megha.myfoodapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.megha.myfoodapp.R;
import com.megha.myfoodapp.models.FeaturedModel;

import java.util.List;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.ViewHolder> {

    List<FeaturedModel> list;

    public FeaturedAdapter(List<FeaturedModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public FeaturedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_hor_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedAdapter.ViewHolder holder, int position) {

        holder.img.setImageResource(list.get(position).getImg());
        holder.name.setText(list.get(position).getName());
        holder.desc.setText(list.get(position).getDesc());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView name,desc;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            img = itemView.findViewById(R.id.featured_img);
            name = itemView.findViewById(R.id.featured_name);
            desc = itemView.findViewById(R.id.featured_des);
        }
    }
}

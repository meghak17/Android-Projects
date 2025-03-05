package com.megha.myfoodapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.megha.myfoodapp.R;
import com.megha.myfoodapp.models.FeaturedVerModels;

import java.util.List;

public class FeaturedVerAdapter extends RecyclerView.Adapter<FeaturedVerAdapter.ViewHolder> {

    List<FeaturedVerModels> list;

    public FeaturedVerAdapter(List<FeaturedVerModels> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public FeaturedVerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_ver_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedVerAdapter.ViewHolder holder, int position) {

        holder.img.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.desc.setText(list.get(position).getDescription());
        holder.rating.setText(list.get(position).getRating());
        holder.timing.setText(list.get(position).getTiming());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name,desc,rating,timing;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            img = itemView.findViewById(R.id.detailed_img);
            name = itemView.findViewById(R.id.detailed_name);
            desc = itemView.findViewById(R.id.detailed_des);
            rating = itemView.findViewById(R.id.detailed_rating);
            timing = itemView.findViewById(R.id.detailed_timing);
        }
    }
}

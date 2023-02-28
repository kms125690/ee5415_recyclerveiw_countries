package com.example.recyclerveiwcountries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {
    Context c;
    ArrayList<Model> models;

    // Constructor of the MyAdapter Class
    public MyAdapter(Context c, ArrayList<Model> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // convert xml to view obj
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, null);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        //bind data to our views
        holder.mCountryName.setText(models.get(position).getCountryName());
        holder.mCountryArea.setText("The total Area :" + models.get(position).getCountryArea());
        holder.mImageFlag.setImageResource(models.get(position).getImage());
        // Animation
        Animation animation = AnimationUtils.loadAnimation(c, android.R.anim.slide_in_left);
        holder.itemView.startAnimation(animation);

        holder.mCountryArea.setText(models.get(position).getCountryArea());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}

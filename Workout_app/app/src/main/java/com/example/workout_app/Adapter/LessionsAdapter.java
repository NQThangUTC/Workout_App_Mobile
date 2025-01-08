package com.example.workout_app.Adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.workout_app.Domain.Lession;
import com.example.workout_app.databinding.ViewholderExcerciseBinding;
import com.example.workout_app.databinding.ViewholderWorkoutBinding;

import java.util.ArrayList;

public class LessionsAdapter extends RecyclerView.Adapter<LessionsAdapter.ViewHolder> {
    private final ArrayList<Lession> list;
    private Context context;

    public LessionsAdapter(ArrayList<Lession> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public LessionsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ViewholderExcerciseBinding binding = ViewholderExcerciseBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LessionsAdapter.ViewHolder holder, int position) {
        holder.binding.titleTxt.setText(list.get(position).getTitle());
        holder.binding.durationTxt.setText(list.get(position).getDuration());

        int resID = context.getResources().getIdentifier(list.get(position).getPicPath(), "drawable",context.getPackageName());
        Glide.with(context)
                .load(resID)
                .into(holder.binding.pic);
        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube"+list.get(position).getLink()));
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v="+list.get(position).getLink()));

                try{
                    context.startActivity(appIntent);
                }catch (ActivityNotFoundException ex){
                    context.startActivity(webIntent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ViewholderExcerciseBinding binding;
        public ViewHolder(ViewholderExcerciseBinding binding){
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}

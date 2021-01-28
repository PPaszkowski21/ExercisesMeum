package com.example.projektsm.ui.exercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projektsm.R;

import java.util.List;

public class AdapterAllExercises extends RecyclerView.Adapter<AdapterAllExercises.ViewHolder>
{
    Context context;
    public List<Exercise> exercises;
    public AdapterAllExercises(List<Exercise> exercises, Context context) {
        this.context = context;
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public AdapterAllExercises.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_exercise,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAllExercises.ViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);
        holder.Name.setText(exercise.Name);
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.singleExercise);
        }
    }
}

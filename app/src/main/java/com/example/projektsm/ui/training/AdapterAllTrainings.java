package com.example.projektsm.ui.training;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projektsm.R;
import com.example.projektsm.ui.exercise.Exercise;

import java.util.List;

public class AdapterAllTrainings extends RecyclerView.Adapter<AdapterAllTrainings.ViewHolder> {

    Context context;
    public List<Training> trainings;
    public List<Exercise> exercises;
    public AdapterAllTrainings(List<Exercise> exercises, List<Training> trainings, Context context) {
        this.context = context;
        this.trainings = trainings;
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public AdapterAllTrainings.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_training,parent,false);
        return new AdapterAllTrainings.ViewHolder(v);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull AdapterAllTrainings.ViewHolder holder, int position) {
        Training training = trainings.get(position);
        //Exercise exercise = exercises.get(training.ExerciseId);
        Exercise exercise = exercises.stream()
                .filter(exercise1 -> training.ExerciseId == exercise1.Id)
                .findAny()
                .orElse(null);
        holder.Name.setText(exercise.Name);
        holder.Score.setText(training.Score);
        holder.Date.setText(training.Date);
    }

    @Override
    public int getItemCount() {
        return trainings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Name, Score, Date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.singleTrainingName);
            Score = itemView.findViewById(R.id.singleTrainingScore);
            Date = itemView.findViewById(R.id.trainingDate);
        }
    }
}

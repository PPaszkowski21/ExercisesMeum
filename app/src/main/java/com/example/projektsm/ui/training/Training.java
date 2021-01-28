package com.example.projektsm.ui.training;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "trainings")
public class Training {

    public Training(int exerciseId, String score, String date) {
        ExerciseId = exerciseId;
        Score = score;
        Date = date;
    }

    public Training() {
    }

    @PrimaryKey(autoGenerate = true)
    public int Id;
    @ColumnInfo(name = "EXERCISE_ID")
    public int ExerciseId;
    @ColumnInfo(name = "SCORE")
    public String Score;
    @ColumnInfo(name = "DATE")
    public String Date;
}

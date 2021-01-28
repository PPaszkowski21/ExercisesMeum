package com.example.projektsm.ui;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.projektsm.ui.exercise.Exercise;
import com.example.projektsm.ui.exercise.ExerciseDao;
import com.example.projektsm.ui.training.Training;
import com.example.projektsm.ui.training.TrainingDao;

@Database(entities = {Exercise.class, Training.class}, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase
{
    private static RoomDB db;
    private static String DATABASE_NAME = "sportDB";

    public synchronized static RoomDB getInstance(Context context)
    {
        if (db == null)
        {
            db = Room.databaseBuilder(context.getApplicationContext(),RoomDB.class, DATABASE_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return db;
    }

    public abstract ExerciseDao exerciseDao();
    public abstract TrainingDao trainingDao();

}

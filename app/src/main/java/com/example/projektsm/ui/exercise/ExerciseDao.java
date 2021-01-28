package com.example.projektsm.ui.exercise;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface ExerciseDao {
    @Insert(onConflict = REPLACE)
    void insert(Exercise exercise);

    @Delete
    void delete(Exercise exercise);

    @Delete
    void reset(List<Exercise> exercises);

    @Query("SELECT * FROM exercises")
    List<Exercise> getAll();
}

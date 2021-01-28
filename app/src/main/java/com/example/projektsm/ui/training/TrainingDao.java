package com.example.projektsm.ui.training;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface TrainingDao {
    @Insert(onConflict = REPLACE)
    void insert(Training training);

    @Delete
    void delete(Training training);

    @Delete
    void reset(List<Training> trainings);


    @Query("SELECT * FROM trainings")
    List<Training> getAll();
}

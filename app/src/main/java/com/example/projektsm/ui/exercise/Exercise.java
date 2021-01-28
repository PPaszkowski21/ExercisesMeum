package com.example.projektsm.ui.exercise;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "exercises")
public class Exercise {

    @PrimaryKey(autoGenerate = true)
    public int Id;
    @ColumnInfo(name = "NAME")
    public String Name;

    public Exercise(String name) {
        Name = name;
    }

    public Exercise() {
    }
}

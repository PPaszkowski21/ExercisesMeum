package com.example.projektsm.ui.exercise;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projektsm.R;
import com.example.projektsm.ui.MainActivity;

import java.util.List;

public class ExerciseManagerFragment extends Fragment {

    private EditText editTextAddExercise;
    private Button buttonAddExercise;
    private RecyclerView recyclerViewExercises;
    private List<Exercise> exercises;
    public static AdapterAllExercises adapterAllExercises;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_exercise, container, false);
        editTextAddExercise = root.findViewById(R.id.editTextAddExercise);
        exercises = MainActivity.db.exerciseDao().getAll();
        adapterAllExercises = new AdapterAllExercises(exercises, getActivity());
        buttonAddExercise = root.findViewById(R.id.buttonAddExercise);
        buttonAddExercise.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!editTextAddExercise.getText().toString().isEmpty())
                {
                    MainActivity.db.exerciseDao().insert(new Exercise(editTextAddExercise.getText().toString()));
                    adapterAllExercises.exercises.add(new Exercise(editTextAddExercise.getText().toString()));
                    editTextAddExercise.setText("");
                    adapterAllExercises.notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(getContext(), getString(R.string.exerciseNameIsEmptyToast), Toast.LENGTH_LONG).show();
                }
            }
        });
        recyclerViewExercises = root.findViewById(R.id.exercisesRecycler);
        recyclerViewExercises.setAdapter(adapterAllExercises);
        recyclerViewExercises.setLayoutManager(new LinearLayoutManager((getActivity())));
        return root;
    }
}
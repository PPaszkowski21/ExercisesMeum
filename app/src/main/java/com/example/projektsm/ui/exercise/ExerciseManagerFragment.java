package com.example.projektsm.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.projektsm.R;

public class ExerciseManagerFragment extends Fragment {

    private TextView textViewAddExercise;
    private EditText editTextAddExercise;
    private Button buttonAddExercise;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_exercise, container, false);
        textViewAddExercise = root.findViewById(R.id.textAddExercise);
        editTextAddExercise = root.findViewById(R.id.editTextAddExercise);
        buttonAddExercise = root.findViewById(R.id.buttonAddExercise);
        buttonAddExercise.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                textViewAddExercise.setText("TEST");
            }
        });
        return root;
    }
}
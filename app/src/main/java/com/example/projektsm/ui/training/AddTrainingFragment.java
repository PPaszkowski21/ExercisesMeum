package com.example.projektsm.ui.training;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projektsm.R;
import com.example.projektsm.ui.MainActivity;
import com.example.projektsm.ui.exercise.Exercise;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AddTrainingFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private List<Exercise> exercises;
    private List<Training> trainings;
    private EditText editTextAddTraining;
    private Button buttonAddTraining;
    private Training trainingToAdd;
    private Integer exerciseId;
    private RecyclerView recyclerViewTrainings;
    public static AdapterAllTrainings adapterAllTrainings;
    public static Spinner dropdown;
    public static ArrayAdapter<String> adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_training, container, false);
        dropdown = root.findViewById(R.id.spinner1);
        dropdown.setEnabled(true);
        editTextAddTraining = root.findViewById(R.id.editTextAddScore);
        buttonAddTraining = root.findViewById(R.id.buttonAddTraining);
        buttonAddTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(exerciseId != null && !editTextAddTraining.getText().toString().isEmpty() && dropdown.isEnabled())
                {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                    Date date = new Date();
                    String tempDay = dateFormat.format(date);
                    trainingToAdd = new Training(exerciseId,editTextAddTraining.getText().toString(),tempDay);
                    MainActivity.db.trainingDao().insert(trainingToAdd);
                    adapterAllTrainings.trainings.add(trainingToAdd);
                    editTextAddTraining.setText("");
                    adapterAllTrainings.notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(getContext(), getString(R.string.trainingScoreIsEmptyToast), Toast.LENGTH_LONG).show();
                }
            }
        });
        trainings = MainActivity.db.trainingDao().getAll();
        exercises = MainActivity.db.exerciseDao().getAll();
        adapterAllTrainings = new AdapterAllTrainings(exercises,trainings,getActivity());
        exerciseId = null;
        String[] items = new String[exercises.size()];
        for (int i = 0; i < exercises.size(); i++)
        {
            items[i] = exercises.get(i).Name;
        }
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);

        recyclerViewTrainings = root.findViewById(R.id.trainingRecycler);
        recyclerViewTrainings.setAdapter(adapterAllTrainings);
        recyclerViewTrainings.setLayoutManager(new LinearLayoutManager((getActivity())));

        return root;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        exerciseId = exercises.get(position).Id;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
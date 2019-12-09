package com.example.cula_mobile.module.sub_task;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import com.example.cula_mobile.R;
import com.example.cula_mobile.module.detail_task.DetailTaskFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateSubtaskFragment extends Fragment implements ICreateSubtask {
    private View view;
    private int idTask;
    private Button btnSubmit;
    private ProgressBar progressBar;
    private CreateSubtaskPresenter createSubtaskPresenter;
    private EditText subtaskName, dueDate;


    public CreateSubtaskFragment(int idTask) {
        // Required empty public constructor
        this.idTask = idTask;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_create_subtask, container, false);
        createSubtaskPresenter = new CreateSubtaskPresenter(this);

        progressBar = view.findViewById(R.id.progressBarCreateSubTask);
        progressBar.setVisibility(View.GONE);

        subtaskName = view.findViewById(R.id.addSubTask);
        dueDate = view.findViewById(R.id.addDateOfSubtask);

        btnSubmit = view.findViewById(R.id.buttonSave);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);

                createSubtaskPresenter.createSubtask(idTask, subtaskName.getText().toString(),
                                                    dueDate.getText().toString());
            }
        });

        return view;
    }

    @Override
    public void backToDetailTask() {
        progressBar.setVisibility(View.GONE);
        Fragment fragment = new DetailTaskFragment(idTask);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}

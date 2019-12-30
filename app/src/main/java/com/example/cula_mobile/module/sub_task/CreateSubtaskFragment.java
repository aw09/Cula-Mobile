package com.example.cula_mobile.module.sub_task;


import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.cula_mobile.R;
import com.example.cula_mobile.module.detail_task.DetailTaskFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

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
    private TextView txtChooseDate;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;

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
        //dueDate = view.findViewById(R.id.addDateOfSubtask);
        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        txtChooseDate = view.findViewById(R.id.txtChooseDate);
        btnSubmit = view.findViewById(R.id.buttonSave);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);

                createSubtaskPresenter.createSubtask(idTask, subtaskName.getText().toString(),
                        txtChooseDate.getText().toString());
                                                    //dueDate.getText().toString());
            }
        });

        txtChooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });

        return view;
    }

    private void showDateDialog() {
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this.view.getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int day, int month, int year) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(day, month, year);

                txtChooseDate.setText(dateFormatter.format(newDate.getTime()));

            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
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

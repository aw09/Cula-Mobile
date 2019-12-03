package com.example.cula_mobile.module.detail_task;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cula_mobile.R;
import com.example.cula_mobile.model.Subtask;
import com.example.cula_mobile.model.Task;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailTaskFragment extends Fragment implements IDetailTaskView{
    private int idTask;
    private View view;
    private DetailTaskPresenter detailTaskPresenter;
    private TextView txtDescription, txtDueDate;

    public DetailTaskFragment(int idTask) {
        // Required empty public constructor
        this.idTask = idTask;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity_detail_task_2, container, false);
        detailTaskPresenter = new DetailTaskPresenter(this);
        detailTaskPresenter.getDetailTask(idTask);
        return view;
    }

    @Override
    public void showDetailTask(Task task) {

    }

    @Override
    public void showSubtask(ArrayList<Subtask> subtasks) {

    }
}

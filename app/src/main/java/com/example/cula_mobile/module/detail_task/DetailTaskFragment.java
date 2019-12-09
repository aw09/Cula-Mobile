package com.example.cula_mobile.module.detail_task;


import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.cula_mobile.R;
import com.example.cula_mobile.model.Comment;
import com.example.cula_mobile.model.Subtask;
import com.example.cula_mobile.model.response.ResponseDetailTask;
import com.example.cula_mobile.module.sub_task.CreateSubtaskFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailTaskFragment extends Fragment implements IDetailTaskView{
    private int idTask;
    private View view;
    private DetailTaskPresenter detailTaskPresenter;
    private TextView txtDescription, txtDueDate, txtInfo;
    private ImageButton btnAddSubtask;

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

        setStatus();

        btnAddSubtask = (ImageButton) view.findViewById(R.id.btnAddSubtask);
        btnAddSubtask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToCreateSubtask();
            }
        });

        return view;
    }

    @Override
    public void showDetailTask(ResponseDetailTask task) {
        txtDescription = (TextView) view.findViewById(R.id.txtDescription);
        txtDueDate = (TextView) view.findViewById(R.id.txtDueDate);

        txtDescription.setText(task.getDetailTask());
        txtDueDate.setText(task.getDueDate());
    }

    @Override
    public void showSubtask(ArrayList<Subtask> subtasks) {
        RecyclerView recyclerView;
        recyclerView = (RecyclerView) view.findViewById(R.id.listSubtask);
        SubTaskAdapter subTaskAdapter = new SubTaskAdapter(subtasks, getContext());
        recyclerView.setAdapter(subTaskAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void showComment(ArrayList<Comment> comments) {
        RecyclerView recyclerView;
        recyclerView = (RecyclerView) view.findViewById(R.id.comment);
        CommentAdapter commentAdapter = new CommentAdapter(comments, getContext());
        recyclerView.setAdapter(commentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void showTaskTitle(String taskTitle) {
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setTitle(taskTitle);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void setStatus() {
        String[] status = {"To Do", "On progress", "Done"};
        Spinner spinner = (Spinner) view.findViewById(R.id.spinnerStatus);
        spinner.setAdapter(new StatusAdapter(getContext(), R.layout.item_status, status));
    }

    private void moveToCreateSubtask() {
        Fragment fragment = new CreateSubtaskFragment(idTask);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_layout_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}

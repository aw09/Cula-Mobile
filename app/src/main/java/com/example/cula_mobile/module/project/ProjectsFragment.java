package com.example.cula_mobile.module.project;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cula_mobile.R;
import com.example.cula_mobile.model.Project;

import java.util.ArrayList;

import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectsFragment extends Fragment implements IProjectView {
    ProjectPresenter projectPresenter;
    private RecyclerView recyclerView;
    private ProjectAdapter projectAdapter;
    private ArrayList<Project> projects;
    private View view;

    public ProjectsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_projects, container, false);
        projectPresenter = new ProjectPresenter(this);
        projectPresenter.getMyProject();

        return view;
    }

    @Override
    public void showProjectList(ArrayList<Project> projects) {
        recyclerView = (RecyclerView) view.findViewById(R.id.listProject);
        projectAdapter = new ProjectAdapter(projects, getContext());
        Log.e("lele", projects.size()+"");

        recyclerView.setAdapter(projectAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}

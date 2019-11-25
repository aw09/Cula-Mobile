package com.example.cula_mobile.module.project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cula_mobile.R;
import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
import com.example.cula_mobile.model.Project;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProjectAdapter projectAdapter;
    private ArrayList<Project> projects;

    protected void OnCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_projects);
        /*IApiEndpoint endpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);
        Call<Project> callProject = endpoint.myProject("Test");
        callProject.enqueue(new Callback<Project>() {
            @Override
            public void onResponse(Call<Project> call, Response<Project> response) {
                recyclerView = (RecyclerView) findViewById(R.id.listProject);
                projectAdapter = new ProjectAdapter(projects, ProjectActivity.this);

                recyclerView.setAdapter(projectAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(ProjectActivity.this));
            }

            @Override
            public void onFailure(Call<Project> call, Throwable t) {

            }
        });
*/
    }
}

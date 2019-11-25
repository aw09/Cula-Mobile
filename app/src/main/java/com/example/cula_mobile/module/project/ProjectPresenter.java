package com.example.cula_mobile.module.project;

import android.util.Log;

import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
import com.example.cula_mobile.model.Project;
import com.example.cula_mobile.utils.SharedPreferenceUtils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectPresenter {
    IProjectView view;

    public ProjectPresenter(IProjectView view) {
        this.view = view;
    }

    public void getMyProject() {
        IApiEndpoint endpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);
        Call<ArrayList<Project>> callProject = endpoint.myProject(SharedPreferenceUtils.getStringSharedPreferences("token", "yeay"));
        callProject.enqueue(new Callback<ArrayList<Project>>() {
            @Override
            public void onResponse(Call<ArrayList<Project>> call, Response<ArrayList<Project>> response) {
                view.showProjectList(response.body());
                Log.e("lele", "yuhu");
            }

            @Override
            public void onFailure(Call<ArrayList<Project>> call, Throwable t) {
                Log.e("lele", call.request().toString());
            }
        });
    }
}

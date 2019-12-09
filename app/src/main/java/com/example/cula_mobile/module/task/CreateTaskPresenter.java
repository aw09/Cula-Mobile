package com.example.cula_mobile.module.task;

import android.util.Log;

import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
import com.example.cula_mobile.model.response.ResponseCreateTask;
import com.example.cula_mobile.model.response.ResponseLogin;
import com.example.cula_mobile.utils.SharedPreferenceUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateTaskPresenter {
    ICreateTaskView view;
    ResponseCreateTask task = new ResponseCreateTask();

    public CreateTaskPresenter(ICreateTaskView view) {
        this.view = view;
    }

    public void createTask(int idCard, String taskName, String description, String dueDate) {
        Log.e("oppa", idCard + "");
        String token = SharedPreferenceUtils.getStringSharedPreferences("token", 0+"");
        IApiEndpoint endpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);
        endpoint.createTask(token, idCard, taskName, description, dueDate).enqueue(new Callback<ResponseCreateTask>() {
            @Override
            public void onResponse(Call<ResponseCreateTask> call, Response<ResponseCreateTask> response) {
                task.setIdCard(idCard);
                task.setTaskName(response.body().getTaskName());
                task.setDetailTask(response.body().getDetailTask());
                task.setDue_date(response.body().getDue_date());
                view.backToCard();
            }

            @Override
            public void onFailure(Call<ResponseCreateTask> call, Throwable t) {
                Log.e("lele", t.getMessage());
            }
        });
    }
}

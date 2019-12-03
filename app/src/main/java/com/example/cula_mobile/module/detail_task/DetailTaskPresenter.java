package com.example.cula_mobile.module.detail_task;

import android.util.Log;

import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
import com.example.cula_mobile.model.Task;
import com.example.cula_mobile.utils.SharedPreferenceUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailTaskPresenter {
    IDetailTaskView view;

    public DetailTaskPresenter(IDetailTaskView view) {
        this.view = view;
    }

    public void getDetailTask(int idTask) {
        IApiEndpoint endpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);
        Call<Task> callTask = endpoint.detailTask(SharedPreferenceUtils
                .getStringSharedPreferences("token", "detailTask"), idTask);
        callTask.enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {

            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                Log.e("koi", t.getMessage());
            }
        });
    }
}

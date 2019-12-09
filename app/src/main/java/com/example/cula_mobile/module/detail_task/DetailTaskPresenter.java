package com.example.cula_mobile.module.detail_task;

import android.util.Log;

import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
import com.example.cula_mobile.model.response.ResponseDetailTask;
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
        Log.e("koi", idTask + "");
        IApiEndpoint endpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);
        Call<ResponseDetailTask> detailTaskCall = endpoint.detailTask(SharedPreferenceUtils
                .getStringSharedPreferences("token", "detailTask"), idTask);
        detailTaskCall.enqueue(new Callback<ResponseDetailTask>() {
            @Override
            public void onResponse(Call<ResponseDetailTask> call, Response<ResponseDetailTask> response) {
                if (response.isSuccessful()) {
                    Log.e("koi", response.code() + "");
                    view.showDetailTask(response.body());
                    view.showSubtask(response.body().getSubtasks());
                    view.showComment(response.body().getComments());
                    view.showTaskTitle(response.body().getTaskName());
                } else {
                    Log.e("koi", "not success");
                }
            }

            @Override
            public void onFailure(Call<ResponseDetailTask> call, Throwable t) {
                Log.e("koi", t.toString());
            }
        });
    }
}

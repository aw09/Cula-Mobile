package com.example.cula_mobile.module.sub_task;

import android.util.Log;

import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
import com.example.cula_mobile.model.Subtask;
import com.example.cula_mobile.utils.SharedPreferenceUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateSubtaskPresenter {
    private ICreateSubtask view;
    private Subtask subtask = new Subtask();

    public CreateSubtaskPresenter(ICreateSubtask view) {
        this.view = view;
    }

    public void createSubtask(int idTask, String name, String dueDate) {
        Log.e("arwana", idTask + "");
        IApiEndpoint endpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);
        String token = SharedPreferenceUtils.getStringSharedPreferences("token", "subTask");
        Call<Subtask> subtaskCall = endpoint.createSubtask(token, idTask, name, dueDate);
        subtaskCall.enqueue(new Callback<Subtask>() {
            @Override
            public void onResponse(Call<Subtask> call, Response<Subtask> response) {
                if (response.isSuccessful()) {
                    Log.e("arwana", response.code() + "");
                    subtask.setIdTask(idTask);
                    subtask.setSubTaskName(response.body().getSubTaskName());
                    subtask.setDueDate(response.body().getDueDate());
                } else {
                    Log.e("arwana", "tidak sukses");
                }
            }

            @Override
            public void onFailure(Call<Subtask> call, Throwable t) {
                Log.e("arwana", t.toString());
            }
        });
    }
}

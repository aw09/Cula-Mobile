package com.example.cula_mobile.module.mytask;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cula_mobile.R;
import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
import com.example.cula_mobile.model.Task;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyTaskPresenter {
    IMyTaskView view;

    public MyTaskPresenter(IMyTaskView view) {
        this.view = view;
    }

    public void getMyCardList() {
        IApiEndpoint endpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);
        Call<Task> callTask = endpoint.myTask("hehehe");
        callTask.enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {
                view.showMyCardList();
            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {

            }
        });
    }
}

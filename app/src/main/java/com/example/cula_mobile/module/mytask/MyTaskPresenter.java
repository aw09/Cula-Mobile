package com.example.cula_mobile.module.mytask;

import android.util.Log;
import com.example.cula_mobile.R;
import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
import com.example.cula_mobile.model.Task;
import com.example.cula_mobile.model.response.ResponseMyTask;
import com.example.cula_mobile.utils.SharedPreferenceUtils;
import java.util.ArrayList;
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
        Call<ArrayList<Task>> callTask = endpoint.myTask(SharedPreferenceUtils
                                    .getStringSharedPreferences("token", "myTask"));
        Log.e("errorMyTask", callTask.toString());
        callTask.enqueue(new Callback<ArrayList<Task>>() {
            @Override
            public void onResponse(Call<ArrayList<Task>> call, Response<ArrayList<Task>> response) {
                view.showMyCardList(response.body());
                Log.e("faizfaiz", response+"");
            }

            @Override
            public void onFailure(Call<ArrayList<Task>> call, Throwable t) {
                Log.e("FAILURE", t.toString());
            }
        });
    }
}

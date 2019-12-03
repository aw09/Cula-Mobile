package com.example.cula_mobile.module.mytask;

import android.util.Log;
import com.example.cula_mobile.R;
import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
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
        Call<ArrayList<ResponseMyTask>> callTask = endpoint.myTask(SharedPreferenceUtils
                                    .getStringSharedPreferences("token", "myTask"));
        callTask.enqueue(new Callback<ArrayList<ResponseMyTask>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseMyTask>> call, Response<ArrayList<ResponseMyTask>> response) {
                if (response.isSuccessful()) {
                    view.showMyCardList(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ResponseMyTask>> call, Throwable t) {
                Log.e("not response", "The server is not responding");
            }
        });
    }
}

package com.example.cula_mobile.module.login;

import android.content.Intent;
import android.util.Log;

import com.example.cula_mobile.MainActivity;
import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
import com.example.cula_mobile.model.response.ResponseLogin;
import com.example.cula_mobile.module.mytask.MyTaskActivity;
import com.example.cula_mobile.utils.SharedPreferenceUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    private static final String BEARER_TOKEN_PREFIX = "Bearer ";
    private ILoginView view;
    private String token;
    private SharedPreferenceUtils sharedPreferenceUtils;

    public LoginPresenter(ILoginView view) {
        this.view = view;
    }

    public void doLogin(String email, String password) {

        IApiEndpoint apiEndpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);

        apiEndpoint.login(email, password).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                token = response.body().getToken();
                SharedPreferenceUtils.setStringSharedPreferences("token", token);
                // TODO: 19/11/2019 preference logic

            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Log.e("onFailure: ", t.getMessage());

            }
        });
    }
}

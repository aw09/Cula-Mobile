package com.example.cula_mobile.module.profile;

import android.util.Log;

import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
import com.example.cula_mobile.model.User;
import com.example.cula_mobile.model.response.ResponseLogout;
import com.example.cula_mobile.utils.SharedPreferenceUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilePresenter {
    IProfileView view;
    IApiEndpoint apiEndpoint;

    public ProfilePresenter(IProfileView view) {
        this.view = view;
        apiEndpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);
    }

    public void getUserProfile() {
        Call<User> callUser = apiEndpoint.getUser(SharedPreferenceUtils
                                .getStringSharedPreferences("token", "user"));
        callUser.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    view.showUserProfileData(response.body().getUser());
                } else {
                    Log.e("dugong", response.code() + "");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("dugong", t.getMessage());
            }
        });
    }

    public void doLogout() {
        Call<ResponseLogout> call = apiEndpoint.logout(SharedPreferenceUtils
                .getStringSharedPreferences("token", "logout"));
        call.enqueue(new Callback<ResponseLogout>() {
            @Override
            public void onResponse(Call<ResponseLogout> call, Response<ResponseLogout> response) {
                if (response.isSuccessful()) {
                    view.showMessageLogout(response.body().getMessage());
                } else {
                    Log.e("dawet", "unsuccess");
                }
            }

            @Override
            public void onFailure(Call<ResponseLogout> call, Throwable t) {
                Log.e("dawet", t.toString());
            }
        });
    }
}

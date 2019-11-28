package com.example.cula_mobile.module.profile;

import android.util.Log;

import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
import com.example.cula_mobile.model.User;
import com.example.cula_mobile.utils.SharedPreferenceUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilePresenter {
    IProfileView view;

    public ProfilePresenter(IProfileView view) {
        this.view = view;
    }

    public void getUserProfile() {
        IApiEndpoint apiEndpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);
        Call<User> callUser = apiEndpoint.getUser(SharedPreferenceUtils
                                .getStringSharedPreferences("token", "user"));
        callUser.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.e("profile", "");
                view.showUserProfileData(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("profile", t.getMessage());
            }
        });

    }
}

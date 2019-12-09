package com.example.cula_mobile.module.login;
import android.util.Log;
import android.widget.Toast;

import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
import com.example.cula_mobile.model.response.ResponseLogin;
import com.example.cula_mobile.utils.SharedPreferenceUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {;
    private ILoginView view;
    private String token;

    public LoginPresenter(ILoginView view) {
        this.view = view;
    }

    public void doLogin(String email, String password) {

        IApiEndpoint apiEndpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);

        apiEndpoint.login(email, password).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if (response.isSuccessful()) {
                    token = "Bearer " + response.body().getToken();
                    view.moveToMyTask();
                    SharedPreferenceUtils.setStringSharedPreferences("token", token);
                    Log.e("tokenBerhasil", SharedPreferenceUtils.getStringSharedPreferences("token", token));
                } else {
                    Log.e("lele", "not success");
                    view.showInformation();
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Log.e("not response", t.toString());
                view.showInformation();
            }
        });
    }
}

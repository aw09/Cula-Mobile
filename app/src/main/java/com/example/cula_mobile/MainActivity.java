package com.example.cula_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
import com.example.cula_mobile.model.response.ResponseLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private String token;
    Button btnLogin;
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = (Button) findViewById(R.id.login);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IApiEndpoint apiEndpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);

                apiEndpoint.login(email.getText().toString(), password.getText().toString()).enqueue(new Callback<ResponseLogin>() {
                    @Override
                    public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                        token = response.body().getToken();
                        // TODO: 19/11/2019 preference logic

                    }

                    @Override
                    public void onFailure(Call<ResponseLogin> call, Throwable t) {
                        Log.e("onFailure: ", "Errorrrr");
                    }
                });
            }
        });


    }
}

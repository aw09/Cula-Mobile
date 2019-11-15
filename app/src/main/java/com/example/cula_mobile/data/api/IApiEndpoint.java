package com.example.cula_mobile.data.api;

import com.example.cula_mobile.model.Task;
import com.example.cula_mobile.model.response.ResponseLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface IApiEndpoint {
    @FormUrlEncoded
    @POST("login")
    Call<ResponseLogin> login (
        @Field("email") String emailUser,
        @Field("password") String passwordUser
    );

    @GET("myTask")
    Call<Task> myTask(
            @Header("Authorization") String header
    );
}

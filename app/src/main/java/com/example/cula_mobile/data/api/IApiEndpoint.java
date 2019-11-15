package com.example.cula_mobile.data.api;

import com.example.cula_mobile.model.response.ResponseLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IApiEndpoint {
    @FormUrlEncoded
    @POST("login")
    Call<ResponseLogin> login (
        @Field("email") String emailUser,
        @Field("password") String passwordUser
    );
}

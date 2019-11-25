package com.example.cula_mobile.data.api;

import com.example.cula_mobile.model.Board;
import com.example.cula_mobile.model.Card;
import com.example.cula_mobile.model.Project;
import com.example.cula_mobile.model.Task;
import com.example.cula_mobile.model.response.ResponseLogin;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IApiEndpoint {
    @FormUrlEncoded
    @POST("login")
    Call<ResponseLogin> login (
        @Field("email") String emailUser,
        @Field("password") String passwordUser
    );

    @GET("myTask")
    Call<ArrayList<Task>> myTask(
            @Header("Authorization") String header
    );

    @GET("myProject")
    Call<ArrayList<Project>> myProject(
            @Header("Authorization") String header
    );

    @GET("show-project/{id}")
    Call<ArrayList<Board>> showProject(
            @Header("Authorization") String header,
            @Path("id") int id
    );

    @GET("board/{id")
    Call<ArrayList<Card>> showBoard(
            @Header("Authorization") String header,
            @Path("id") int id
    );
}

package com.example.cula_mobile.data.api;

import com.example.cula_mobile.model.Board;
import com.example.cula_mobile.model.Card;
import com.example.cula_mobile.model.Comment;
import com.example.cula_mobile.model.Project;
import com.example.cula_mobile.model.Subtask;
import com.example.cula_mobile.model.Task;
import com.example.cula_mobile.model.User;
import com.example.cula_mobile.model.response.ResponseBoard;
import com.example.cula_mobile.model.response.ResponseCreateTask;
import com.example.cula_mobile.model.response.ResponseDetailTask;
import com.example.cula_mobile.model.response.ResponseLogin;
import com.example.cula_mobile.model.response.ResponseMyTask;

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

    @GET("project/{id}")
    Call<ResponseBoard> showProject(
            @Header("Authorization") String header,
            @Path("id") int id
    );

    @GET("board/{id}")
    Call<Board> showBoard(
            @Header("Authorization") String header,
            @Path("id") int id
    );

    @GET("get-user")
    Call<User> getUser(
          @Header("Authorization") String header
    );

    @FormUrlEncoded
    @POST("task")
    Call<ResponseCreateTask> createTask(
            @Header("Authorization") String header,
            @Field("id_card") int idCard,
            @Field("task") String taskName,
            @Field("description_of_task") String description,
            @Field("due_date") String dueDate
    );

    @GET("task/{id}")
    Call<ResponseDetailTask> detailTask(
            @Header("Authorization") String header,
            @Path("id") int id
    );

    @FormUrlEncoded
    @POST("checklist")
    Call<Subtask> createSubtask(
            @Header("Authorization") String header,
            @Field("id_task") int idTask,
            @Field("check_list") String subtaskName,
            @Field("due_date") String dueDate
    );

    @FormUrlEncoded
    @POST("comment")
    Call<Comment> addComment(
            @Header("Authorization") String header,
            @Field("comment") String comment,
            @Field("id_task") int idTask,
            @Field("id_user") int idUser
    );
}

package com.example.cula_mobile.module.detail_task;

import android.util.Log;

import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
import com.example.cula_mobile.model.Comment;
import com.example.cula_mobile.model.response.ResponseDetailTask;
import com.example.cula_mobile.utils.SharedPreferenceUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailTaskPresenter {
    IDetailTaskView view;
    private int idTask;
    private Comment comment = new Comment();
    private IApiEndpoint endpoint;

    public DetailTaskPresenter(IDetailTaskView view, int idTask) {
        this.view = view;
        this.idTask = idTask;
        this.endpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);
    }

    public void getDetailTask() {
        Log.e("koi", idTask + "");
        Call<ResponseDetailTask> detailTaskCall = endpoint.detailTask(SharedPreferenceUtils
                .getStringSharedPreferences("token", "detailTask"), idTask);
        detailTaskCall.enqueue(new Callback<ResponseDetailTask>() {
            @Override
            public void onResponse(Call<ResponseDetailTask> call, Response<ResponseDetailTask> response) {
                if (response.isSuccessful()) {
                    Log.e("koi", response.code() + "");
                    view.showDetailTask(response.body());
                    view.showLabel(response.body().getLabel());
                    view.showSubtask(response.body().getSubtasks());
                    view.showComment(response.body().getComments());
                    view.showTaskTitle(response.body().getTaskName());
                } else {
                    Log.e("koi", "not success");
                }
            }

            @Override
            public void onFailure(Call<ResponseDetailTask> call, Throwable t) {
                Log.e("koi", t.toString());
            }
        });
    }

    public void addComment(String content) {
        String token = SharedPreferenceUtils.getStringSharedPreferences("token", "comment");
        int idUser = SharedPreferenceUtils.getIntSharedPreferences("idUser", 0);
        Log.e("koiComment", idUser + "");
        Call<Comment> commentCall = endpoint.addComment(token, content, idTask, idUser);
        commentCall.enqueue(new Callback<Comment>() {
            @Override
            public void onResponse(Call<Comment> call, Response<Comment> response) {
                Log.e("koiComment", response.code()+"");
                if (response.isSuccessful()) {
                    comment.setComment(response.body().getComment());
                    comment.setIdTask(response.body().getIdTask());
                    comment.setIdUser(response.body().getIdUser());
                    view.reload();
                } else {
                    Log.e("koiComment", "unsuccess");
                }
            }

            @Override
            public void onFailure(Call<Comment> call, Throwable t) {
                Log.e("koiComment", t.toString());
            }
        });
    }
}

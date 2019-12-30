package com.example.cula_mobile.module.board;

import android.util.Log;

import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
import com.example.cula_mobile.model.Board;
import com.example.cula_mobile.model.response.ResponseBoard;
import com.example.cula_mobile.utils.SharedPreferenceUtils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BoardPresenter {
    IBoardView view;
    private String token;

    public BoardPresenter(IBoardView view) {
        this.view = view;
    }

    public void getBoardList(int idProject) {
        Log.e("lele", idProject+"");
        IApiEndpoint endpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);
        token = SharedPreferenceUtils.getStringSharedPreferences("token", "board");
        Call<ResponseBoard> boardCall = endpoint.showProject(token, idProject);
        boardCall.enqueue(new Callback<ResponseBoard>() {
            @Override
            public void onResponse(Call<ResponseBoard> call, Response<ResponseBoard> response) {
                if (response.isSuccessful()) {
                    Log.e("lele", response.code()+"");
                    view.showBoardList(response.body().getBoards());
                    view.showProjectName(response.body().getProjectName());
                } else {
                    Log.e("lele", "not success");
                }
            }

            @Override
            public void onFailure(Call<ResponseBoard> call, Throwable t) {
                Log.e("boardfail", t.getMessage());
            }
        });
    }
}

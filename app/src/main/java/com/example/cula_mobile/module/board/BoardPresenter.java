package com.example.cula_mobile.module.board;

import android.util.Log;

import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
import com.example.cula_mobile.model.Board;
import com.example.cula_mobile.utils.SharedPreferenceUtils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BoardPresenter {
    IBoardView view;

    public BoardPresenter(IBoardView view) {
        this.view = view;
    }

    public void getBoardList(int idProject) {
        Log.e("lele", idProject+"");
        IApiEndpoint endpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);
        Call<ArrayList<Board>> callBoard = endpoint.showProject(SharedPreferenceUtils
                                .getStringSharedPreferences("token", "wew"),
                                idProject);
        callBoard.enqueue(new Callback<ArrayList<Board>>() {
            @Override
            public void onResponse(Call<ArrayList<Board>> call, Response<ArrayList<Board>> response) {
                Log.e("lele", "hore");
                view.showBoardList(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Board>> call, Throwable t) {
                Log.e("lele", t.getMessage());
            }
        });
    }
}

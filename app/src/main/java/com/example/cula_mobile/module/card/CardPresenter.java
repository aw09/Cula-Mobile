package com.example.cula_mobile.module.card;

import android.util.Log;

import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
import com.example.cula_mobile.model.Board;
import com.example.cula_mobile.model.Card;
import com.example.cula_mobile.model.response.ResponseBoard;
import com.example.cula_mobile.utils.SharedPreferenceUtils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CardPresenter {
    ICardView view;

    public CardPresenter(ICardView view) {
        this.view = view;
    }

    public void getCardList(int idBoard) {
        Log.e("bandeng", idBoard+"");
        IApiEndpoint endpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);
        String token = SharedPreferenceUtils.getStringSharedPreferences("token", "card");
        Call<Board> boardCall = endpoint.showBoard(token, idBoard);
        boardCall.enqueue(new Callback<Board>() {
            @Override
            public void onResponse(Call<Board> call, Response<Board> response) {
                Log.e("edyrib", response.body()+"");
                if (response.isSuccessful()) {
                    if (response.body().getCards().size() == 0) {
                        view.showInformation();
                    } else {
                        view.showCardList(response.body().getCards());
                        view.showTitle(response.body().getBoardName());
                    }
                } else {
                    Log.e("edyribawah", response.code()+"");
                }
            }

            @Override
            public void onFailure(Call<Board> call, Throwable t) {
                Log.e("edyribgagal", t.toString());
            }
        });
    }
}

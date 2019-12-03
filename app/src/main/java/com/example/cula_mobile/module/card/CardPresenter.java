package com.example.cula_mobile.module.card;

import android.util.Log;

import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
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
        Call<ResponseBoard> callCard = endpoint.showBoard(SharedPreferenceUtils
                        .getStringSharedPreferences("token", "card"), idBoard);

        callCard.enqueue(new Callback<ResponseBoard>() {
            @Override
            public void onResponse(Call<ResponseBoard> call, Response<ResponseBoard> response) {
                Log.e("edyrib", response.body()+"");
                if (response.isSuccessful()) {
                    view.showCardList(response.body().getListCard());
                    view.showTitle(response.body().getBoardName());

                } else {
                    Log.e("bandeng", response.code()+"");
                }
            }

            @Override
            public void onFailure(Call<ResponseBoard> call, Throwable t) {
                Log.e("bandengbau", t.toString());
            }
        });
    }
}

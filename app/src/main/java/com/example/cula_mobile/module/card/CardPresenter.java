package com.example.cula_mobile.module.card;

import android.util.Log;

import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
import com.example.cula_mobile.model.Card;

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
        IApiEndpoint endpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);
        Call<ArrayList<Card>> callCard = endpoint.showBoard("token", idBoard);
        callCard.enqueue(new Callback<ArrayList<Card>>() {
            @Override
            public void onResponse(Call<ArrayList<Card>> call, Response<ArrayList<Card>> response) {
                view.showCardList(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Card>> call, Throwable t) {

            }
        });
    }
}

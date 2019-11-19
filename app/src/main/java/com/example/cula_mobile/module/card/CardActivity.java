package com.example.cula_mobile.module.card;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cula_mobile.R;
import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
import com.example.cula_mobile.model.Card;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CardActivity extends AppCompatActivity {
    private int idBoard;
    private RecyclerView recyclerView;
    private CardAdapter cardAdapter;
    private ArrayList<Card> listCards;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        idBoard = getIntent().getIntExtra("idBoard", 0);
        IApiEndpoint endpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);
        Call<Card> callCard = endpoint.showBoard("token", idBoard);
        callCard.enqueue(new Callback<Card>() {
            @Override
            public void onResponse(Call<Card> call, Response<Card> response) {
                recyclerView = (RecyclerView) findViewById(R.id.listCard);
                cardAdapter = new CardAdapter(listCards, CardActivity.this);

                recyclerView.setAdapter(cardAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(CardActivity.this,
                        LinearLayoutManager.HORIZONTAL, false));
            }

            @Override
            public void onFailure(Call<Card> call, Throwable t) {

            }
        });
    }
}

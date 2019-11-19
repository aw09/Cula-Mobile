package com.example.cula_mobile.module.board;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cula_mobile.R;
import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
import com.example.cula_mobile.model.Board;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BoardActivity extends AppCompatActivity {
    private int idProject;
    private RecyclerView recyclerView;
    private BoardAdapter boardAdapter;
    private ArrayList<Board> boards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        idProject = getIntent().getIntExtra("idProject", 0);
        IApiEndpoint endpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);
        Call<Board> callBoard = endpoint.showProject("Test", idProject);
        callBoard.enqueue(new Callback<Board>() {
            @Override
            public void onResponse(Call<Board> call, Response<Board> response) {
                recyclerView = (RecyclerView) findViewById(R.id.listBoard);
                boardAdapter = new BoardAdapter(boards, BoardActivity.this);

                recyclerView.setAdapter(boardAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(BoardActivity.this));
            }

            @Override
            public void onFailure(Call<Board> call, Throwable t) {

            }
        });
    }
}

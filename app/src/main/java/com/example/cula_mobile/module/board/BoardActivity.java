package com.example.cula_mobile.module.board;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
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
    private BoardPresenter boardPresenter;
    private RecyclerView recyclerView;
    private BoardAdapter boardAdapter;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        int idProject = getIntent().getIntExtra("idProject", 0);

        //boardPresenter = new BoardPresenter(this);
        //boardPresenter.getBoardList(idProject);


    }
//
//    @Override
//    public void showBoardList(ArrayList<Board> boards) {
//        recyclerView = (RecyclerView) findViewById(R.id.listBoard);
//        boardAdapter = new BoardAdapter(boards, BoardActivity.this);
//
//        recyclerView.setAdapter(boardAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(BoardActivity.this));
//    }
}

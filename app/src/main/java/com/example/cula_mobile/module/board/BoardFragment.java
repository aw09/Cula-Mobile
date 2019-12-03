package com.example.cula_mobile.module.board;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cula_mobile.R;
import com.example.cula_mobile.model.Board;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BoardFragment extends Fragment implements IBoardView{
    BoardPresenter boardPresenter;
    private BoardAdapter boardAdapter;
    private RecyclerView recyclerView;
    private ArrayList<Board> boards;
    private TextView textView;
    private View view;
    private int idProject;

    public BoardFragment(int idProject) {
        // Required empty public constructor
        this.idProject = idProject;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_board, container, false);
        boardPresenter = new BoardPresenter(this);
        boardPresenter.getBoardList(idProject);
        textView = view.findViewById(R.id.txtTitleBoard);
        return view;
    }

    @Override
    public void showBoardList(ArrayList<Board> boards) {
        recyclerView = (RecyclerView) view.findViewById(R.id.listBoard);
        boardAdapter = new BoardAdapter(boards, getContext());
        Log.e("lele", boards.size()+"");
        recyclerView.setAdapter(boardAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}

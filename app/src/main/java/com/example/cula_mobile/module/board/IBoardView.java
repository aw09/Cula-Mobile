package com.example.cula_mobile.module.board;

import com.example.cula_mobile.model.Board;

import java.util.ArrayList;

public interface IBoardView {
    void showBoardList(ArrayList<Board> boards);
    void showProjectName(String name);
}

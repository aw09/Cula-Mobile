package com.example.cula_mobile.model.response;

import com.example.cula_mobile.model.Card;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseBoard {
    @SerializedName("id")
    private int idBoard;
    @SerializedName("id_project")
    private int idProject;
    @SerializedName("name")
    private String boardName;
    @SerializedName("card")
    private ArrayList<Card> listCard;

    public int getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(int idBoard) {
        this.idBoard = idBoard;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public ArrayList<Card> getListCard() {
        return listCard;
    }

    public void setListCard(ArrayList<Card> listCard) {
        this.listCard = listCard;
    }
}

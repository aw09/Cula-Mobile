package com.example.cula_mobile.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Board {
    @SerializedName("id")
    private int idBoard;
    @SerializedName("id_project")
    private int idProject;
    @SerializedName("name")
    private String boardName;
    @SerializedName("created_at")
    private String createdDate;
    @SerializedName("updated_at")
    private String updatedDate;
    @SerializedName("card")
    private ArrayList<Card> listCard;

    public int getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(int idBoard) {
        this.idBoard = idBoard;
    }

    public ArrayList<Card> getListCard() {
        return listCard;
    }

    public void setListCard(ArrayList<Card> listCard) {
        this.listCard = listCard;
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
}

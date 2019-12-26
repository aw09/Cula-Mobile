package com.example.cula_mobile.model.response;

import com.example.cula_mobile.model.Board;
import com.example.cula_mobile.model.Card;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseBoard {
    @SerializedName("id")
    private int idProject;

    @SerializedName("name")
    private String projectName;

    @SerializedName("due_date")
    private String dueDate;

    @SerializedName("board")
    private ArrayList<Board> boards;

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public ArrayList<Board> getBoards() {
        return boards;
    }

    public void setBoards(ArrayList<Board> boards) {
        this.boards = boards;
    }
}

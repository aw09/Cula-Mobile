package com.example.cula_mobile.model.response;

import com.google.gson.annotations.SerializedName;

public class ResponseMyTask {
    @SerializedName("id")
    private int idMyTask;

    @SerializedName("id_role")
    private int idRole;

    @SerializedName("id_card")
    private int idCard;

    @SerializedName("id_label")
    private int idLabel;

    @SerializedName("id_grouping")
    private int idGrouping;

    @SerializedName("task")
    private String myTaskName;

    @SerializedName("due_date")
    private String dueDate;

    public int getIdMyTask() {
        return idMyTask;
    }

    public void setIdMyTask(int idMyTask) {
        this.idMyTask = idMyTask;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getMyTaskName() {
        return myTaskName;
    }

    public void setMyTaskName(String myTaskName) {
        this.myTaskName = myTaskName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}

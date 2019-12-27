package com.example.cula_mobile.model.response;

import com.google.gson.annotations.SerializedName;

public class ResponseCreateTask {
    @SerializedName("id")
    private int idTask;
    @SerializedName("id_role")
    private  int idRole;
    @SerializedName("id_card")
    private  int idCard;
    @SerializedName("id_label")
    private  int idLabel;
    @SerializedName("id_grouping")
    private  int idGrouping;
    @SerializedName("task")
    private  String taskName;
    @SerializedName("detail_of_task")
    private  String detailTask;
    @SerializedName("due_date")
    private  String due_date;

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(int idLabel) {
        this.idLabel = idLabel;
    }

    public int getIdGrouping() {
        return idGrouping;
    }

    public void setIdGrouping(int idGrouping) {
        this.idGrouping = idGrouping;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDetailTask() {
        return detailTask;
    }

    public void setDetailTask(String detailTask) {
        this.detailTask = detailTask;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }
}

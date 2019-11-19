package com.example.cula_mobile.model;

import com.google.gson.annotations.SerializedName;

public class Subtask {

    @SerializedName("id")
    private int idSubTask;
    @SerializedName("subtask")
    private String subTaskName;
    @SerializedName("due_date")
    private String dueDate;

    public int getIdSubTask() {
        return idSubTask;
    }

    public void setIdSubTask(int idSubTask) {
        this.idSubTask = idSubTask;
    }

    public String getSubTaskName() {
        return subTaskName;
    }

    public void setSubTaskName(String subTaskName) {
        this.subTaskName = subTaskName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}

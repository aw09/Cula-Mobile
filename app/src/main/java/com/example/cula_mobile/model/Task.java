package com.example.cula_mobile.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Task {
    @SerializedName("id")
    private int idTask;

    @SerializedName("task")
    private String taskName;

    @SerializedName("due_date")
    private String dueDate;

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

}

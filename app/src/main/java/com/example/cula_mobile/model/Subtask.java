package com.example.cula_mobile.model;

import com.google.gson.annotations.SerializedName;

public class Subtask {

    @SerializedName("id")
    private int idSubTask;
    @SerializedName("id_task")
    private int idTask;
    @SerializedName("check_list")
    private String subTaskName;
    @SerializedName("due_date")
    private String dueDate;
    @SerializedName("checked")
    private int checked;
    @SerializedName("success")
    private Subtask success;

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

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public Subtask getSuccess() {
        return success;
    }

    public void setSuccess(Subtask success) {
        this.success = success;
    }
}

package com.example.cula_mobile.model;

import com.google.gson.annotations.SerializedName;

public class Task {
    @SerializedName("id")
    private int idTask;
    @SerializedName("id_role")
    private int idRole;
    @SerializedName("id_label")
    private int idLabel;
    @SerializedName("id_grouping")
    private int idGrouping;
    @SerializedName("task")
    private String taskName;
    @SerializedName("detail_of_task")
    private String detailTask;
    @SerializedName("due_date")
    private String dueDate;
    @SerializedName("start_date")
    private String startDate;
    @SerializedName("finish_date")
    private String finishDate;
    @SerializedName("created_at")
    private String createDate;
    @SerializedName("update_at")
    private String updateDate;

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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}

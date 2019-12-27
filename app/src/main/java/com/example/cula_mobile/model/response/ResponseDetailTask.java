package com.example.cula_mobile.model.response;

import com.example.cula_mobile.model.Comment;
import com.example.cula_mobile.model.Label;
import com.example.cula_mobile.model.Subtask;
import com.example.cula_mobile.model.User;
import com.google.gson.annotations.SerializedName;

import java.sql.Array;
import java.util.ArrayList;

public class ResponseDetailTask {
    @SerializedName("id")
    private int idTask;

    @SerializedName("id_role")
    private int idRole;

    @SerializedName("id_label")
    private Label label;

    @SerializedName("id_grouping")
    private int idGrouping;

    @SerializedName("task")
    private String taskName;

    @SerializedName("detail_of_task")
    private String detailTask;

    @SerializedName("due_date")
    private String dueDate;

    @SerializedName("user")
    private ArrayList<User> users;

    @SerializedName("check_list")
    private ArrayList<Subtask> subtasks;

    @SerializedName("comment")
    private ArrayList<Comment> comments;

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

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
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

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(ArrayList<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
}

package com.example.cula_mobile.model;

import com.google.gson.annotations.SerializedName;

public class Comment {
    @SerializedName("id")
    private int idComment;

    @SerializedName("id_user")
    private int idUser;

    @SerializedName("id_task")
    private int idTask;

    @SerializedName("comment")
    private String comment;

    @SerializedName("created_at")
    private String createDate;

    @SerializedName("user")
    private User user;

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

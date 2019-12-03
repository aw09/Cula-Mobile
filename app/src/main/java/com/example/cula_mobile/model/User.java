package com.example.cula_mobile.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    private int idUser;

    @SerializedName("name")
    private String userName;

    @SerializedName("email")
    private String emailUser;

    @SerializedName("email_verified_at")
    private String emailVerified;

    @SerializedName("created_at")
    private String createdDate;

    @SerializedName("updated_at")
    private String updatedDate;

    @SerializedName("picture")
    private String picture;

    @SerializedName("user")
    private User user;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(String emailVerified) {
        this.emailVerified = emailVerified;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public User getUser() {
        return user;
    }
}

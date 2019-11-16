package com.example.cula_mobile.model;

import com.google.gson.annotations.SerializedName;

public class Board {
    @SerializedName("id")
    private int idCard;
    @SerializedName("id_project")
    private int idProject;
    @SerializedName("name")
    private String cardName;
    @SerializedName("created_at")
    private String createdDate;
    @SerializedName("updated_at")
    private String updatedDate;

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
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
}

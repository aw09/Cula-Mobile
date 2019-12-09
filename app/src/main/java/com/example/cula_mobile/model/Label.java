package com.example.cula_mobile.model;

import com.google.gson.annotations.SerializedName;

public class Label {
    @SerializedName("id")
    private int idLabel;

    @SerializedName("color_of_label")
    private String colorLabel;

    @SerializedName("label")
    private String labelName;

    public int getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(int idLabel) {
        this.idLabel = idLabel;
    }

    public String getColorLabel() {
        return colorLabel;
    }

    public void setColorLabel(String colorLabel) {
        this.colorLabel = colorLabel;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
}

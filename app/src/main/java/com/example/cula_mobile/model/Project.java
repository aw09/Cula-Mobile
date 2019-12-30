package com.example.cula_mobile.model;

import com.google.gson.annotations.SerializedName;

public class Project {
    @SerializedName("id")
    private int idProject;
    @SerializedName("name")
    private String projectName;
    @SerializedName("due_date")
    private String dueDate;

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}

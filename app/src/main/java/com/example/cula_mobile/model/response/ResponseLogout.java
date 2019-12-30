package com.example.cula_mobile.model.response;

import com.google.gson.annotations.SerializedName;

public class ResponseLogout {
    @SerializedName("message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

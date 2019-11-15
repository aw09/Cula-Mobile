package com.example.cula_mobile.model.response;

import com.google.gson.annotations.SerializedName;

public class ResponseLogin {
    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

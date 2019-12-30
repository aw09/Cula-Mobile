package com.example.cula_mobile.module.profile;

import com.example.cula_mobile.model.User;

public interface IProfileView {
    void showUserProfileData(User user);
    void showMessageLogout(String msg);
}

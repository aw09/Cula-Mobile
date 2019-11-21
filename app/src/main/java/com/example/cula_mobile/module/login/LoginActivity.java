package com.example.cula_mobile.module.login;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cula_mobile.ActivityBottom_navigation;
import com.example.cula_mobile.MainActivity;
import com.example.cula_mobile.R;
import com.example.cula_mobile.module.mytask.MyTaskActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    Button btnLogin;
    EditText email;
    EditText password;
    private LoginPresenter loginPresenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = (Button) findViewById(R.id.login);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        loginPresenter = new LoginPresenter(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.doLogin(email.getText().toString(), password.getText().toString());
            }
        });
    }

    public void moveToMyTask() {
        Intent intent = new Intent(LoginActivity.this, ActivityBottom_navigation.class);
        startActivity(intent);
    }
}

package com.example.cula_mobile.module.login;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cula_mobile.ActivityBottom_navigation;
import com.example.cula_mobile.MainActivity;
import com.example.cula_mobile.R;
import com.example.cula_mobile.module.mytask.MyTaskActivity;
import com.example.cula_mobile.utils.SharedPreferenceUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    Button btnLogin;
    EditText email;
    EditText password;
    ProgressBar progressBar;
    private LoginPresenter loginPresenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = (Button) findViewById(R.id.login);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBarLogin);
        progressBar.setVisibility(View.GONE);
        loginPresenter = new LoginPresenter(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                loginPresenter.doLogin(email.getText().toString(), password.getText().toString());
                SharedPreferenceUtils.initSharedPrefrences("CULA", LoginActivity.this);

            }
        });
    }

    public void moveToMyTask() {
        progressBar.setVisibility(View.GONE);
        Intent intent = new Intent(LoginActivity.this, ActivityBottom_navigation.class);
        startActivity(intent);
    }

    @Override
    public void showInformation() {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, "Server is down", Toast.LENGTH_SHORT).show();
    }
}

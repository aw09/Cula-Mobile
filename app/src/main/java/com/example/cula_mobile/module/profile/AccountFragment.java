package com.example.cula_mobile.module.profile;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.cula_mobile.R;
import com.example.cula_mobile.model.User;
import com.example.cula_mobile.module.login.LoginActivity;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment implements IProfileView {
    ProfilePresenter profilePresenter;
    View view;
    private TextView name, email;
    Button logout;
    private ActionBar actionBar;
    private ProgressBar progressBar;

    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_account, container, false);
        name = (TextView) view.findViewById(R.id.name);
        email = (TextView) view.findViewById(R.id.username);
        logout = (Button) view.findViewById(R.id.imageButtonLogout);
        progressBar = view.findViewById(R.id.progressBarProfile);

        actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setTitle("Profile");

        profilePresenter = new ProfilePresenter(this);
        profilePresenter.getUserProfile();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profilePresenter.doLogout();
            }
        });

        return view;
    }

    @Override
    public void showUserProfileData(User user) {
        progressBar.setVisibility(View.GONE);
        name.setText(user.getUserName());
        email.setText(user.getEmailUser());
    }

    @Override
    public void showMessageLogout(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }
}

package com.example.cula_mobile.module.profile;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.cula_mobile.R;
import com.example.cula_mobile.model.User;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment implements IProfileView {
    ProfilePresenter profilePresenter;
    View view;
    TextView name, email;

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
        profilePresenter = new ProfilePresenter(this);
        profilePresenter.getUserProfile();

        return view;
    }

    @Override
    public void showUserProfileData(User user) {
        name.setText(user.getUserName());
        email.setText(user.getEmailUser());
    }
}

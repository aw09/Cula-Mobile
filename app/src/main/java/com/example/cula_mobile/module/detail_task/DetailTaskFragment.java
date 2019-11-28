package com.example.cula_mobile.module.detail_task;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cula_mobile.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailTaskFragment extends Fragment {
    private int idTask;

    public DetailTaskFragment(int idTask) {
        // Required empty public constructor
        this.idTask = idTask;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_detail_task_2, container, false);
    }

}

package com.example.cula_mobile.module.mytask;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cula_mobile.R;
import com.example.cula_mobile.model.Task;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyCardFragment extends Fragment implements IMyTaskView {
    MyTaskPresenter myTaskPresenter;
    private RecyclerView recyclerView;
    private MyTaskAdapter myTaskAdapter;
    private View view;

    public MyCardFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_my_card, container, false);
        myTaskPresenter = new MyTaskPresenter(this);
        myTaskPresenter.getMyCardList();

        return view;
    }

    public void showMyCardList(ArrayList<Task> tasks) {
        recyclerView = (RecyclerView) view.findViewById(R.id.listMyTask);
        myTaskAdapter = new MyTaskAdapter(tasks, getContext());

        recyclerView.setAdapter(myTaskAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}

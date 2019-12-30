package com.example.cula_mobile.module.board;


import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.cula_mobile.R;
import com.example.cula_mobile.model.Board;
import com.example.cula_mobile.module.card.CardFragment;
import com.example.cula_mobile.module.project.ProjectsFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BoardFragment extends Fragment implements IBoardView{
    BoardPresenter boardPresenter;
    private BoardAdapter boardAdapter;
    private RecyclerView recyclerView;
    private ArrayList<Board> boards;
    private TextView textInfo;
    private View view;
    private int idProject;
    private ActionBar actionBar;
    private ProgressBar progressBar;

    public BoardFragment(int idProject) {
        // Required empty public constructor
        this.idProject = idProject;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_board, container, false);
        progressBar = view.findViewById(R.id.progressBarBoard);
        progressBar.setVisibility(View.VISIBLE);

        boardPresenter = new BoardPresenter(this);
        boardPresenter.getBoardList(idProject);

        textInfo = view.findViewById(R.id.info_in_board);

        actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setTitle("Board");
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        return view;
    }

    @Override
    public void showBoardList(ArrayList<Board> boards) {
        progressBar.setVisibility(View.GONE);
        if (boards.size() == 0) {
            textInfo.setText("This project does not have any boards");
        } else {
            recyclerView = (RecyclerView) view.findViewById(R.id.listBoard);
            boardAdapter = new BoardAdapter(boards, getContext());
            recyclerView.setAdapter(boardAdapter);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionMenu(Menu menu) {
        return true;
    }

    private void goBack() {
        Fragment fragment = new ProjectsFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}

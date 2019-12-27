package com.example.cula_mobile.module.card;


import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.cula_mobile.R;
import com.example.cula_mobile.model.Board;
import com.example.cula_mobile.model.Card;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CardFragment extends Fragment implements ICardView {
    private CardPresenter cardPresenter;
    private RecyclerView recyclerView;
    private CardAdapter cardAdapter;
    private View view;
    private int idBoard;
    private TextView textInfo;
    private ActionBar actionBar;
    private ProgressBar progressBar;

    public CardFragment(int idBoard) {
        // Required empty public constructor
        this.idBoard = idBoard;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_card, container, false);
        progressBar = view.findViewById(R.id.progressBarCard);
        progressBar.setVisibility(View.VISIBLE);

        cardPresenter = new CardPresenter(this);
        cardPresenter.getCardList(idBoard);

        actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        return view;
    }

    @Override
    public void showCardList(ArrayList<Card> cards) {
        recyclerView = (RecyclerView) view.findViewById(R.id.listCard);
        cardAdapter = new CardAdapter(cards, getContext());
        Log.e("bandeng", cards.size() + "");
        progressBar.setVisibility(View.GONE);
        recyclerView.setAdapter(cardAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                    LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void showTitle(String boardName) {
        actionBar.setTitle(boardName);
    }

    @Override
    public void showInformation() {
        progressBar.setVisibility(View.GONE);
        textInfo = (TextView) view.findViewById(R.id.info_in_card);
        textInfo.setText("This board does not have any cards.");
    }
}

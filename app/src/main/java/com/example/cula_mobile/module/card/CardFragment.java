package com.example.cula_mobile.module.card;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cula_mobile.R;
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

    public CardFragment(int idBoard) {
        // Required empty public constructor
        this.idBoard = idBoard;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_card, container, false);
        cardPresenter = new CardPresenter(this);
        cardPresenter.getCardList(idBoard);
        return view;
    }

    @Override
    public void showCardList(ArrayList<Card> cards) {
        recyclerView = (RecyclerView) view.findViewById(R.id.listCard);
        cardAdapter = new CardAdapter(cards, getContext());

        recyclerView.setAdapter(cardAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false));
    }
}

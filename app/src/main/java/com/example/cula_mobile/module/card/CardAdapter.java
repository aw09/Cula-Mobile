package com.example.cula_mobile.module.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cula_mobile.R;
import com.example.cula_mobile.model.Card;
import com.example.cula_mobile.module.board.TaskAdapter;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {
    private ArrayList<Card> cards;
    private Context context;

    public CardAdapter(ArrayList<Card> cards, Context context) {
        this.cards = cards;
        this.context = context;
    }

    @NonNull
    @Override
    public CardAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_card, parent, false);

        return new CardViewHolder(view);
    }

    public void onBindViewHolder(CardViewHolder holder, int posititon) {
        TaskAdapter taskAdapter = new TaskAdapter(cards.get(posititon).getListTask(), context);
        holder.txtCardName.setText(cards.get(posititon).getCardName());
        holder.listTask.setAdapter(taskAdapter);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public int getItemCount() {
        return (cards != null) ? cards.size() : 0;
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        private TextView txtCardName;
        private RecyclerView listTask;

        public CardViewHolder(View itemView) {
            super(itemView);

            txtCardName = (TextView) itemView.findViewById(R.id.txtCardName);
            listTask = (RecyclerView) itemView.findViewById(R.id.listTask);
        }
    }
}

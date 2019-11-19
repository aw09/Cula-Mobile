package com.example.cula_mobile.module.board;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cula_mobile.R;
import com.example.cula_mobile.model.Board;
import com.example.cula_mobile.module.card.CardActivity;

import java.util.ArrayList;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoardViewHolder> {
    private ArrayList<Board> myBoards;
    private Context context;
    
    public BoardAdapter(ArrayList<Board> Boards, Context context){
        this.myBoards = Boards;
        this.context = context;
    }
    
    @Override
    public BoardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_board, parent, false);

        return new BoardViewHolder(view);
    }

    public void onBindViewHolder(BoardViewHolder holder, int posititon) {
        holder.txtBoardName.setText(myBoards.get(posititon).getBoardName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CardActivity.class);
                intent.putExtra("idBoard", myBoards.get(posititon).getIdBoard());
                context.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return (myBoards != null) ? myBoards.size() : 0;
    }

    public class BoardViewHolder extends RecyclerView.ViewHolder {
        private TextView txtBoardName;
        private RecyclerView listTask;

        public BoardViewHolder(View itemView) {
            super(itemView);

            txtBoardName = (TextView) itemView.findViewById(R.id.txtCardName);
            listTask = (RecyclerView) itemView.findViewById(R.id.listTask);
        }
    }
}

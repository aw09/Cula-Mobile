package com.example.cula_mobile.module.board;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cula_mobile.ActivityBottom_navigation;
import com.example.cula_mobile.R;
import com.example.cula_mobile.model.Board;
import com.example.cula_mobile.module.card.CardFragment;

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
                fragmentTransaction(new CardFragment(myBoards.get(posititon).getIdBoard()));
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

            txtBoardName = (TextView) itemView.findViewById(R.id.textView);
            Log.e("mujaeerbawah", txtBoardName+"");
        }
    }

    private boolean fragmentTransaction(Fragment fragment){
        FragmentManager fragmentManager = ((ActivityBottom_navigation) context).getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout_container, fragment, "")
                .addToBackStack(null)
                .commit();
        return true;
    }
}

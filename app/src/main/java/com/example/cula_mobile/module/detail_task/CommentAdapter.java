package com.example.cula_mobile.module.detail_task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cula_mobile.R;
import com.example.cula_mobile.model.Comment;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {
    private ArrayList<Comment> comments;
    private Context context;

    public CommentAdapter(ArrayList<Comment> comments, Context context) {
        this.comments = comments;
        this.context = context;
    }


    @NonNull
    @Override
    public CommentAdapter.CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_comment, parent, false);

        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.CommentViewHolder holder, int position) {
        holder.txtUserName.setText(comments.get(position).getUser().getUserName());
        holder.txtContent.setText(comments.get(position).getComment());
        holder.txtTime.setText(comments.get(position).getCreateDate());
    }


    public int getItemCount() {
        return (comments != null) ? comments.size() : 0;
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {
        private TextView txtContent, txtUserName, txtTime;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);

            txtUserName = (TextView) itemView.findViewById(R.id.txtUserName);
            txtContent = (TextView) itemView.findViewById(R.id.txtContent);
            txtTime = (TextView) itemView.findViewById(R.id.txtTime);
        }
    }
}

package com.example.cula_mobile.module.detail_task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cula_mobile.R;
import com.example.cula_mobile.model.Subtask;

import java.util.ArrayList;

public class SubTaskAdapter extends RecyclerView.Adapter<SubTaskAdapter.SubTaskViewHolder> {
    private ArrayList<Subtask> subTasks;
    private Context context;

    public SubTaskAdapter(ArrayList<Subtask> subTasks, Context context) {
        this.subTasks = subTasks;
        this.context = context;
    }

    @NonNull
    @Override
    public SubTaskAdapter.SubTaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_sub_task, parent, false);

        return new SubTaskViewHolder(view);
    }

    public void onBindViewHolder(SubTaskViewHolder holder, int posititon) {
        holder.txtSubTaskName.setText(subTasks.get(posititon).getSubTaskName());
        holder.txtDueDate.setText(subTasks.get(posititon).getDueDate());
    }

    public int getItemCount() {
        return (subTasks != null) ? subTasks.size() : 0;
    }

    public class SubTaskViewHolder extends RecyclerView.ViewHolder {
        private TextView txtSubTaskName, txtDueDate;
        CheckBox checkBox;

        public SubTaskViewHolder(View itemView) {
            super(itemView);

            txtSubTaskName = (TextView) itemView.findViewById(R.id.txtSubTaskName);
            txtDueDate = (TextView) itemView.findViewById(R.id.txtDueDate);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
        }
    }
}

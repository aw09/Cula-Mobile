package com.example.cula_mobile.module.mytask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cula_mobile.R;
import com.example.cula_mobile.model.Task;

import java.util.ArrayList;

public class MyTaskAdapter extends RecyclerView.Adapter<MyTaskAdapter.TaskViewHolder> {
    private ArrayList<Task> task;
    private Context context;

    public MyTaskAdapter(ArrayList<Task> task, Context context) {
        this.task = task;
        this.context = context;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_mytask, parent, false);

        return new TaskViewHolder(view);
    }

    public void onBindViewHolder(TaskViewHolder holder, int position) {
        holder.txtTaskName.setText(task.get(position).getTaskName());
        holder.txtDueDate.setText(task.get(position).getDueDate());
    }

    public int getItemCount() {
        return (task != null) ? task.size() : 0;
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTaskName, txtBoard, txtProject, txtDueDate;

       public TaskViewHolder(View itemView) {
           super(itemView);

           txtTaskName = (TextView) itemView.findViewById(R.id.textTaskName);
           txtBoard = (TextView) itemView.findViewById(R.id.textBoardName);
           txtProject = (TextView) itemView.findViewById(R.id.textProjectName);
           txtDueDate = (TextView) itemView.findViewById(R.id.textDueDate);
       }
    }
}

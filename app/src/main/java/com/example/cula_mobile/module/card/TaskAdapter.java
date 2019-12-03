package com.example.cula_mobile.module.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cula_mobile.ActivityBottom_navigation;
import com.example.cula_mobile.R;
import com.example.cula_mobile.model.Task;
import com.example.cula_mobile.module.detail_task.DetailTaskFragment;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TasksViewHolder> {
    private ArrayList<Task> tasks;
    private Context context;

    public TaskAdapter(ArrayList<Task> tasks, Context context) {
        this.tasks = tasks;
        this.context = context;
    }

    @NonNull
    @Override
    public TasksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_task, parent, false);

        return new TasksViewHolder(view);
    }

    public void onBindViewHolder(TasksViewHolder holder, int position) {
        holder.txtTaskName.setText(tasks.get(position).getTaskName());
        holder.txtDueDate.setText(tasks.get(position).getDueDate());
        //holder.txtSumOfSubTask.setText(tasks.get(position).get);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction(new DetailTaskFragment(tasks.get(position).getIdTask()));
            }
        });
    }

    public int getItemCount() {
        return (tasks != null) ? tasks.size() : 0;
    }

    public class TasksViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTaskName, txtDueDate, txtSumOfSubTask;

        public TasksViewHolder(View itemView) {
            super(itemView);

            txtTaskName = (TextView) itemView.findViewById(R.id.txtTaskName);
            txtDueDate = (TextView) itemView.findViewById(R.id.textView5);
            txtSumOfSubTask = (TextView) itemView.findViewById(R.id.txtSumOfSubTask);
        }
    }

    private boolean fragmentTransaction(Fragment fragment){
        FragmentManager fragmentManager = ((ActivityBottom_navigation) context).getSupportFragmentManager();
        String backStackStateName = null;
        fragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout_container, fragment, "")
                .commit();
        return true;
    }
}

package com.example.cula_mobile.module.detail_task;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cula_mobile.R;
import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
import com.example.cula_mobile.model.Subtask;
import com.example.cula_mobile.utils.SharedPreferenceUtils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubTaskAdapter extends RecyclerView.Adapter<SubTaskAdapter.SubTaskViewHolder> {
    private ArrayList<Subtask> subTasks;
    private Context context;
    private DetailTaskPresenter presenter;

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

    public void onBindViewHolder(SubTaskViewHolder holder, int position) {
        holder.txtSubTaskName.setText(subTasks.get(position).getSubTaskName());
        holder.txtDueDate.setText(subTasks.get(position).getDueDate());
        Log.e("cendol", subTasks.get(position).getChecked()+"");
        if (subTasks.get(position).getChecked() == 1) {
            holder.checkBox.setChecked(true);
        } else {
            holder.checkBox.setChecked(false);
        }
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.checkBox.isChecked()) {
                    UpdateSubtask(1, subTasks.get(position));
                } else {
                    UpdateSubtask(0, subTasks.get(position));
                }
            }
        });
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

    private void UpdateSubtask(int status, Subtask st) {
        Log.e("cendol", status+"");
        String token = SharedPreferenceUtils.getStringSharedPreferences("token", "subtask");
        IApiEndpoint endpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);
        Call<Subtask> call = endpoint.updateSubtask(token, st.getIdSubTask(), st);
        call.enqueue(new Callback<Subtask>() {
            @Override
            public void onResponse(Call<Subtask> call, Response<Subtask> response) {
                st.setChecked(status);
            }

            @Override
            public void onFailure(Call<Subtask> call, Throwable t) {
                Log.e("cendol", t.toString());
            }
        });
    }
}

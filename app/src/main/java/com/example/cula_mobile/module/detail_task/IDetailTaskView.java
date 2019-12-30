package com.example.cula_mobile.module.detail_task;

import com.example.cula_mobile.model.Comment;
import com.example.cula_mobile.model.Label;
import com.example.cula_mobile.model.Subtask;
import com.example.cula_mobile.model.Task;
import com.example.cula_mobile.model.response.ResponseDetailTask;

import java.util.ArrayList;

public interface IDetailTaskView {
    void showDetailTask(ResponseDetailTask task);
    void showSubtask(ArrayList<Subtask> subtasks);
    void showComment(ArrayList<Comment> comments);
    void showTaskTitle(String taskTitle);
    void showLabel(Label labels);
    void reload();
}

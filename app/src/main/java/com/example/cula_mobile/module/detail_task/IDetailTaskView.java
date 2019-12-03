package com.example.cula_mobile.module.detail_task;

import com.example.cula_mobile.model.Subtask;
import com.example.cula_mobile.model.Task;

import java.util.ArrayList;

public interface IDetailTaskView {
    void showDetailTask(Task task);
    void showSubtask(ArrayList<Subtask> subtasks);
}

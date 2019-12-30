package com.example.cula_mobile.module.mytask;
import com.example.cula_mobile.model.Task;
import com.example.cula_mobile.model.response.ResponseMyTask;

import java.util.ArrayList;

public interface IMyTaskView {
    void showMyCardList(ArrayList<Task> tasks);
}

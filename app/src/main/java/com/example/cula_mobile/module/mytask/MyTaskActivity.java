package com.example.cula_mobile.module.mytask;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cula_mobile.R;
import com.example.cula_mobile.data.api.ApiRetrofit;
import com.example.cula_mobile.data.api.IApiEndpoint;
import com.example.cula_mobile.model.Task;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyTaskActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyTaskAdapter myTaskAdapter;
    private ArrayList<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_my_card);
//        IApiEndpoint endpoint = ApiRetrofit.getInstance().create(IApiEndpoint.class);
//        Call<Task> callTask = endpoint.myTask("Blablabla");
//        callTask.enqueue(new Callback<Task>() {
//            @Override
//            public void onResponse(Call<Task> call, Response<Task> response) {
//                recyclerView = (RecyclerView) findViewById(R.id.listMyTask);
//                myTaskAdapter = new MyTaskAdapter(tasks, MyTaskActivity.this);
//
//                recyclerView.setAdapter(myTaskAdapter);
//                recyclerView.setLayoutManager(new LinearLayoutManager(MyTaskActivity.this));
//            }
//
//            @Override
//            public void onFailure(Call<Task> call, Throwable t) {
//
//            }
//        });

    }
}

package com.example.cula_mobile.module.detail_task;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cula_mobile.R;

public class StatusAdapter extends ArrayAdapter<String> {
    private String[] status;
    private Context context;

    public StatusAdapter(@NonNull Context context, int resource, @NonNull String[] status) {
        super(context, resource, status);
        this.status = status;
        this.context = context;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.item_status, parent, false);
        TextView label =(TextView)row.findViewById(R.id.listStatus);
        label.setText(status[position]);

        if (position == 0){
            label.setTextColor(Color.parseColor("#4B4B4B"));
        } else if (position == 1) {
            label.setTextColor(Color.parseColor("#0F9CDB"));
        } else {
            label.setTextColor(Color.parseColor("#22D6B5"));
        }

        return row;
    }
}

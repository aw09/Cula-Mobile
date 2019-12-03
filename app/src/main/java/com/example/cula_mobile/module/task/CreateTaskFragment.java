package com.example.cula_mobile.module.task;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cula_mobile.R;
import com.example.cula_mobile.module.card.CardFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateTaskFragment extends Fragment implements ICreateTaskView {
    private int idCard, idBoard, day, month, year;
    private View view;
    private EditText txtTask, txtDescription, txtDueDate;
    private CreateTaskPresenter createTaskPresenter;
    private Button btnOK;
    private static final int DIALOG_ID = 0;

    public CreateTaskFragment(int idCard, int idBoard) {
        // Required empty public constructor
        this.idCard = idCard;
        this.idBoard = idBoard;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_create_task, container, false);
        txtTask = (EditText) view.findViewById(R.id.addTask);
        txtDescription = (EditText) view.findViewById(R.id.addDescription);
        txtDueDate = (EditText) view.findViewById(R.id.addDate);
        btnOK = (Button) view.findViewById(R.id.buttonOK);
        createTaskPresenter = new CreateTaskPresenter(this);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createTaskPresenter.createTask(idCard, txtTask.getText().toString(),
                        txtDescription.getText().toString(),
                        txtDueDate.getText().toString());
            }
        });

        return view;
    }

//    private void showDialogOnClick() {
//        txtDueDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onCreateDialog(DIALOG_ID);
//            }
//        });
//    }
//
//    protected Dialog onCreateDialog(int id) {
//        if(id == DIALOG_ID) {
//            return new DatePickerDialog(this, dpickerlistener, year, month, day);
//        }
//        return null;
//    }
//
//    private DatePickerDialog.OnDateSetListener dpickerlistener = new DatePickerDialog.OnDateSetListener() {
//        @Override
//        public void onDateSet(DatePicker datePicker, int y, int m, int d) {
//            year = y;
//            month = m;
//            day = d;
//            txtDueDate.setText(year + "-" + month + "-" + day);
//        }
//    };

    @Override
    public void backToCard() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout_container, new CardFragment(idBoard));
    }
}

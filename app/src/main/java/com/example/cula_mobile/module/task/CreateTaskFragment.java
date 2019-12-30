package com.example.cula_mobile.module.task;


import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.cula_mobile.R;
import com.example.cula_mobile.module.card.CardFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateTaskFragment extends Fragment implements ICreateTaskView {
    private int idCard, idBoard, day, month, year;
    private View view;
    private EditText txtTask, txtDescription, txtDueDate;
    private CreateTaskPresenter createTaskPresenter;
    private Button btnOK;
    private ProgressBar progressBar;
    private static final int DIALOG_ID = 0;

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private TextView txtChooseDate;



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
        //txtDueDate = (EditText) view.findViewById(R.id.addDate);
        btnOK = (Button) view.findViewById(R.id.buttonOK);
        progressBar = view.findViewById(R.id.progressBarCreateTask);
        progressBar.setVisibility(View.GONE);

        //btnDate = (Button) view.findViewById(R.id.buttonDate);
        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        txtChooseDate = (TextView) view.findViewById(R.id.txtChooseDate);



        createTaskPresenter = new CreateTaskPresenter(this);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                createTaskPresenter.createTask(idCard, txtTask.getText().toString(),
                        txtDescription.getText().toString(),
                        //txtDueDate.getText().toString());
                        txtChooseDate.getText().toString());

            }
        });

//        btnDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showDateDialog();
//            }
//        });
        txtChooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });

        return view;
    }


    private void showDateDialog() {
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this.view.getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int day, int month, int year) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(day, month, year);

                txtChooseDate.setText(dateFormatter.format(newDate.getTime()));

            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
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
        progressBar.setVisibility(View.GONE);
        Fragment fragment = new CardFragment(idBoard);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}

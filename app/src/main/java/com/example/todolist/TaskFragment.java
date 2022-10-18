package com.example.todolist;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

public class TaskFragment extends Fragment {

    private Task task;
    private TextView nameField;
    private Button dateButton;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        task = new Task();
        CheckBox doneCheckBox;
        nameField = view.findViewById(R.id.task_name);
        doneCheckBox=view.findViewById(R.id.task_done);

        nameField.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s,int start,int count,int after){

            }
            @Override
            public void onTextChanged(CharSequence s,int start,int before,int count){
                task.setname(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s){

            }
        });
        dateButton.setText(task.getDate().toString());
        dateButton.setEnabled(false);

        doneCheckBox.setChecked(task.isDone());
        doneCheckBox.setOnCheckedChangeListener((buttonView,isChecked)-> task.setDone(isChecked));
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return inflater.inflate(R.layout.fragment_task, container, false);
    }


}


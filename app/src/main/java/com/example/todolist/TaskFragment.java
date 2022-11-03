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

import java.util.UUID;

public class TaskFragment extends Fragment {

    private Task task;
    private TextView nameField;
    private Button dateButton;
    private CheckBox doneCheckBox;
    private View view;
    private final static String ARG_TASK_ID="ARG_TASK_ID";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //task = new Task();

        UUID taskId=(UUID) getArguments().getSerializable(ARG_TASK_ID);
        task=TaskStorage.getInstance().getTask(taskId);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_task, container, false);

        nameField = view.findViewById(R.id.task_name);
        doneCheckBox=view.findViewById(R.id.task_done);
        dateButton=view.findViewById(R.id.task_date);
        if(container != null){
            if(nameField != null) {
                nameField.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        task.setName(s.toString());
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                nameField.setText(task.getName());
            }

            if(dateButton != null){
                dateButton.setText(task.getDate().toString());
                dateButton.setEnabled(false);
            }

            if(doneCheckBox != null){
                doneCheckBox.setChecked(task.isDone());
                doneCheckBox.setOnCheckedChangeListener((buttonView, isChecked) ->{task.setDone(isChecked);});
            }
        }
        return view;
    }
    public static TaskFragment newInstance(UUID taskId){
        Bundle bundle=new Bundle();
        bundle.putSerializable(ARG_TASK_ID,taskId);
        TaskFragment taskFragment = new TaskFragment();
        taskFragment.setArguments(bundle);
        return taskFragment;
    }
}


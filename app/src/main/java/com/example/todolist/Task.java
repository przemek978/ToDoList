package com.example.todolist;

import java.util.Date;
import java.util.UUID;

public class Task {
    private UUID id;
    private String name;
    private Date date;
    private boolean done;

    public Task(){
        id=UUID.randomUUID();
        date=new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setname(String s) {
        this.name=s;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean isChecked) {
        this.done=isChecked;
    }
}

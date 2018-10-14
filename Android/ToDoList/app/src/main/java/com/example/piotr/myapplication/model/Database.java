package com.example.piotr.myapplication.model;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Database {
    private List<Task> tasks;

    public Database() {
        tasks=new LinkedList<>();
        addDefaultTasks();
    }

    private void addDefaultTasks(){
        tasks.add(new Task("TASKA","Description",false));
        tasks.add(new Task("TASKB","Description",true));
        tasks.add(new Task("TASKC","Description",true));
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}

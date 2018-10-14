package com.example.piotr.myapplication.model;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Database {
    private static Database database;
    private List<Task> tasks;

    public static synchronized Database getInstance(){
        if(database==null)
            database= new Database();
        return database;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTask(Task task) {
        tasks.add(task);
    }

    public void deleteTaskIdBasedOnList(int id){
      tasks.remove(id);
    }
    public void deleteTaskIdBasedOnTask(int id){
        for(Task t: tasks)
            if(t.getId()==id)
                tasks.remove(id);
    }

    public Task getTaskBasedOnTask(int id){
        for(Task t: tasks)
            if(t.getId()==id)
               return t;
        throw new RuntimeException();
    }
    public Task getTaskBasedOnList(int id){
        return tasks.get(id);
    }

    private Database() {
        tasks=new LinkedList<>();
        addDefaultTasks();
    }

    private void addDefaultTasks(){
        tasks.add(new Task ("RUN_YOUTUBE","https://www.youtube.com/"));
        tasks.add(new Task("TASK_A","Description of Task A"));
        tasks.add(new Task("TASK_B","Description of Task B"));
        tasks.add(new Task("TASK_C","Description of Task C"));
    }
}

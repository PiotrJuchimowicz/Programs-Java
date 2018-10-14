package com.example.piotr.myapplication.model;

public class Task {
    private String name;
    private String description;
    private int id;
    private static int idGenerator=0;

    public Task() {
    }

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.id=idGenerator++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void decrementIdGeneratorValue(){
        idGenerator--;
    }

    @Override
    public String toString() {

        return "Id: " + id + " name: " + name + "\n" + "description: " + description;
    }
}

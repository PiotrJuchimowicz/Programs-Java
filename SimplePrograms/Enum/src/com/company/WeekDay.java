package com.company;

import java.io.Serializable;

public  enum  WeekDay implements Serializable {
    //executing constructors:
    MONDAY(1,"MON",false),
    TUESDAY(2,"TUE",false),
    WEDNESDAY(3,"WED",false),
    THURSDAY(4,"THU",false),
    FRIDAY(5,"FRI",false),
    SATURDAY(6,"SAT",true),
    SUNDAY(7,"SUN",true);

    int number;
    String shortcut;
    boolean isWeekend=false;



    //constructor must be private or protected
    private  WeekDay(int number,String shortcut,boolean isWeekend)
    {
        this.isWeekend=isWeekend;
        this.number=number;
        this.shortcut=shortcut;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    @Override
    public String toString() {
        return "WeekDay{" +
                "number=" + number +
                ", shortcut='" + shortcut + '\'' +
                ", isWeekend=" + isWeekend +
                '}';
    }
}

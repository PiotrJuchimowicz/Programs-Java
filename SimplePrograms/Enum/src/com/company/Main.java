package com.company;

import javax.sound.midi.Soundbank;

public class Main {

    public static void main(String[] args)
    {
        WeekDay weekDay = WeekDay.FRIDAY;
       //weekDay.ordinal() returns 4
        //weekDay.name() returns FRIDAY

        for ( WeekDay w : WeekDay.values())
            System.out.println(w.toString());

        switch (weekDay)
        {
            case FRIDAY:
            {
                System.out.println("Its Weekend");
                break;
            }

            case SUNDAY:
            {
                System.out.println("Its Weekend");
                break;
            }
            case SATURDAY:
            {
                System.out.println("Its Weekend");
                break;
            }

            default:
            {
                System.out.println("Its not Weekend");
                break;
            }
        }
    }
}

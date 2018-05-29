package com.company;

import java.util.Properties;

public class DiffrentRunner implements Runnable {

    private int id;

    public DiffrentRunner(int id)
    {
        this.id=id;
    }
    @Override
    public void run() {
        System.out.println("Starting " + id );

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed " + id );


    }


}




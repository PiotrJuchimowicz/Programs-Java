package com.company;

public class DiffrentRunner implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<10;i++)
        {
            System.out.println("Hello " + i);
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                System.out.println("Interrupt catched");
                e.printStackTrace();
            }
        }

    }
}

package com.company;

import static java.lang.Thread.*;

public class Runner extends Thread {
    public void run()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println("Hello " + i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Interrupt catched");

            }
        }
    }
}

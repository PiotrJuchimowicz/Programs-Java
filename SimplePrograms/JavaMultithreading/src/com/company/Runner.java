package com.company;

import static java.lang.Thread.*;

public class Runner extends Thread {
    public  int i;

    public void run() {

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            i++;
        }
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}

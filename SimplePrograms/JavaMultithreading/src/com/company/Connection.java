package com.company;

import java.util.concurrent.Semaphore;

public class Connection {
    private static Connection instance = new Connection();
    private int connections = 0;

    //limits to 10 connections
    //each thread will lock one from 10 permissions from semaphore
    private Semaphore semaphore = new Semaphore(10);

    private Connection() {
    }




    public static Connection getInstance() {
        return instance;
    }

    public void connect() throws InterruptedException {
        //takes permit
        semaphore.acquire();
        synchronized (this){
            connections++;
            System.out.println("Current connections " + connections);
        }

        Thread.sleep(2000);

        synchronized (this){
            connections--;
        }

        //returns permit
        semaphore.release();
    }
}

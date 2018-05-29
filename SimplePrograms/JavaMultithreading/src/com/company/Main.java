package com.company;

import sun.awt.Mutex;

import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) throws Exception {


        //In  this case  will be created as many threads as we need to execute tasks.
        // It is different way to create ThreeadPool than using
        //newFixedThreadPool
        ExecutorService service = Executors.newCachedThreadPool();

        //There is 200 tasks for our threads,but semaphore created in
        // Connection class allows to work only 10 threads at the same time
        for (int i = 0; i < 200; i++) {
            service.submit(() -> {
                try {
                    Connection.getInstance().connect();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        service.shutdown();

        service.awaitTermination(1, TimeUnit.DAYS);





    }
}

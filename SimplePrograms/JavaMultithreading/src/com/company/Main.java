package com.company;

import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Runner r1= new Runner();
        Thread t1= new Thread(new DiffrentRunner());
        t1.start();
        t1.interrupt();

        Consumer<String> consumer;
        consumer= (System.out::println);
    }
}

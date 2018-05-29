package com.company;

public interface Inter {
    int x = 2;

    public abstract void method();

    default void mehodA() {
    };

    public static void methodB(){};




}

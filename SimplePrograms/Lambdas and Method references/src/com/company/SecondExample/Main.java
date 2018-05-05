package com.company.SecondExample;

import java.util.function.Supplier;

public class Main {
    public static void main(String args[])
    {
        final int x;


        Supplier<Object> objectCreator = Object::new;
        // same as new Object()
        Object objectInstance = objectCreator.get();
        System.out.println(objectInstance);

        Boolean b = true;
        Boolean c = true;
        x=10;

        System.out.println(b==c);


    }
}

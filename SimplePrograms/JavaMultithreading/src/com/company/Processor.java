package com.company;

import java.util.concurrent.Callable;

public class Processor implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "something";
    }
}

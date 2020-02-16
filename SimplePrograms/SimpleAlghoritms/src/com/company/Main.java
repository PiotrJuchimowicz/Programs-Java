package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 6, 1, 10, 12, 14, 15));
        boolean wereLoops = SimpleAlghoritms.detectAndRemoveLoop(integers);
        System.out.println("DEBUG");
    }

}

package com.company;

import sun.misc.Lock;

import java.util.Scanner;

public class Main2 {
    public static  void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int x=  scanner.nextInt();
        String result = (x>20) ? "bigger number" : "less number";
        System.out.println(result);



    }
}

package com.company;

public class Main {

    public static void main(String[] args) {
/*
        Addition addition = new Addition() {
            @Override
            public int add(int x, int y) {
                return x+y;
            }
        };

        System.out.println(addition.add(2, 3));
*/

        Addition addition = (x, y) -> (x + y);

        System.out.println(addition.add(2, 3));


    }



}

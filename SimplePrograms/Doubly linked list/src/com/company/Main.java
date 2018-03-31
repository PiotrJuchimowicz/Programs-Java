package com.company;

public class Main {

    public static void main(String[] args)
    {
        doublyList doublyList = new doublyList();

        doublyList.add(2);
        doublyList.add(3);
        doublyList.add(4);
        doublyList.add(10);
        doublyList.delete(10);
        doublyList.delete(3);
        doublyList.delete(2);
        doublyList.delete(4);
        doublyList.show();
    }
}

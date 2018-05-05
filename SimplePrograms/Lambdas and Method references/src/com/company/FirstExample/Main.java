package com.company.FirstExample;
import  java.util.*;
public class Main {
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        for(int i=0;i<4;i++)
        {
            System.out.println("Enter string: ");
            list.add(input.next());
        }
        input.close();

        list.sort((String s1,String s2) -> {
            return   Integer.compare(s2.length(), s1.length());
        });

        System.out.println(list);
    }
}

package com.company;

public class SimpleAlghoritms {
    //palindrom check
    public static boolean isPalindrom(String param) {
        if (param == null)
            return false;
        char charArray[] = param.toLowerCase().toCharArray();

        for (int i = 0; i < charArray.length / 2; i++) {
            int j = charArray.length - i;
            if (charArray[i] != charArray[j - 1])
                return false;

        }
        return true;
    }

    //sum of numbers in array
    public static int sumOfNumbersInArray(int param) {
        int sum = 0;
        int division = 10;
        while (param!=0) {
            sum = sum + param % 10;
            param=param/10;
        }
        return sum;
    }

    //array reversion
    public static  void arrayReversion(int [] array){
        for(int i=0;i<array.length/2;i++)
        {
            int j=array.length-1 -i;
            int a = array[i];
            int b = array[j];
            array[i]=b;
            array[j]=a;
        }
    }
}

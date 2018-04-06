package com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
public class Main {

    public static void main(String[] args) throws  IOException
    {
        //for text files
        String file="plik.txt";
        FileWriter fileWriter=null;
        Integer i = 10;

          fileWriter = new FileWriter(file, true);
          fileWriter.write("something");
          fileWriter.write(i.toString());
          fileWriter.close();

        BufferedReader bufferedReader=null;
        FileReader fileReader=null;
        fileReader=new FileReader(file);
        bufferedReader=new BufferedReader(fileReader);
        String string=null;

        int a;
        char b;

        while((a=bufferedReader.read())!=-1)
        {
            b= (char)a;
            System.out.print(b + " ");
        }

        fileReader.close();
        bufferedReader.close();

        //for binary files

        String fileName="file.txt";
        FileOutputStream fileOutputStream=new FileOutputStream(fileName);
        DataOutputStream dataSteam= new DataOutputStream(fileOutputStream);
        dataSteam.writeInt(2);
        dataSteam.writeFloat((float)2.42);

        fileOutputStream.close();
        dataSteam.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        int k = dataInputStream.readInt();
        float h=dataInputStream.readFloat();

        System.out.println("");
        System.out.println(k + " " + h);






    }
}

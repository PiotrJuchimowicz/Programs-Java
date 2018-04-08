package com.company;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.sound.midi.Soundbank;
import java.io.*;

public class Main {

    public static void main(String[] args)
    {

        Warior firstWarior = new Warior("Jan","Kowalski",40.25,100.22,20);
        Warior secondWarior= new Warior("Michal","Nowak",12.2,25.4,99);

        String fileName="file.ser";

        FileOutputStream fileOutput=null;
        ObjectOutputStream objectOutput=null;

        try
        {
            fileOutput = new FileOutputStream(fileName);
            objectOutput= new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(firstWarior);
            objectOutput.writeObject(secondWarior);
            fileOutput.close();
            objectOutput.close();
        }

        catch (IOException e)
        {
            System.out.println("Error");
            e.printStackTrace();
            System.exit(1);

        }

        FileInputStream fileInput=null;
        ObjectInputStream objectInput=null;

        Warior w1=null;
        Warior w2=null;

        try
        {
            fileInput=new FileInputStream(fileName);
            objectInput= new ObjectInputStream(fileInput);
            Object o1= objectInput.readObject();
            Object o2=objectInput.readObject();
             w1 = (Warior)o1;
             w2 = (Warior)o2;

        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("Error");
            e.printStackTrace();
            System.exit(1);

        }

        System.out.println("Wariors after deserialization");
        System.out.println(w1.toString());
        System.out.println(w2.toString());


    }
}

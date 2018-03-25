package JDBC;

/**
 Commands in Oracle XE DB
 CREATE TABLE Client(
 id INTEGER PRIMARY KEY ,
 firstName VARCHAR(50),
 lastName VARCHAR (50),
 pesel VARCHAR (11) UNIQUE NOT NULL ,
 email VARCHAR (50) );

 CREATE TABLE Account (
 id INTEGER PRIMARY KEY ,
 notes VARCHAR(255),
 balance NUMBER(19),
 id_client INTEGER CONSTRAINT fk_client REFERENCES Client(ID) );
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import java.io.*;

import com.sun.org.apache.xpath.internal.SourceTree;
import models.*;
import  Dao.*;
public class App 
{
    public static void main( String[] args )throws  SQLException,ClassNotFoundException,FileNotFoundException
    {
        //  Adding new Client.I am going to make switch here with many options.
        //  There will be one option : "are you running this program first on your computer?"
        //  If yes, clientID=0 and accountID=0 otherwise values from last start of program
        //  Next id will be stored in file for being unique
        //  This value must be 0,when program starts
        //  I keep last clientID and accountID in file to be able to use program repeatedly
        // Client may have more than one Account

        //  Tables will be  made
        //  Creating streams to files(must add streams to Account.ID)


        Scanner consoleScanner= new Scanner(System.in);
        int choose;




        //number in file numberID must be 0 if it is first run of program
        System.out.println("Click 0 if you run this  program for the first time.");
        choose=consoleScanner.nextInt();
        //consoleScanner.nextLine();
        if(choose==0)
       {
           //Initialise ID-number for clients and accounts
           PrintWriter printWriter = new PrintWriter("ClientID.txt");
           printWriter.print(0);
           printWriter.close();
           PrintWriter printWriter1=new PrintWriter("AccountID.txt");
           printWriter1.print(0);
           printWriter1.close();

       }

       //reading actual clientID
        Scanner fileScanner = new Scanner(new File("ClientID.txt"));
        //Reading actual clientID from file
        String actualID=fileScanner.next();
        fileScanner.close();
        //Parsing to int
        int var=Integer.parseInt(actualID);

        //  Setting it for Client static  atribute
        //  It will be used with  constructor to make all data unique
         Client.setNumber(var);

         //  Same things with AccountID
       Scanner fileScanner1=new Scanner(new File("AccountID.txt"));
       actualID=fileScanner1.next();
       fileScanner1.close();
       var=Integer.parseInt(actualID);
       Account.setNumber(var);

        do {

            System.out.println("Select one: ");
            System.out.println("1-Save data in table.");
            System.out.println("2-Delete data from table.");
            System.out.println("3-Update data in table.");
            System.out.println("4-Show data from table.");
            System.out.println("5-Your own query.");
            System.out.println("6-Close program.");

            choose=consoleScanner.nextInt();

            switch (choose)
            {
                case 1:
                {
                    System.out.println("Click 1 to add client or 2 to add account");
                    choose=consoleScanner.nextInt();
                    if(choose==1) {
                        System.out.println("You are now adding Client");


                        String firstName, lastName, email, PESEL;
                        System.out.println("Enter: firstName,lastName,PESEL,e-mail");
                        firstName = consoleScanner.next();
                        lastName = consoleScanner.next();
                        email = consoleScanner.next();
                        PESEL = consoleScanner.next();

                        Client c = new Client(firstName, lastName, email, PESEL);

                        ClientDaoInteface clientDao = new ClientDao();
                        clientDao.save(c);

                        //Incrementing number to make next person unique
                        Client.setNumber(Client.getNumber() + 1);

                    }
                    else if(choose==2)//There may be client with many accounts
                    {
                        System.out.println("You are now adding account");
                        System.out.println("Enter id of client");
                        int id=consoleScanner.nextInt();

                        //It may not be someone with that id-exception!
                        System.out.println("Enter: Notes,Balance");
                        //exceptions!
                        String notes=consoleScanner.next();
                        consoleScanner.nextLine();

                        long balance=consoleScanner.nextLong();

                        Account a = new Account(notes,balance,id);

                        AccountDaoInteface accountDao= new AccountDao();
                        accountDao.save(a);






                        //Incremeting number to make next person unique
                        Account.setNumber(Account.getNumber()+1);


                    }


                        break;
                    }






                case 2:
                {
                    //Not implemented
                    //Numbers must be decremented
                    break;
                }

                case 3:
                {
                    //Not implemented
                    break;
                }

                case 4:
                {
                    //Not implemented
                    break;
                }
                case 5:
                {
                    //Not implemented
                    break;
                }
                case 6:
                {
                    System.out.println("Bye!");

                    consoleScanner.close();
                    //Must save actual numbers (client and account)
                    //Saving actual number of clients
                    PrintWriter printWriter =new PrintWriter("ClientID.txt");
                    printWriter.print(Client.getNumber());
                    printWriter.close();

                    //Saving for account
                    PrintWriter printWriter1=new PrintWriter("AccountID.txt");
                    printWriter1.print(Account.getNumber());
                    printWriter1.close();
                    return;
                }
                default:
                {
                    System.out.println("Incorrect choice.");
                    break;
                }
            }


        }
        while(true);















/*
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");

        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("Unable to load driver.");
            System.exit(1);
        }

        Connection connection = null;

        String URL = "jdbc:oracle:thin:@localhost:1521:XE";
        String USER = "hr";
        String PASS = "hr";

        try
        {
            connection = DriverManager.getConnection(URL, USER, PASS);
        }

        catch(SQLException e)
        {
            System.out.println("Error");
            e.printStackTrace();
        }

        Statement statement =connection.createStatement();
        ResultSet rs=statement.executeQuery("select * from JOBS");

        while(rs.next()){
            System.out.println(rs.getString(1));
        }

        connection.close();

*/
    }

}




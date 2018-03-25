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
           PrintWriter printWriter = new PrintWriter("ClientID.txt");
           printWriter.print(0);
           printWriter.close();
       }

       //reading actual clientID
        Scanner fileScanner = new Scanner(new File("ClientID.txt"));
        String actualID=fileScanner.next();
        int var=Integer.parseInt(actualID);

        //  Setting it for Client static  atribute
        //  It will be used with  constructor to make all data unique
         Client.setNumber(var);

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
                    System.out.println("Choose 1 for Client or 2 for Account");
                    choose=consoleScanner.nextInt();

                    if(choose==1)
                    {
                        String firstName,lastName,email,PESEL;
                        System.out.println("Enter: firstName,lastName,PESEL,e-mail");
                        firstName=consoleScanner.next();
                        lastName=consoleScanner.next();
                        email=consoleScanner.next();
                        PESEL=consoleScanner.next();

                        Client c = new Client(firstName,lastName,email,PESEL);

                        ClientDaoInteface clientDao= new ClientDao();
                        clientDao.save(c,"CLIENT");

                        //Incrementing number to make next person unique
                        Client.setNumber(Client.getNumber()+1);


                        break;
                    }
                    else
                        if(choose==2)
                        {
                            //Not implemented
                            break;
                        }
                        else
                        {
                            System.out.println("Bad Choice");//better exception
                            break;
                        }


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
                    fileScanner.close();
                    consoleScanner.close();
                    //Must save actual numbers (client and account)
                    //Saving actual number of clients
                    PrintWriter printWriter =new PrintWriter("ClientID.txt");
                    printWriter.print(Client.getNumber());
                    printWriter.close();
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




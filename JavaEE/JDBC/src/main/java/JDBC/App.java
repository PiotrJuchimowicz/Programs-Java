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

//Uniwersalnosc -interfejsy

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import java.io.*;

import com.sun.org.apache.xpath.internal.SourceTree;
import exceptions.DataAccessException;
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
        System.out.println("Click 0 if you run this  program for the first time.Otherwise click 1");
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

            try{


            System.out.println("Select one: ");
            System.out.println("1-Save data in table.");
            System.out.println("2-Delete data from table.");
            System.out.println("3-Update data in table.");
            System.out.println("4-Find data from table.");
            System.out.println("5-Close program.");

            choose = consoleScanner.nextInt();

            switch (choose) {
                case 1: {
                    System.out.println("Click 1 to add client or 2 to add account");
                    choose = consoleScanner.nextInt();
                    if (choose == 1) {
                        System.out.println("You are now adding Client");


                        String firstName, lastName, email, PESEL;
                        System.out.println("Enter: firstName,lastName,PESEL,e-mail");
                        firstName = consoleScanner.next();
                        lastName = consoleScanner.next();
                        email = consoleScanner.next();
                        PESEL = consoleScanner.next();

                        Client c = new Client(firstName, lastName, email, PESEL);

                        ClientDaoInteface clientDao = new ClientDao();
                        try
                        {
                            clientDao.save(c);
                        }
                        catch(DataAccessException e)
                        {
                            break;
                        }

                        //Incrementing number to make next person unique
                        Client.setNumber(Client.getNumber() + 1);


                    }
                    else if (choose == 2)//There may be client with many accounts
                    {
                        System.out.println("You are now adding Account");
                        System.out.println("Enter the client id");
                        int id = consoleScanner.nextInt();

                        //It may not be someone with that id-exception!
                        System.out.println("Enter: Notes,Balance");
                        //exceptions!
                        String notes = consoleScanner.next();
                        consoleScanner.nextLine();

                        long balance = consoleScanner.nextLong();

                        Account a = new Account(notes, balance, id);

                        AccountDaoInteface accountDao = new AccountDao();
                        try {
                            accountDao.save(a);
                        }
                        catch(DataAccessException e)
                        {
                            break;
                        }


                        //Incremeting number to make next person unique
                        Account.setNumber(Account.getNumber() + 1);


                    }


                    break;
                }


                case 2: {
                    System.out.println("Choose 1 to delete Clients or 2 to delete Accounts.");//cant update keys
                    choose = consoleScanner.nextInt();//exceptions,what is choose ==3
                    if (choose == 1) {
                        System.out.println("You are deleting Clients");
                        System.out.println("Enter client  id:");
                        int id = consoleScanner.nextInt();//exception what if there isnt client with this id

                        ClientDaoInteface clientDao = new ClientDao();
                        clientDao.delete(id);

                    } else if (choose == 2) {
                        System.out.println("You are deleting Accounts");
                        System.out.println("Enter account  id:");
                        int id = consoleScanner.nextInt();//exception what if there isnt account with this id

                        AccountDaoInteface accountDao = new AccountDao();
                        accountDao.delete(id);

                    }

                    //Numbers cant be decremented-it will generate problems with unique keys
                    break;
                }

                case 3: {
                    System.out.println("Choose 1 to update Clients or choose 2 to update Accounts");
                    choose = consoleScanner.nextInt();
                    int id;
                    if (choose == 1) {
                        System.out.println("You are updating Client");
                        System.out.println("Enter client  id:");
                        id = consoleScanner.nextInt();//this id may not exist
                        System.out.println("1-Update firstName");
                        System.out.println("2-Update lastName");
                        System.out.println("3-Update  pesel");
                        System.out.println("4-Update e-mail");
                        choose = consoleScanner.nextInt();
                        String collumn = null, newValue = null;

                        switch (choose) {
                            case 1: {

                                collumn = "firstName";
                                break;
                            }

                            case 2: {

                                collumn = "lastName";
                                break;
                            }

                            case 3: {

                                collumn = "pesel";
                                break;
                            }

                            case 4: {

                                collumn = "email";
                                break;
                            }

                            default: {
                                System.out.println("Wrong choice");
                                break;//?where goes break here
                            }

                        }

                        System.out.println("Enter new value");
                        newValue = consoleScanner.next();
                        ClientDaoInteface clientDao = new ClientDao();
                        clientDao.update(id, newValue, collumn);
                    } else if (choose == 2) {
                        System.out.println("You are updating Account");
                        System.out.println("Enter account id:");
                        id = consoleScanner.nextInt();//this id may not exist
                        System.out.println("1-Update notes");
                        System.out.println("2-Update balance");
                        choose = consoleScanner.nextInt();
                        String collumn = null;

                        switch (choose) {
                            case 1: {
                                collumn = "notes";
                                System.out.println("Enter new value");
                                String newValue = consoleScanner.next();
                                AccountDaoInteface accountDao = new AccountDao();
                                accountDao.update(id, newValue, collumn);
                                break;
                            }

                            case 2: {
                                collumn = "balance";
                                System.out.println("Enter new value");
                                Long newValue = consoleScanner.nextLong();
                                AccountDaoInteface accountDao = new AccountDao();
                                accountDao.update(id, newValue, collumn);
                                break;
                            }
                        }
                    }

                    break;
                }

                case 4: {
                    System.out.println("1-Find clients");
                    System.out.println("2-Find accounts");
                    choose = consoleScanner.nextInt();
                    int variable, id;

                    switch (choose) {
                        case 1: {

                            System.out.println("1-Find one client");
                            System.out.println("2-Find all clients");
                            variable = consoleScanner.nextInt();

                            switch (variable) {
                                case 1: {
                                    System.out.println("Enter client  id");
                                    id = consoleScanner.nextInt();
                                    ClientDaoInteface clientDao = new ClientDao();
                                    Client client = clientDao.findOne(id);
                                    if (client == null)
                                        System.out.println("error");//exceptions!
                                    else
                                        System.out.println(client.toString());
                                    break;
                                }

                                case 2: {

                                    ClientDaoInteface clientDao = new ClientDao();
                                    LinkedList<Client> list = clientDao.findAll();


                                    if (list == null) {
                                        System.out.println("error");
                                    } else {

                                        for (Client c : list)
                                            System.out.println(c.toString());

                                    }
                                    break;
                                }
                            }
                            break;
                        }

                        case 2: {
                            System.out.println("1-Find one account");
                            System.out.println("2-Find all accounts");
                            variable = consoleScanner.nextInt();

                            switch (variable) {
                                case 1: {
                                    System.out.println("Enter  account id");
                                    id = consoleScanner.nextInt();
                                    AccountDaoInteface accountDao = new AccountDao();
                                    Account account = accountDao.findOne(id);

                                    if (account == null) {
                                        System.out.println("error");//excetions

                                    } else
                                        System.out.println(account.toString());
                                    break;
                                }

                                case 2: {
                                    AccountDaoInteface accountDao = new AccountDao();
                                    LinkedList<Account> list = accountDao.findAll();

                                    if (list == null) {
                                        System.out.println("error");
                                    } else {

                                        for (Account a : list)
                                            System.out.println(a.toString());

                                    }

                                    break;
                                }
                            }
                            break;
                        }
                    }
                    break;
                }

                case 5: {
                    System.out.println("Bye!");

                    consoleScanner.close();
                    //Must save actual numbers (client and account)
                    //Saving actual number of clients
                    PrintWriter printWriter = new PrintWriter("ClientID.txt");
                    printWriter.print(Client.getNumber());
                    printWriter.close();

                    //Saving for account
                    PrintWriter printWriter1 = new PrintWriter("AccountID.txt");
                    printWriter1.print(Account.getNumber());
                    printWriter1.close();
                    return;
                }
                default: {
                    System.out.println("Incorrect choice.");
                    break;
                }
            }

        }

        catch(InputMismatchException e)
        {
            e.printStackTrace();
            System.out.println("Incorrect input data");
        }

        catch (NullPointerException e)
        {
            e.printStackTrace();
            System.out.println("Error");
        }

        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Other error");
        }

        }
        while(true);
    }
}




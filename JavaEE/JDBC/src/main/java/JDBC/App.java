package JDBC;

import java.sql.SQLException;
import java.util.*;


import exceptions.DataAccessException;
import models.*;
import Dao.*;

public class App {
    public static void main(String[] args) {
        // Client may have more than one Account
        Scanner consoleScanner = new Scanner(System.in);
        int choose;
        do {

            try {

                System.out.println("Select one: ");
                System.out.println("0-Initiate the database.(It will delete existing tables!");
                System.out.println("1-Save data in table.");
                System.out.println("2-Delete data from table.");
                System.out.println("3-Update data in table.");
                System.out.println("4-Find data from table.");
                System.out.println("5-Close program.");

                choose = consoleScanner.nextInt();

                switch (choose) {
                    case 0: {
                        InitDaoInterface dao = new InitOracleDao();
                        {
                            try {
                                dao.initDatabase();
                            } catch (DataAccessException e) {
                                e.printStackTrace();
                                break;
                            }

                        }
                        break;
                    }
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
                            try {
                                clientDao.save(c);
                            } catch (DataAccessException e) {
                                System.out.println("Error");
                                break;
                            }

                        } else if (choose == 2)//There may be client with many accounts
                        {
                            System.out.println("You are now adding Account");
                            System.out.println("Enter the client id");
                            int id = consoleScanner.nextInt();


                            System.out.println("Enter: Notes,Balance");

                            String notes = consoleScanner.next();
                            consoleScanner.nextLine();

                            long balance = consoleScanner.nextLong();

                            Account a = new Account(notes, balance, id);

                            AccountDaoInteface accountDao = new AccountDao();
                            try {
                                accountDao.save(a);
                            } catch (DataAccessException e) {
                                System.out.println("Error");
                                break;
                            }
                        }

                        break;
                    }


                    case 2: {
                        System.out.println("Choose 1 to delete Clients or 2 to delete Accounts.");
                        choose = consoleScanner.nextInt();
                        if (choose == 1) {
                            System.out.println("You are deleting Clients");
                            System.out.println("Enter client  id:");
                            int id = consoleScanner.nextInt();

                            ClientDaoInteface clientDao = new ClientDao();
                            clientDao.delete(id);

                        } else if (choose == 2) {
                            System.out.println("You are deleting Accounts");
                            System.out.println("Enter account  id:");
                            int id = consoleScanner.nextInt();

                            AccountDaoInteface accountDao = new AccountDao();
                            accountDao.delete(id);

                        } else {
                            System.out.println("Invalid choose.");
                        }


                        break;
                    }

                    case 3: {
                        System.out.println("Choose 1 to update Clients or choose 2 to update Accounts");
                        choose = consoleScanner.nextInt();
                        int id;
                        if (choose == 1) {
                            System.out.println("You are updating Client");
                            System.out.println("Enter client  id:");
                            id = consoleScanner.nextInt();
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
                                    break;
                                }

                            }

                            System.out.println("Enter new value");
                            newValue = consoleScanner.next();
                            ClientDaoInteface clientDao = new ClientDao();
                            clientDao.update(id, newValue, collumn);
                        } else if (choose == 2) {
                            System.out.println("You are updating Account");
                            System.out.println("Enter account id:");
                            id = consoleScanner.nextInt();
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
                                            System.out.println("error");
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
                                            System.out.println("error");

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
                        return;
                    }
                    default: {
                        System.out.println("Incorrect choice.");
                        break;
                    }
                }

            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.println("Incorrect input data");
            } catch (NullPointerException e) {
                e.printStackTrace();
                System.out.println("Error");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Other error");
            }

        }
        while (true);
    }
}




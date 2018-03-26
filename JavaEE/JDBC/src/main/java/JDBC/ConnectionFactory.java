package JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Klasa udostępniająca połączenia z bazą danych
public class ConnectionFactory
{

    public static Connection getConnection()
    {
        try
        {
            //Loading driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("Unable to load driver");
            return null;
        }



        String URL = "jdbc:oracle:thin:@localhost:1521:XE";

        Connection connection=null;

        try
        {
            //Creating connection object
            connection = DriverManager.getConnection(URL, "hr", "hr");
        }

        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Unable to create connection object.");
            return null;
        }

        return  connection;

    }
















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

*/



}

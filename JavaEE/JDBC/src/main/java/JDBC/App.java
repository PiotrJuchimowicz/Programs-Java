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

import java.sql.*;
public class App 
{
    public static void main( String[] args )throws  SQLException
    {


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


    }

}




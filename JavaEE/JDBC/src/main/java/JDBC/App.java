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
    public static void main( String[] args )
    {


        Connection conn = ConnectionFactory.getConnection();
    }

}




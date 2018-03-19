package JDBC;

import org.apache.derby.jdbc.ClientDataSource;

import java.sql.*;
import java.util.*;
//Klasa udostępniająca połączenia z bazą danych
public class ConnectionFactory
{
    private ClientDataSource ds;

    public  ConnectionFactory() {
        ds = new ClientDataSource();
        ds.setDatabaseName("mydb");
        ds.setUser("app");
        ds.setPassword("app");
        ds.setPortNumber(1527);
        ds.setServerName("localhost");
    }

    private static class SingletonHolder {
        private static final ConnectionFactory INSTANCE = new ConnectionFactory();
    }

    public static ConnectionFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static Connection getConnection() {
        try {
            return getInstance().ds.getConnection();
        } catch (SQLException ex) {
            throw new DataAccessException(ex);
        }
    }
}

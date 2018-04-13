package Dao;

import JDBC.ConnectionFactory;
import exceptions.DataAccessException;
import models.Account;


import java.sql.*;
import java.util.LinkedList;

public class AccountDao implements AccountDaoInteface {
    public void save(Account a) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        if (connection == null) {
            System.out.println("Unable to get  connection with DB");
            throw new DataAccessException();
        }
        //  SQL query
        String sql = "INSERT INTO " + "ACCOUNT" + " VALUES (DEFAULT,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {

            System.out.println("Unable to create statement");
            throw new DataAccessException(e);
        }

        // data preparation
        preparedStatement.setString(1, a.getNotes());
        preparedStatement.setLong(2, a.getBalance());
        //Setting foreign key
        preparedStatement.setInt(3, a.getId_client());

        // execute insert SQL stetement
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            System.out.println("Unable to execute query.");
            throw new DataAccessException(e);
        }

        preparedStatement.close();
        connection.close();
    }

    public void delete(int identity) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        if (connection == null) {
            System.out.println("Unable to get  connection with DB");
            return;
        }

        // SQL querry
        String sql = "DELETE FROM ACCOUNT WHERE ID=?";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Unable to create statement");
            return;
        }
        statement.setInt(1, identity);
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Unable to execute query");
            return;
        }
        statement.close();
        connection.close();
    }

    public void update(int id, Object newValue, String whatToUpdate) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();

        if (connection == null) {
            System.out.println("Unable to get  connection with DB");
            return;
        }

        String sql = null;
        PreparedStatement preparedStatement = null;

        if (newValue instanceof Long) {
            long balance = (Long) newValue;
            sql = "UPDATE Account SET Balance=? WHERE ID=" + id;

            try {
                preparedStatement = connection.prepareStatement(sql);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Unable to create statement");
                return;
            }

            preparedStatement.setLong(1, balance);


        } else if (newValue instanceof String) {
            String notes = (String) newValue;
            sql = "UPDATE Account SET NOTES=? WHERE ID=" + id;

            try {
                preparedStatement = connection.prepareStatement(sql);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Unable to create statement");
                return;
            }

            preparedStatement.setString(1, notes);

        }
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Unable to execute query");
            return;
        }
        preparedStatement.close();
        connection.close();


    }

    public Account findOne(int id) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        if (connection == null) {
            System.out.println("Unable to get  connection with DB");
            return null;
        }

        Statement statement = connection.createStatement();
        String sql = "Select * From ACCOUNT Where id=" + id;

        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Unable to execute query");
            return null;
        }

        Account account = null;

        //Movies cursor to the first row
        if (resultSet.next()) {
            int accountId = resultSet.getInt("ID");
            String accountNotes = resultSet.getString("NOTES");
            long accountBalance = resultSet.getLong("BALANCE");
            int accountForeignKey = resultSet.getInt("ID_CLIENT");

            resultSet.close();
            connection.close();

            account = new Account(accountId, accountNotes, accountBalance, accountForeignKey);


        }
        return account;
    }

    public LinkedList<Account> findAll() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        if (connection == null) {
            System.out.println("Unable to get  connection with DB");
            return null;
        }

        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM ACCOUNT";

        ResultSet resultSet = null;

        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Unable to execute query");
            return null;
        }


        LinkedList<Account> list = new LinkedList<>();

        while ((resultSet.next())) {
            int accountId = resultSet.getInt("ID");
            String accountNotes = resultSet.getString("NOTES");
            long accountBalance = resultSet.getLong("BALANCE");
            int accountForeignKey = resultSet.getInt("ID_CLIENT");

            Account account = new Account(accountId, accountNotes, accountBalance, accountForeignKey);

            list.add(account);
        }

        resultSet.close();
        connection.close();

        return list;
    }
}

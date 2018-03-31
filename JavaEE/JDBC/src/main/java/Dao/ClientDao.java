package Dao;

import JDBC.ConnectionFactory;
import exceptions.DataAccessException;
import models.Client;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ClientDao implements  ClientDaoInteface
{
    public void save(Client t) throws  SQLException
    {

        Connection connection= ConnectionFactory.getConnection();
        if(connection==null)
        {
            System.out.println("Unable to get  connection with DB");
            throw  new DataAccessException();
        }
        //  SQL query
        String sql="INSERT INTO " +"CLIENT"+ " VALUES (DEFAULT ,?,?,?,?)";
        PreparedStatement preparedStatement=null;
        try
        {
             preparedStatement = connection.prepareStatement(sql);
        }

        catch (SQLException e)
        {

            System.out.println("Unable to create statement");
            throw new DataAccessException(e);
        }

        // data preparation
        preparedStatement.setString(1,t.getFirstName() );
        preparedStatement.setString(2,t.getLastName() );
        preparedStatement.setString(3,t.getPesel() );
        preparedStatement.setString(4,t.getEmail() );

        // execute insert SQL stetement

        try {

            preparedStatement.executeUpdate();


        }
        catch(SQLException e)
        {

            System.out.println("Unable to execute query");
            throw new DataAccessException(e);
        }


        preparedStatement.close();
        connection.close();

    }

    public void delete(int identity)throws  SQLException
    {
        Connection connection= ConnectionFactory.getConnection();
        if(connection==null)
        {
            System.out.println("Unable to get  connection with DB");
            return;
        }

        // SQL querry
        String sql="DELETE  FROM  CLIENT Where ID = ? ";

        PreparedStatement statement=null;
        try
        {
            statement=connection.prepareStatement(sql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Unable to create statement");
            return;
        }
        statement.setInt(1,identity );
        try {

            statement.executeUpdate();


        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Unable to execute query");
            return;
        }
        statement.close();
        connection.close();
    }

    public void update(int id,String newValue,String whatToUpdate) throws  SQLException
    {
        Connection connection= ConnectionFactory.getConnection();
        if(connection==null)
        {
            System.out.println("Unable to get  connection with DB");
            return;
        }


        String sql=null;
        PreparedStatement preparedStatement =null;
        if(whatToUpdate.toUpperCase().equals("FIRSTNAME"))
        {
            sql="UPDATE CLIENT SET FIRSTNAME=? WHERE ID="+id;
        }
        else  if(whatToUpdate.toUpperCase().equals("LASTNAME"))
        {
            sql="UPDATE CLIENT SET LASTNAME=? WHERE ID="+id;
        }

        else  if(whatToUpdate.toUpperCase().equals("PESEL"))
        {
            sql="UPDATE CLIENT SET PESEL=? WHERE ID="+id;
        }
        else  if(whatToUpdate.toUpperCase().equals("EMAIL"))
        {
            sql="UPDATE CLIENT SET EMAIL=? WHERE ID="+id;
        }

        try
        {
            preparedStatement=connection.prepareStatement(sql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Unable to create statement");
            return;
        }


        preparedStatement.setString(1,newValue);

        try {
            preparedStatement.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Unable to execute query");
            return;
        }
        preparedStatement.close();
        connection.close();


    }

    public Client findOne(int id) throws  SQLException {
        Connection connection = ConnectionFactory.getConnection();
        if (connection == null) {
            System.out.println("Unable to get  connection with DB");
            return null;
        }


        Statement statement = connection.createStatement();
        String sql = "Select * From Client Where id=" + id;

        ResultSet resultSet=null;
        try {
             resultSet = statement.executeQuery(sql);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Unable to execute query");
            return null;
        }

        Client client=null;

        //Movies cursor to the first row
        if (resultSet.next()) {
            int clientId = resultSet.getInt("ID");
            String clientFirstName = resultSet.getString("FIRSTNAME");
            String clientLastName = resultSet.getString("LASTNAME");
            String clientPesel = resultSet.getString("PESEL");
            String clientEmail = resultSet.getString("EMAIL");

            resultSet.close();
            connection.close();

            client = new Client(clientId, clientFirstName, clientLastName, clientPesel, clientEmail);//exceptions!


        }
        return client;
    }




    public LinkedList<Client> findAll()throws SQLException
    {
        Connection connection= ConnectionFactory.getConnection();
        if(connection==null)
        {
            System.out.println("Unable to get  connection with DB");
            return null;
        }

        Statement statement=connection.createStatement();
        String sql="Select * From Client";

        ResultSet resultSet=null;

        try {
            resultSet = statement.executeQuery(sql);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Unable to execute query");
            return null;
        }


        LinkedList<Client> list = new LinkedList<>();

        while ((resultSet.next()))
        {
            int clientId = resultSet.getInt("ID");
            String clientFirstName = resultSet.getString("FIRSTNAME");
            String clientLastName = resultSet.getString("LASTNAME");
            String clientPesel = resultSet.getString("PESEL");
            String clientEmail = resultSet.getString("EMAIL");

            Client client= new Client(clientId,clientFirstName,clientLastName,clientPesel,clientEmail);//exceptions!

            list.add(client);
        }

        resultSet.close();
        connection.close();

        return  list;


    }
}

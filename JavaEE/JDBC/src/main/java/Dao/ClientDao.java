package Dao;

import JDBC.ConnectionFactory;
import models.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ClientDao implements  ClientDaoInteface
{
    public void save(Client t) throws  SQLException
    {
        Connection connection= ConnectionFactory.getConnection();
        if(connection==null)
        {
            System.out.println("Unable to get  connection with DB");
            return;
        }
        //  SQL query
        String sql="INSERT INTO " +"CLIENT"+ " VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement=null;
        try
        {
             preparedStatement = connection.prepareStatement(sql);
        }

        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Unable to create statement");
            return;
        }

        // data preparation
        preparedStatement.setInt(1,t.getId() );
        preparedStatement.setString(2,t.getFirstName() );
        preparedStatement.setString(3,t.getLastName() );
        preparedStatement.setString(4,t.getPesel() );
        preparedStatement.setString(5,t.getEmail() );

        // execute insert SQL stetement
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

    }

    public void delete(int id)throws  SQLException
    {
        Connection connection= ConnectionFactory.getConnection();
        if(connection==null)
        {
            System.out.println("Unable to get  connection with DB");
            return;
        }

        // SQL querry
        String sql="DELETE FROM CLIENT WHERE ID="+id;

        Statement statement=null;
        try
        {
            statement=connection.createStatement();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Unable to create statement");
            return;
        }

        statement.executeUpdate(sql);
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
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();


    }
}

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
    public void save(Client t,String table) throws  SQLException
    {
        Connection connection= ConnectionFactory.getConnection();
        if(connection==null)
        {
            System.out.println("Unable to get  connection with DB");
            return;
        }
        //  SQL query
        String sql="INSERT INTO " +table+ " VALUES (?,?,?,?,?)";
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

        connection.close();


        





    }
}

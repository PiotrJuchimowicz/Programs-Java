package JDBC;

import models.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientDao
{
    public void save(Client t) throws  SQLException
    {
        Connection connection= ConnectionFactory.getConnection();
        if(connection==null)
        {
            System.out.println("Unable to get  connection with DB");
            return;
        }

        Statement statement=null;
        try
        {
             statement = connection.createStatement();
        }

        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Unable to create statement");
            return;
        }


        





    }
}

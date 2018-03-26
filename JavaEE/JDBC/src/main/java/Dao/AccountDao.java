package Dao;

import JDBC.ConnectionFactory;
import models.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDao implements  AccountDaoInteface
{
    public void save(Account a) throws SQLException
    {
        Connection connection= ConnectionFactory.getConnection();
        if(connection==null)
        {
            System.out.println("Unable to get  connection with DB");
            return;
        }
        //  SQL query
        String sql="INSERT INTO " +"ACCOUNT"+ " VALUES (?,?,?,?)";
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
        preparedStatement.setInt(1,a.getId() );
        preparedStatement.setString(2,a.getNotes() );
        preparedStatement.setLong(3,a.getBalance() );
        //Setting foreign key

        preparedStatement.setInt(4,a.getId_client() );

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
        String sql="DELETE FROM ACCOUNT WHERE ID="+id;

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

    public void update(int id,Object newValue,String whatToUpdate)throws  SQLException
    {
        Connection connection=ConnectionFactory.getConnection();

        if(connection==null)
        {
            System.out.println("Unable to get  connection with DB");
            return;
        }

        String sql=null;
        PreparedStatement preparedStatement=null;

        if(newValue instanceof Long)
        {
            long balance= (Long) newValue;
            sql="UPDATE Account SET Balance=? WHERE ID="+id;

            try
            {
                preparedStatement=connection.prepareStatement(sql);
            }

            catch(SQLException e)
            {
                e.printStackTrace();
                System.out.println("Unable to create statement");
                return;
            }

            preparedStatement.setLong(1,balance);


        }

        else if(newValue instanceof  String)
        {
            String notes= (String)newValue;
            sql="UPDATE Account SET NOTES=? WHERE ID="+id;

            try
            {
                preparedStatement=connection.prepareStatement(sql);
            }

            catch(SQLException e)
            {
                e.printStackTrace();
                System.out.println("Unable to create statement");
                return;
            }

            preparedStatement.setString(1,notes);

        }

        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();


    }
}

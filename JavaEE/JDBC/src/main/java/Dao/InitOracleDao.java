package Dao;

import JDBC.ConnectionFactory;
import exceptions.DataAccessException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitOracleDao implements InitDaoInterface {
    public void initDatabase() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        if (connection == null) {
            System.out.println("Unable to get  connection with DB");
            throw new DataAccessException();
        }
        Statement s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
        s1 = connection.createStatement();
        s2 = connection.createStatement();
        s3 = connection.createStatement();
        s4 = connection.createStatement();
        s5 = connection.createStatement();
        s6 = connection.createStatement();
        s7 = connection.createStatement();
        s8 = connection.createStatement();
        s9 = connection.createStatement();
        s10 = connection.createStatement();

        String sql1, sql2, sql3, sql4, sql5, sql6, sql7, sql8, sql9, sql10;
        sql1 = "CREATE TABLE Client( " +
                "          id INTEGER PRIMARY KEY , " +
                "          firstName VARCHAR(50), " +
                "          lastName VARCHAR (50), " +
                "          pesel VARCHAR (11) UNIQUE NOT NULL , " +
                "          email VARCHAR (50) )";

        sql2 = "CREATE TABLE Account (\n" +
                "          id INTEGER PRIMARY KEY ,\n" +
                "          notes VARCHAR(255),\n" +
                "          balance NUMBER(19),\n" +
                "          id_client INTEGER CONSTRAINT fk_client REFERENCES CLIENT(ID) ON DELETE CASCADE)\n" +
                "         ";
        sql3 = "CREATE  SEQUENCE client_id_seq";
        sql4 = "CREATE  SEQUENCE account_id_seq";
        sql5 = "CREATE  OR REPLACE TRIGGER trg_client_id\n" +
                "          BEFORE INSERT ON CLIENT\n" +
                "          FOR EACH ROW\n" +
                "          BEGIN\n" +
                "          SELECT client_id_seq.nextval\n" +
                "          INTO :new.id\n" +
                "          FROM dual;\n" +
                "          END;\n";

        sql6 = "CREATE OR REPLACE  TRIGGER trg_account_id\n" +
                "          BEFORE INSERT ON  ACCOUNT\n" +
                "          FOR EACH ROW\n" +
                "          BEGIN\n" +
                "          SELECT account_id_seq.nextval\n" +
                "          INTO :new.id\n" +
                "          FROM dual;\n" +
                "          END;\n";


        sql7 = "DROP TABLE ACCOUNT";
        sql8 = "DROP TABLE CLIENT";
        sql9 = "DROP SEQUENCE CLIENT_ID_SEQ";
        sql10 = "DROP SEQUENCE ACCOUNT_ID_SEQ";

        //If tables already exists
        try {

            s9.executeUpdate(sql9);

            s10.executeUpdate(sql10);

            s7.executeUpdate(sql7);

            s8.executeUpdate(sql8);


        } catch (Throwable e) {


        } finally {
            s7.close();
            s8.close();
            s9.close();
            s10.close();
        }


        try {
            s1.executeUpdate(sql1);
            s2.executeUpdate(sql2);
            s3.executeUpdate(sql3);
            s4.executeUpdate(sql4);
            s5.executeUpdate(sql5);
            s6.executeUpdate(sql6);


        } catch (SQLException e) {

            System.out.println("Error with creating database");


        } finally {
            s1.close();
            s2.close();
            s3.close();
            s4.close();
            s5.close();
            s6.close();
            connection.close();

        }


    }
}

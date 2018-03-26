package Dao;

import models.Client;

import java.sql.SQLException;
import java.util.*;

public interface ClientDaoInteface
{

    void save(Client t) throws SQLException;
    void delete (int id) throws  SQLException;
    void update (int id,String newValue,String whatToUpdate)throws  SQLException;
    Client findOne(int id) throws  SQLException;
    LinkedList<Client> findAll()throws SQLException;

}

package Dao;

import models.Client;

import java.sql.SQLException;

public interface ClientDaoInteface
{

    void save(Client t,String table) throws SQLException;
    //void delete (Client t);
    //void update (Client t);
    //Client findById(Integer id);
    //List<Client> findAll();
}

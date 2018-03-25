package Dao;

import models.Client;

import java.sql.SQLException;

public interface ClientDaoInteface
{

    void save(Client t) throws SQLException;
    void delete (int id) throws  SQLException;
    void update (int id,String newValue,String whatToUpdate)throws  SQLException;
    //Client findById(Integer id);
    //List<Client> findAll();
}

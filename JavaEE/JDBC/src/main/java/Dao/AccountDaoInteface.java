package Dao;

import models.Account;

import java.sql.SQLException;

public interface AccountDaoInteface
{
    void save(Account a) throws SQLException;
    void delete (int id) throws  SQLException;
    void update (int id,Object newValue,String whatToUpdate);
    //Client findById(Integer id);
    //List<Client> findAll();
}

package Dao;

import models.Account;
import sun.awt.image.ImageWatched;

import java.sql.SQLException;
import java.util.LinkedList;

public interface AccountDaoInteface
{
    void save(Account a) throws SQLException;
    void delete (int id) throws  SQLException;
    void update (int id,Object newValue,String whatToUpdate) throws  SQLException;
    Account findOne (int id) throws  SQLException;
    LinkedList<Account> findAll() throws  SQLException;
}

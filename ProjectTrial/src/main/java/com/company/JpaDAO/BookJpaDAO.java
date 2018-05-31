package com.company.JpaDAO;

import com.company.Models.BookDTO;

public interface BookJpaDAO {
    //TODO
    void add(BookDTO b);
    BookDTO get(long id);

}

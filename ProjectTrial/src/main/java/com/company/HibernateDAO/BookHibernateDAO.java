package com.company.HibernateDAO;

import com.company.JpaDAO.BookJpaDAO;
import com.company.Models.BookDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BookHibernateDAO implements BookJpaDAO {
    @Override
    public void add(BookDTO b) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(b);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Override
    public BookDTO get(long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        BookDTO b = em.find(BookDTO.class, id);
        em.getTransaction().commit();
        em.close();
        emf.close();

        return  b;
    }
    //TODO
}

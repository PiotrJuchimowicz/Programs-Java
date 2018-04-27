package com.company.Hibernate;

import com.company.Factory.JpaFactory;
import com.company.JPA.ProductDao;
import com.company.Models.ProductDTO;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class ProductJpaDao extends GenericJpaDao<ProductDTO, Long> implements ProductDao {
    @Override
    public List<ProductDTO> findInRange(double parA, double parB) {
        EntityManager em = JpaFactory.getEntityManager();

        TypedQuery<ProductDTO> query = em.createNamedQuery("findInRange", ProductDTO.class);
        query.setParameter(1, parA);
        query.setParameter(2, parB);
        List<ProductDTO> resultList = query.getResultList();
        em.close();
        JpaFactory.closeEntityManagerFactory();
        return resultList;


    }

    @Override
    public ProductDTO findTheExpensivest() {
        EntityManager em = JpaFactory.getEntityManager();
        TypedQuery<ProductDTO> query = em.createNamedQuery("findTheExpensivest", ProductDTO.class);

        ProductDTO result = query.getSingleResult();


        em.close();
        JpaFactory.closeEntityManagerFactory();

        return result;
    }

    @Override
    public List<ProductDTO> findWithoutPurchase() {
        EntityManager em = JpaFactory.getEntityManager();
        TypedQuery<ProductDTO> query = em.createNamedQuery("findWithoutPurchase",ProductDTO.class);

        List<ProductDTO> result = query.getResultList();


        em.close();
        JpaFactory.closeEntityManagerFactory();

        return  result;

    }

    @Override
    public List<ProductDTO> findWithMostPieces()
    {
        EntityManager em = JpaFactory.getEntityManager();
        TypedQuery<ProductDTO> query = em.createNamedQuery("findWithMostPieces",ProductDTO.class);

        List<ProductDTO> result =query.getResultList();

        em.close();
        JpaFactory.closeEntityManagerFactory();

        return  result;
    }

    @Override
    public List<Long>  test()
    {
        EntityManager em = JpaFactory.getEntityManager();

        TypedQuery<Long> q= em.createNamedQuery("test", Long.class);
       List<Long> result = q.getResultList();
        em.close();
        JpaFactory.closeEntityManagerFactory();

        return  result;
    }

}

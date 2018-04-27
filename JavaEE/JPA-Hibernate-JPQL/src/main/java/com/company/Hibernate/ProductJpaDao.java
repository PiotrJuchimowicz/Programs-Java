package com.company.Hibernate;

import com.company.Factory.JpaFactory;
import com.company.JPA.ProductDao;
import com.company.Models.ProductDTO;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Type;
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
        TypedQuery<Integer> query1=em.createQuery("Select max(d.product.purchaseItems.size) From PurchaseItemDTO d group by d.product.id Order By(max(d.product.purchaseItems.size ))DESC ",Integer.class);
        query1.setFirstResult(0);
        query1.setMaxResults(1);
        Integer pom = query1.getSingleResult();
        Long l = new Long(pom);
        query.setParameter("subquerry",l);
        List<ProductDTO> result =query.getResultList();
        em.close();
        JpaFactory.closeEntityManagerFactory();

        return  result;
    }

    @Override
    public void bulkUpdate(Integer percent)
    {
        EntityManager em = JpaFactory.getEntityManager();

        Query query = em.createNamedQuery("changePrice");
        query.setParameter("percent",percent);
        em.getTransaction().begin();
        query.executeUpdate();
        em.getTransaction().commit();


        em.close();
        JpaFactory.closeEntityManagerFactory();
    }



}

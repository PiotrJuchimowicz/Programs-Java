package com.company.Hibernate;

import com.company.Factory.JpaFactory;
import com.company.JPA.CustomerDao;
import com.company.Models.CustomerDTO;
import com.company.Models.ProductDTO;
import com.company.Models.PurchaseDTO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

public class CustomerJpaDao extends GenericJpaDao<CustomerDTO, Long> implements CustomerDao {
    @Override
    public List <CustomerDTO> findByLastName(String param) {
        EntityManager em = JpaFactory.getEntityManager();

        TypedQuery<CustomerDTO> query = em.createNamedQuery("findByLastName",CustomerDTO.class);
        query.setParameter("name",param);

        List<CustomerDTO> result= query.getResultList();



        em.close();
        JpaFactory.closeEntityManagerFactory();

        return result;

    }

    @Override
    public  List<PurchaseDTO> findHisPurchases(long id)
    {
        EntityManager em = JpaFactory.getEntityManager();
        TypedQuery<PurchaseDTO>  query = em.createNamedQuery("findHisPurchases", PurchaseDTO.class);
        query.setParameter(1,id);
        List<PurchaseDTO> result = query.getResultList();



        em.close();
        JpaFactory.closeEntityManagerFactory();

        return result;

    }




}

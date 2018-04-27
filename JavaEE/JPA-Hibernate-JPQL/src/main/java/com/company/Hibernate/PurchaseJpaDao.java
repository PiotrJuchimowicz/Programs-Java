package com.company.Hibernate;

import com.company.Factory.JpaFactory;
import com.company.JPA.PurchaseDao;
import com.company.Models.PurchaseDTO;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

public class PurchaseJpaDao extends GenericJpaDao<PurchaseDTO, Long> implements PurchaseDao {
    @Override
    public List<PurchaseDTO> selectAllPurchases() {

        EntityManager em = JpaFactory.getEntityManager();

        Query query = em.createNamedQuery("selectAllPurchases", PurchaseDTO.class);

        List<PurchaseDTO> result = query.getResultList();


        em.close();
        JpaFactory.closeEntityManagerFactory();
        return result;
    }

    @Override
    public List<PurchaseDTO> selectAllPurchasesV2() {
        EntityManager em = JpaFactory.getEntityManager();

        Query query = em.createNamedQuery("selectAllPurchasesV2", PurchaseDTO.class);

        List<PurchaseDTO> result = query.getResultList();


        em.close();
        JpaFactory.closeEntityManagerFactory();
        return result;
    }
}

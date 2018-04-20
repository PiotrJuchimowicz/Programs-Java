package com.company.Factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//VERY CLEVER :)
public class JpaFactory {

    private static JpaFactory instance;
    private EntityManagerFactory emf;

    private JpaFactory() {
        emf = Persistence.createEntityManagerFactory("mydatabase");
    }

    private static JpaFactory getInstanance() {
        if (instance == null) {
            instance = new JpaFactory();
        }
        return instance;
    }

    public static EntityManager getEntityManager() {
        return getInstanance().emf.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        if (instance != null) {
            instance.emf.close();
            instance = null;
        }
    }
}

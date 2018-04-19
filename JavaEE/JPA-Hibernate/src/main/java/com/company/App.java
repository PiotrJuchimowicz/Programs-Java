package com.company;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//One Customer can have Many Purchases
//One Purchase can have Many PurchaseItems
//One Product can have Many Purchase Items

public class App
{
    public static void main( String[] args )

    {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("mydatabase");
        EntityManager entityManager= entityManagerFactory.createEntityManager();



        entityManager.close();
        entityManagerFactory.close();
    }
}

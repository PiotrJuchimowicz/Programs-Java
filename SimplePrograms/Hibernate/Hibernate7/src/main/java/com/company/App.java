package com.company;

import OneToOneBidirectional.Address;
import OneToOneBidirectional.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Address and Employee in relation OneToOne(BiDirectional)
//Phone and Worker in relation OneToMany(BiDirectional)
//ZOO and Animal in relation OneToMany(Unidirectional)
public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Address address = new Address("Zwierzyniecka", "Bialystok", 10);
        Employee employee = new Employee("Jan", "Kowalski", 1234, address);
        entityManager.persist(employee);

        entityManager.getTransaction().begin();

        entityManager.persist(address);
        entityManager.persist(employee);

        //entityManager.remove(entityManager.find(Address.class,4L));
        //entityManager.remove(entityManager.find(Employee.class,3L));


        entityManager.getTransaction().commit();


        entityManager.close();
        entityManagerFactory.close();
    }
}


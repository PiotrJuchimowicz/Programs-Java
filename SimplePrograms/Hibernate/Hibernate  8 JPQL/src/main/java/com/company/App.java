package com.company;

import com.company.Models.Employee;
import javax.persistence.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class App {
    public static void main(String[] args) {
        //addEmployees();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        /*
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where id=2 ", Employee.class);
        Employee employee = query.getSingleResult();// or querry.getResultList() while more than one employee
        System.out.println(employee.toString());

        Query query1 = entityManager.createQuery("select  e from  Employee e ");
        List <Employee> list = query1.getResultList();

        for(Employee e : list)
            System.out.println(e.toString());
        */
        Query query2 = entityManager.createQuery("select  concat(e.firstName,' ',e.lastName,' ',e.salary * 0.2) from Employee e");
        List<Object> list = query2.getResultList();


        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            System.out.println(o.toString());
        }


        entityManager.close();
        entityManagerFactory.close();
    }



    private static void addEmployees() {
        addEmployee("Karol", "Mateusiak", 2633);
        addEmployee("Marika", "Bednarek", 2345);
        addEmployee("Jan", "Mateusiak", 7346);
        addEmployee("Daria", "Kowalska", 2352);
        addEmployee("Monika", "Ucińska", 4263);
        addEmployee("Ernest", "Pająk", 2634);
        addEmployee("Kamil", "Stępień", 2345);
        addEmployee("Przemek", "Maciejewski", 5433);
        addEmployee("Robert", "Woźniak", 3324);
        addEmployee("Agnieszka", "Nowak", 2000);
        addEmployee("Angelika", "Bednarska", 1000);
    }

    private static void addEmployee(String firstName, String lastName,
                                    double salary) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setSalary(salary);

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
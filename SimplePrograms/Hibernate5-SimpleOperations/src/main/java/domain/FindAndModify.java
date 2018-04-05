package domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindAndModify
{
    public static void main(String args[])
    {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("mySchema");
        EntityManager entityManager=entityManagerFactory.createEntityManager();


        entityManager.getTransaction().begin();

        Employee employee=entityManager.find(Employee.class,1L);
        System.out.println(employee.toString());
        employee.setSalary(20000);

         entityManager.getTransaction().commit();


        entityManager.close();
        entityManagerFactory.close();
    }
}

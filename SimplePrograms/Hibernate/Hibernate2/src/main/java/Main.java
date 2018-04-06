import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main
{
    public static void main(String args[])
    {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee=new Employee();
        employee.setFirstName("Piotr");
        employee.setLastName("Juchimowicz");
        employee.setSalary(10000);
        employee.setLocality("Warszawa");
        employee.setZipcode("1234");
        employee.setStreet("Prosta");
        employee.setStreetNumber(12);

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();



        entityManager.close();
        entityManagerFactory.close();
    }
}

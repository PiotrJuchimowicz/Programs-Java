import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main
{
    public static void main(String args [])
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mySchema");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(new Employee("Piotr","Juchimowicz",2000));

        entityManager.getTransaction().commit();



        entityManager.close();
        entityManagerFactory.close();
    }
}

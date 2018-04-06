
import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main
{
    public  static  void main(String args[])
    {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("mySchema");
        EntityManager entityManager=entityManagerFactory.createEntityManager();

        Employee employee= new Employee("Piotr","Juchimowicz",8000);

        entityManager.getTransaction().begin();
        entityManager.persist(employee);

        entityManager.getTransaction().commit();


        entityManager.close();
        entityManagerFactory.close();

    }
}

import domain.Address;
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
        Address address = new Address("Warszawa","avsd","Dluga",10);
        Employee employee= new Employee("Piotr","Juchimowicz",8000,address);

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.persist(address);
        entityManager.getTransaction().commit();


        entityManager.close();
        entityManagerFactory.close();

    }
}

import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main
{
    public  static  void main(String [] args)
    {
       EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager= entityManagerFactory.createEntityManager();

        Employee employee = new Employee();
        //employee.setId(1);
        employee.setFirstName("Piotr");
        employee.setLastName("Juchimowicz");
        employee.setSalary(20000);

        Employee employee2 = new Employee();
        //employee.setId(2);
        employee2.setFirstName("Iwona");
        employee2.setLastName("Strubczewska");
        employee2.setSalary(20000);

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.persist(employee2);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}

import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;
import domain.Address;
import domain.Employee;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;

import javax.persistence.*;

public class Main
{
    public static void main(String args[])
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = new Employee();
        employee.setSalary(12);
        employee.setLastName("piotr");
        employee.setFirstName("kuba");
        Address address = new Address();
        address.setLocality("warszawa");
        address.setStreet("Dluga");
        address.setStreetNumber(12);
        address.setZipcode("asdw");
        employee.setAddress(address);

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();


        entityManager.close();
        entityManagerFactory.close();
    }
}

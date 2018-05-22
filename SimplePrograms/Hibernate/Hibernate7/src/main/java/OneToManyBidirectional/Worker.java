package OneToManyBidirectional;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private double salary;
    //One worker can have many phones
    @OneToMany(mappedBy = "worker")//One Worker to Many Phones
    private List<Phone> phones;//For use in Java program

    public Worker(String firstName, String lastName, double salary, List<Phone> phones) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.phones = phones;
    }

    public Worker() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}

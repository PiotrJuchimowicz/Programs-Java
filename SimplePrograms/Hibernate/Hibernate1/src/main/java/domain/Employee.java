package domain;


import javax.persistence.*;

@Entity
@Table(name = "Pracownik")
public class Employee
{
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;
    @Column(name="imie",length = 20)
    private  String firstName;
    @Column(name="nazwisko",columnDefinition = "Varchar(15) NOT NULL")
    private String lastName;
    @Column(name = "wynagordzenie",precision = 10)
    private double salary;

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
}

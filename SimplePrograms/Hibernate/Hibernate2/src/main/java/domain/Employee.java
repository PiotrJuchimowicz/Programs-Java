package domain;

import javax.persistence.*;

//Class will be divided into two tables :Employee and Adress
@Entity
@Table(name = "Pracownicy")
@SecondaryTable(name = "Adresy",pkJoinColumns = @PrimaryKeyJoinColumn(name = "pracownikID"))
public class Employee
{
    //for Employee table
    @Id
    @GeneratedValue
    private  long id;
    @Column(name = "imie")
    private  String firstName;
    @Column(name = "nazwisko")
    private String lastName;
    @Column(name = "wynagrodzenie")
    private double salary;

    //for Adress table

    @Column(table = "Adresy",name = "miejscowosc")
    private String locality;
    @Column(table = "Adresy",name = "kodPocztowy")
    private String zipcode;
    @Column(table = "Adresy",name = "ulica")
    private String street;
    @Column(table = "Adresy",name = "numerDomu")
    private int streetNumber;


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

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }
}

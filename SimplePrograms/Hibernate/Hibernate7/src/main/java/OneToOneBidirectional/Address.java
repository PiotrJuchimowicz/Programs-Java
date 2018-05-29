package OneToOneBidirectional;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Street;
    private String Town;
    private int streetNumber;


    @OneToOne(mappedBy = "address")//This class is mapped into foreign key into Employee table
    private Employee employee;//We need reference to employee in Java program

    public Address(String street, String town, int streetNumber) {
        Street = street;
        Town = town;
        this.streetNumber = streetNumber;
    }

    public Address() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getTown() {
        return Town;
    }

    public void setTown(String town) {
        Town = town;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }
}

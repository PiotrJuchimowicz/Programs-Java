package OneToManyBidirectional;


import javax.persistence.*;

@Entity
@Table(name = "Phone")
public class Phone
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String type;
    private String number;

    @ManyToOne
    @JoinColumn(name = "ownerID")//Changed name of  foreign key collumn
    private Worker worker;//For use in Java program and foreign key in Phone table(with changed name to ownerID)






    public Phone() {
    }

    public Phone(String type, String number) {
        this.type = type;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

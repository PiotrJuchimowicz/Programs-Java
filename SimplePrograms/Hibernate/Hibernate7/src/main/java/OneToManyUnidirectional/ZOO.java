package OneToManyUnidirectional;

import javax.persistence.*;
import java.util.List;

@Entity
public class ZOO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String city;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ZOO() {
    }
}
//Different Approach
/*
package Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class ZOO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String city;

    //In DB will be added FK to Animal table
    @OneToMany
    @JoinColumn(name = "animalID")//@JoinCollumn must be here-specifies joined collumn in Animal table
    private List<Animal> list;
}
 */

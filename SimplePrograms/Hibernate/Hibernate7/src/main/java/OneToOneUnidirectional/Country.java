package OneToOneUnidirectional;

import javax.persistence.*;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    private String name;
    @OneToOne
    private Capital capital;
}

package com.example.demo.single_table;

import javax.persistence.*;

/*maps all child entities to same table in database -> Each record uses only a subset of the available columns and sets the rest of them to null(cant make not null constraints then)
* provides the best performance */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "publication_type")
public abstract class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

}

package com.example.demo.joined;

import javax.persistence.*;
/*The joined table approach maps each class of the inheritance hierarchy to its own database table.
This sounds similar to the table per class strategy.
But this time, also the ABSTRACT SUPERCLASS PUBLICATION GETS MAPPED to a database table.
Publication table contains columns for all shared entity attributes*/
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

}

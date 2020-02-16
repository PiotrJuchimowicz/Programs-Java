package com.example.demo.mapped_superclass;

import javax.persistence.*;
/*can not use polymorphic queries and map Author with all Publications(must be single relation with Books and Games)
* used mostly when just need to have common params in child entities*/
@MappedSuperclass
public abstract class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

}

package com.example.demo.table_per_class;

import javax.persistence.*;
/*polymorphic queries or relation author with all publications are allowed
* but it is very inefficient strategy - when select all publications hibernate need to union all childs and join them with parent
* but schema model and java code is very simple */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

}

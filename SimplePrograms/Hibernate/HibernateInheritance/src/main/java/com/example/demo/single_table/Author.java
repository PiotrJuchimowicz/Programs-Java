package com.example.demo.single_table;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;

    @OneToMany
    @JoinColumn(name = "author_id")
    private List<Publication> publications = new ArrayList<>();

}

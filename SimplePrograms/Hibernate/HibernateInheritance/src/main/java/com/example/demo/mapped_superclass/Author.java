package com.example.demo.mapped_superclass;

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
//can not make relation between generic publications
    @OneToMany
    @JoinColumn(name = "author_id")
    private List<Book> books = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "author_id")
    private List<Game> games = new ArrayList<>();

}

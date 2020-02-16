package com.example.demo.table_per_class;

import javax.persistence.Entity;

@Entity
public class Book extends Publication {
    private int pages;
    private int coverType;
}

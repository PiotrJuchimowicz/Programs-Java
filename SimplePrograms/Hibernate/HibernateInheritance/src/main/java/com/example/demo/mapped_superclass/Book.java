package com.example.demo.mapped_superclass;

import javax.persistence.Entity;

@Entity
public class Book extends Publication {
    private int pages;
    private int coverType;
}

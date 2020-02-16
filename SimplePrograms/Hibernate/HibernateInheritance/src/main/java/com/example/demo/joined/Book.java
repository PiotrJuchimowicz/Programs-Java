package com.example.demo.joined;

import javax.persistence.Entity;

@Entity
public class Book extends Publication {
    private int pages;
    private int coverType;
}

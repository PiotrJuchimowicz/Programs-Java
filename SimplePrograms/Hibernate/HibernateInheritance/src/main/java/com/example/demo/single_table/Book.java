package com.example.demo.single_table;

import javax.persistence.*;

@Entity
@DiscriminatorValue("BOOK")
public class Book extends Publication {
    private int pages;
    private int coverType;
}

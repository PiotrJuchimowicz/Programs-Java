package com.example.demo.table_per_class;

import javax.persistence.Entity;

@Entity
public class Game extends Publication {
    private String platform;
    private String type;
}

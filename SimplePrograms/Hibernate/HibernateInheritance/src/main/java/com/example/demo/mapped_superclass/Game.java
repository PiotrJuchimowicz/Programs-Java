package com.example.demo.mapped_superclass;

import javax.persistence.Entity;

@Entity
public class Game extends Publication {
    private String platform;
    private String type;
}

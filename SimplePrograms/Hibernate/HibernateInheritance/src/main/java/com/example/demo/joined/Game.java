package com.example.demo.joined;

import javax.persistence.Entity;

@Entity
public class Game extends Publication {
    private String platform;
    private String type;
}

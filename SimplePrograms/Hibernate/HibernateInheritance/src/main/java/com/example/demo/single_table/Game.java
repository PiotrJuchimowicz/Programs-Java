package com.example.demo.single_table;

import javax.persistence.*;

@Entity
@DiscriminatorValue("GAME")
public class Game extends Publication {
    private String platform;
    private String type;

}

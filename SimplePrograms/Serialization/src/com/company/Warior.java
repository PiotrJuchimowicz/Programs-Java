package com.company;

import java.io.Serializable;

public class Warior implements Serializable
{
    private String firstName,lastName;
    private double damage,health;
    private int level;


    public Warior() {

    }

    public Warior(String firstName, String lastName, double damage, double health, int level) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.damage = damage;
        this.health = health;
        this.level = level;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Warior{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", damage=" + damage +
                ", health=" + health +
                ", level=" + level +
                '}';
    }
}

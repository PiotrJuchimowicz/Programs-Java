package base.ConstructorInjection.Models;

import base.Interfaces.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {
    private String name,surname;
    private int age;

    private Coach coach;

    @Autowired
    public Employee(Coach coach,int age,String name,String surname) {
        this.coach = coach;
        this.age = age;
        this.name=name;
        this.surname=surname;
    }
}

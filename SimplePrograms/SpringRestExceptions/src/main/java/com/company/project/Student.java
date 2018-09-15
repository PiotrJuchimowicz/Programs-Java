package com.company.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    private String firstName;
    private String lastName;
    private Address address;


    public Student(String firstName, String lastName,Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address=address;
    }
}

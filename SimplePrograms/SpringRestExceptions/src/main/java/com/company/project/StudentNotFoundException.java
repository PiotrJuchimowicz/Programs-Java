package com.company.project;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message){super(message);}
    public StudentNotFoundException(String message,Throwable throwable){super(message,throwable);}
}

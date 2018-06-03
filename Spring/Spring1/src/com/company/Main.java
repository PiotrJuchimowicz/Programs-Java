package com.company;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Student student = context.getBean("studentBean",Student.class);

        student.displayInfo();
        context.close();

    }
}

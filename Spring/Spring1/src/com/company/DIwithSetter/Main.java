package com.company.DIwithSetter;

import com.company.DIwithConstructor.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        com.company.DIwithSetter.Employee employee = context.getBean("EmployeeSetter", com.company.DIwithSetter.Employee.class);
        employee.display();

        context.close();
    }
}

package com.company.DIwithConstructor;

import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        Employee employee = context.getBean("employeeBean",Employee.class);
        employee.show();

        context.close();
    }
}

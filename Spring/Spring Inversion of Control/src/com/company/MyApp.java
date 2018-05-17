package com.company;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String args[])
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");


        Coach coach = context.getBean("myCoach",Coach.class);

        System.out.println(coach.getDailyWorkout());

        context.close();
    }
}

package base.Main;

import base.Models.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Employee employee = context.getBean("employee",Employee.class);
        context.close();

    }

}

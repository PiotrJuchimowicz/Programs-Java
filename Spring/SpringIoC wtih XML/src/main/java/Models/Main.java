package Models;

import Models.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Employee employee = context.getBean("employee",Employee.class);
        System.out.println(employee.getName()+1);

        context.close();
    }
}

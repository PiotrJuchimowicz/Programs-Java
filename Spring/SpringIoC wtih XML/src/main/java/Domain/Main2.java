package Domain;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Animal animal = context.getBean("animal",Animal.class);
        System.out.println(animal);

        context.close();

    }
}

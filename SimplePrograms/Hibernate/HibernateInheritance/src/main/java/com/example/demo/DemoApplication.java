package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
/*https://thoughts-on-java.org/complete-guide-inheritance-strategies-jpa-hibernate/*/
@SpringBootApplication
@EntityScan(basePackages = "com.example.demo.joined")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

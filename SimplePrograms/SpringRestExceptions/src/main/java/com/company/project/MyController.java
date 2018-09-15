package com.company.project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    private List<Student> students;

    @PostConstruct
    public void load() {
        students = new ArrayList<>();
        students.add(new Student("John", "Smith",new Address("Poland","Warsaw")));
        students.add(new Student("Mark", "Brown",new Address("Italy","Rome")));
        students.add(new Student("Jacob", "August",new Address("England","London")));
        students.add(new Student("Michael", "Johnson",new Address("USA","New York")));
    }

    @RequestMapping(value = "getStudent/{id}", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public Student getStudent(@PathVariable("id") int id) {
        if(id>=students.size() || id<0)
            throw  new StudentNotFoundException("Unable to find student with id= "+ id );
        return students.get(id);
    }

}

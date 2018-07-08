package com.company.Controlers;

import com.company.Models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("showForm")
    public String showStudentForm(Model model)
    {
        Student student = new Student();

        model.addAttribute("student",student);

        return "studentTextForm";

    }
//Autobinding danych z formularza  z referencja student
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student)
    {
        return "studentConfirmation";
    }
}

package com.company.Controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class HomeController {

    @RequestMapping("/")
    public String showMyPage()
    {
        return "index";
    }

    //form page
    @RequestMapping("/showForm")
    public String showForm()
    {
        return "formView";
    }

    //confirmation page
    @RequestMapping("/processForm")
    public String processForm()
    {
        return "confirmView";
    }

    //request - to co jest przesylane do tej metody kontrolera wraz z widokiem  ktory tu prowadzi( w tym przypadku jest to from view)
    //model - model ktorym przesylam dane na zewnatrz do widoku
    @RequestMapping("/letsShoutDude")
    public String letsShoutDude(HttpServletRequest request, Model model)
    {

        String theName= request.getParameter("studentName");

        theName=theName.toUpperCase();



        String result = "Hi " + theName + " !";

        model.addAttribute("message",result);

        return "confirmView";
    }
}
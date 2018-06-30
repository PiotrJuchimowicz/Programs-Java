package base.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class FirstController {
    @RequestMapping("/")
    public String method()
    {
        return "main-menu";
    }
}

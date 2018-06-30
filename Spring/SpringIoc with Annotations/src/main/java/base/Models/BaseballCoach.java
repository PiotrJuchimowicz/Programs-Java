package base.Models;

import base.Interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    @Override
    public void presentYourself() {
        System.out.println("I am Baseball Coach");
    }
}

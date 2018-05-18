package com.company;

import java.io.FileOutputStream;

public class CrickerCoach implements  Coach {
    private FortuneService fortuneService;

    public CrickerCoach(){};


    @Override
    public String getDailyWorkout() {
        return " Cricket Coach workout";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public FortuneService getFortuneService() {
        return fortuneService;
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
}

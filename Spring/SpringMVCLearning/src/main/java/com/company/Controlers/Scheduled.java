package com.company.Controlers;

import org.springframework.stereotype.Component;

@Component
public class Scheduled {
    @org.springframework.scheduling.annotation.Scheduled(cron = "*/10 * * * * *")
    public void executeEveryDay()
    {
        System.out.println("USTECZKA");

    }
}

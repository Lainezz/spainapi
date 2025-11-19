package com.es.spainapi.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloJob {

    @Scheduled(cron = "0 0 0 * */5 *", zone = "Europe/Madrid")
    public void sayHelloCron() {
        log.info("Hello World");
        System.out.println("Hello World");
    }
}

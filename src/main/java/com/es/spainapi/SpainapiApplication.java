package com.es.spainapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpainapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpainapiApplication.class, args);
	}

}

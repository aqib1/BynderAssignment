package com.unsplash.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"com.unsplash.*"})
@EnableCaching
@EnableScheduling
public class BynderServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BynderServerApplication.class, args);
    }
}

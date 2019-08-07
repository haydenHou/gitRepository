package com.qbwl.aspect_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AspectDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AspectDemoApplication.class, args);
    }

}

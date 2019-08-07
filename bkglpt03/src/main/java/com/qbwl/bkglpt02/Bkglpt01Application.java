package com.qbwl.bkglpt02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.qbwl.bkglpt02.dao")
@EnableScheduling
public class Bkglpt01Application {

    public static void main(String[] args) {
        SpringApplication.run(Bkglpt01Application.class, args);
    }

}

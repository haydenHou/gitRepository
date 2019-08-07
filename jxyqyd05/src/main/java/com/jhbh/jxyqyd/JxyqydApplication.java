package com.jhbh.jxyqyd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling
@MapperScan("com.jhbh.jxyqyd.dao")
public class JxyqydApplication {

    public static void main(String[] args) {
        SpringApplication.run(JxyqydApplication.class, args);
    }

}

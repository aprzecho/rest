package com.aprzecho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com")
public class SpringBootWithOpenLibertyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWithOpenLibertyApplication.class, args);
    }
}

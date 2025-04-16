package com.keithdiaz.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
@ComponentScan (basePackages = {"com.keithdiaz.**.moduleconfig"})
public class Main {
    public static void main(String[] args) {
       SpringApplication.run(Main.class, args);
    }
}
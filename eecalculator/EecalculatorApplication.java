package com.hylston.eecalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class EecalculatorApplication {

    public static void main(String[] args) {

        SpringApplication.run(EecalculatorApplication.class, args);
    }
}

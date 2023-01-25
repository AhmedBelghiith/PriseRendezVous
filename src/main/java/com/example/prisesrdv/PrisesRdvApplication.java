package com.example.prisesrdv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PrisesRdvApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrisesRdvApplication.class, args);
    }

}

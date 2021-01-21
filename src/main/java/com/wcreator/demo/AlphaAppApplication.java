package com.wcreator.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlphaAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlphaAppApplication.class, args);
    }

}

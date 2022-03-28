package com.dominhtuan.exercise1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Exercise1Application {

    public static void main(String[] args) {
        SpringApplication.run(Exercise1Application.class, args);
    }

}

package com.spring.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;

@SpringBootApplication
public class ProjectSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectSpringApplication.class, args);
    }
}

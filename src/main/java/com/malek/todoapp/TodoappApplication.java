package com.malek.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoappApplication {

//    @Autowired
//    private Seeder seeder;

    public static void main(String[] args) {
        SpringApplication.run(TodoappApplication.class, args);
    }

//    For future use.
//
//    @EventListener
//    public void seed(ContextRefreshedEvent event) {
//        seeder.seedTaskTable();
//        seeder.seedStatusTable();
//    }

}

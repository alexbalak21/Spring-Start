package com.alex;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @GetMapping("/")
    public Great greet(){
        Great response = new Great("Hello", List.of("Burgers", "pizza", "shush"), new Person("Alex", 28, 30_000));
        return response;
    }
    record Great(
            String greet,
            List<String> favFoods,
            Person person
                 ){}

    record Person (String name, int age, double cash){

    }
}

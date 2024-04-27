package com.ayaan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class main {
    public static void main(String[] args) {
        SpringApplication.run(main.class, args);
    }

    @GetMapping("/greet")
    public GreetResponse greet() {
        GreetResponse response;
        response = new GreetResponse(
                "Hello",
                List.of("Java", "c++"),
                new Person("Alex",20)
        );
        return response;
    }

    record Person(String name,int age) {
    }

    record GreetResponse(String greet,
                         List<String> favLang,
                         Person person) {
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return List.of();
    }
}

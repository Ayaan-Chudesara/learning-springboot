package com.ayaan;

import com.sun.tools.javac.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class main {


    private final CustomerRepository customerRepository;

    public main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


   public static void main(String[] args) {
      SpringApplication.run(main.class, args);
  }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    record NewcustomerRequest(String name, String email, int age) {}

    record UpdateRequest(String name, String email, int age) {}

    @PostMapping
    public void addcustomer(@RequestBody NewcustomerRequest request){
        Customer customer =new Customer();
        customer.setName(request.name);
        customer.setEmail(request.email);
        customer.setAge(request.age);

        customerRepository.save(customer);
    }

    @DeleteMapping("{customerid}")
    public void deletecustomer(@PathVariable("customerid") Integer id){
        customerRepository.deleteById(id);
    }

    @DeleteMapping("{customerid}")
    public void updatecustomer(@PathVariable("customerid") Integer id,@RequestBody UpdateRequest request){
        Customer customer =new Customer();
        customer.setName(request.name);
        customer.setEmail(request.email);
        customer.setAge(request.age);

        customerRepository.save(customer);
    }


}

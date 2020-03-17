package org.aston.SpringCloud;

import org.aston.customerservice.Customer;

import org.aston.dao.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@SpringBootApplication
public class SpringCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(new Customer(null,"ENSET","enset@gmail.com"));
			customerRepository.save(new Customer(null,"IBM","ibm@gmail.com"));
			customerRepository.save(new Customer(null,"HP","hp@gmail.com"));
			customerRepository.findAll().forEach(System.out::println);
			
			
		};

	}

}
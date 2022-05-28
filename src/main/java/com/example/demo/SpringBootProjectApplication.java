package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@SpringBootApplication
public class SpringBootProjectApplication {

  	private static final Logger log = LoggerFactory.getLogger(SpringBootProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectApplication.class, args);
		
		
	}

	@Bean
	  public CommandLineRunner demo(PersonService repository) {
	    return (args) -> {
	      // save a few customers
	      repository.save(new Person(1, "Jack", "Bauer"));
	      repository.save(new Person(2, "Chloe", "O'Brian"));
	      repository.save(new Person(3, "Kim", "Bauer"));
	      repository.save(new Person(4, "David", "Palmer"));
	      repository.save(new Person(5, "Michelle", "Dessler"));

	      // fetch all customers
	      log.info("Customers found with findAll():");
	      log.info("-------------------------------");
	      for (Person person : repository.getAllPeople()) {
	        log.info(person.toString());
	      }
	      log.info("");

	      // fetch an person by ID
	      Person person = repository.findById(2);
	      log.info("Customer found with findById(1L):");
	      log.info("--------------------------------");
	      log.info(person.toString());
	      log.info("");


	    };
	  }
}

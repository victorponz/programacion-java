package org.ieselcaminas.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Optional;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner{
	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	/**
	 * Este método se ejecuta automáticamente cuado el programa se lanza por consola porque
	 * implementa CommandLineRunner
	 * @param args
	 */
	@Override
	public void run(String... args) {
		// save a few customers
		repository.save(new Customer("Pepe", "Viyuela"));
		repository.save(new Customer("Juan", "Imedio"));
		repository.save(new Customer("María", "Imedio"));
		repository.save(new Customer("David", "Palmer"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println("");

		// fetch an individual customer by ID
		Customer customer = repository.findById(1L);
		System.out.println("Customer found with findById(1L):");
		System.out.println("--------------------------------");
		System.out.println(customer);
		customer.setFirstName("Pedro");
		System.out.println("Customer modified");
		System.out.println(customer);
		System.out.println("");

		// fetch customers by last name
		System.out.println("Customer found with findByLastName('Imedio'):");
		System.out.println("--------------------------------------------");
		repository.findByLastName("Imedio").forEach(imedio -> {
			System.out.println(imedio);
		});

		System.out.println("");

	}
}

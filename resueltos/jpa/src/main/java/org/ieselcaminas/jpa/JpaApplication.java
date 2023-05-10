package org.ieselcaminas.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner{
	@Autowired
	private CustomerRepository repository;
	@Autowired
	private NoteRepository noteRepository;

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
		Note n = new Note(customer, "Esto es una nota");
		customer.addNote(n);
		repository.save(customer);
		//n.setCustomer(customer);
		noteRepository.save(n);

		System.out.println(customer);

		System.out.println(n.getCustomer().getFirstName());
		customer.getNotes().forEach(System.out::println);
		System.out.println(customer.getNotes().size());
		//repository.delete(customer);
		// fetch customers by last name
		System.out.println("Customer found with findByLastName('Imedio'):");
		System.out.println("--------------------------------------------");
		repository.findByLastName("Imedio").forEach(imedio -> {
			System.out.println(imedio);
		});

		System.out.println("");

	}
}

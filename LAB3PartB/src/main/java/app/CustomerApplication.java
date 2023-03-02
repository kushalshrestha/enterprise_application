package app;

import domain.Book;
import domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.BookRepository;
import repositories.CustomerRepository;

import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class CustomerApplication implements CommandLineRunner{
	
	@Autowired
	CustomerRepository customerrepository;
	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerrepository.save(new Customer("Jack", "Bauer", "jack@acme.com"));
		customerrepository.save(new Customer("Chloe", "O'Brian", "chloe@acme.com"));
		customerrepository.save(new Customer("Kim", "Bauer", "kim@acme.com"));
		customerrepository.save(new Customer("David", "Palmer", "dpalmer@gmail.com"));
		customerrepository.save(new Customer("Michelle", "Dessler", "mich@hotmail.com"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerrepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer by ID
		Optional<Customer> custOpt = customerrepository.findById(1L);
		Customer customer = custOpt.get();
		System.out.println("Customer found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(customer);
		System.out.println();

		System.out.println("----------ASSIGNMENT--------");
		bookRepository.save(new Book("Box Office Poison", "978-1-891830-19-8", "Alex Robinson", 29.95 ));
		bookRepository.save(new Book("Clumsy", "978-1-09713597-19-8", "Jeffrey Brown", 10.00 ));
		bookRepository.save(new Book("March: Book One", "978-1-60309-300-2", "John Lewis", 14.95 ));

		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Book book : bookRepository.findAll()) {
			System.out.println(book);
		}

		Book b = bookRepository.findByTitle("Clumsy").get();
		b.setAuthor("Jeff Brown");
		bookRepository.save(b);

		System.out.println("---------After Updating a book----------------------");
		for (Book book : bookRepository.findAll()) {
			System.out.println(book);
		}

		bookRepository.delete(bookRepository.findByTitle("Box Office Poison").get());
		System.out.println("---------After Deleting a book----------------------");
		for (Book book : bookRepository.findAll()) {
			System.out.println(book);
		}


	}
}

package app;

import domain.Address;
import domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.StopWatch;
import repositories.BookRepository;

import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class LibraryApplication implements CommandLineRunner{
	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		addBooks();
		changeLocationCode();
		removeOldBooks();
	}

	public void addBooks(){

		for (int x=0; x< 10000; x++){
			int year = 1900 + new Random().nextInt(100-1) + 1;
			Book book = new Book("harry Potter", "J K Rowling", year);
			Address address = new Address("AA-345-"+x);
			book.setAddress(address);
			bookRepository.save(book);
		}

	}

	private void changeLocationCode() {
		StopWatch sw = new StopWatch();
		sw.start();

		List<Book> bookList = bookRepository.findAllBooks();
		for (Book book : bookList){
			String locationCode = book.getAddress().getLocationCode();
			book.getAddress().setLocationCode("BB"+locationCode);
		}
		bookRepository.saveAll(bookList);
		sw.stop();
		long totaltime=sw.getTotalTimeMillis();
		System.out.println("Changing the location code of all books took "+totaltime+" ms");
	}

	private void removeOldBooks() {
		StopWatch sw = new StopWatch();
		sw.start();

		List<Book> bookList = bookRepository.findBookByPublicationYearLessThan1950();
		for (Book book : bookList){
			if (book.getPublicationYear() < 1950)
			   bookRepository.delete(book);
		}

		sw.stop();
		long totaltime=sw.getTotalTimeMillis();
		System.out.println("Removing old books took "+totaltime+" ms");
	}



}


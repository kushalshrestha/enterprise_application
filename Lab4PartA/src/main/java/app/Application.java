package app;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.BookRepository;
import repositories.DepartmentRepository;
import repositories.PassengerRepository;
import repositories.SchoolRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class Application implements CommandLineRunner{

	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	SchoolRepository schoolRepository;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Department department = new Department("Department of Mathematics");
		Employee employee = new Employee("Lionel Messi");
		employee.setDepartment(department);
		department.getEmployeeList().add(employee);
		departmentRepository.save(department);
		System.out.println("------ PART A : OUTPUT ------");
		for (Department dep : departmentRepository.findAll()) {
			System.out.println(dep);
		}
		Book book = new Book("123324", "The Jungle Book", "J K Rowling");
		Publisher publisher = new Publisher("AlphaBeta");
		book.setPublisher(publisher);
		bookRepository.save(book);
		System.out.println("------ PART B : OUTPUT ------");
		for (Book b : bookRepository.findAll()) {
			System.out.println(b);
		}

		Passenger passenger = new Passenger("Kushal Shrestha");
		Flight flight = new Flight("KTM-31",
				"Kathmandu",
				"San Francisco",
				new SimpleDateFormat("yyyy/MM/dd").parse("2022/10/26"));

		passenger.getFlight().add(flight);
		Flight flight1 = new Flight("AA-331",
				"San Francisco",
				"Dallas Fort Worth",
				new SimpleDateFormat("yyyy/MM/dd").parse("2022/10/28"));
		passenger.getFlight().add(flight1);

		passengerRepository.save(passenger);
		System.out.println("------ PART C : OUTPUT ------");
		for (Passenger p : passengerRepository.findAll()) {
			System.out.println(p);
		}

		School school = new School("Ideal Model School");
		Student student = new Student("Kushal","Shrestha");
		school.getStudent().put(1L, student);
		schoolRepository.save(school);
		System.out.println("------ PART D : OUTPUT ------");
		for (School s : schoolRepository.findAll()) {
			System.out.println(s);
		}

	}

	public static void printDepartment(Department department) {


	}
}

package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        // create customer
		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);
		customer = new Customer(109,"John Jones", "jones@acme.com", "0624321234");
		creditCard = new CreditCard("657483342", "Visa", "09/23");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);
		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);

		List<Grade> grades = new ArrayList<>();
		Grade grade = new Grade("Science","A+");
		Grade grade1 = new Grade("Mathematics", "B-");
		grades.add(grade);
		grades.add(grade1);

		Student student = new Student("Kushal Shrestha", 9813254102L,
				new Address("Satdobato", "Lalitpur", "54300"), grades);
		studentRepository.save(student);


		List<Grade> grades1 = new ArrayList<>();
		Grade grade2 = new Grade("Science","A+");
		Grade grade3 = new Grade("Computer", "A+");
		grades1.add(grade2);
		grades1.add(grade3);
		Student student1 = new Student("Anil Shrestha", 9813254103L,
				new Address("Satdobato", "Lalitpur", "54300"), grades1);
		studentRepository.save(student1);

		List<Grade> grades2 = new ArrayList<>();
		Grade grade4 = new Grade("Science","A+");
		Grade grade5 = new Grade("Mathematics", "A-");
		grades2.add(grade4);
		grades2.add(grade5);
		Student student2 = new Student("Shree Maya Shrestha", 9813254104L,
				new Address("Satdobato", "Lalitpur", "54300"), grades2);

		studentRepository.save(student2);
		//get customers
		System.out.println(customerRepository.findById(66).get());
		System.out.println(customerRepository.findById(101).get());
		System.out.println("-----------All customers ----------------");
		System.out.println(customerRepository.findAll());
		//update customer
		customer = customerRepository.findById(101).get();
		customer.setEmail("jd@gmail.com");
		customerRepository.save(customer);
		System.out.println("-----------find by phone ----------------");
		System.out.println(customerRepository.findByPhone("0622341678"));
		System.out.println("-----------find by email ----------------");
		System.out.println(customerRepository.findCustomerWithEmail("jj123@acme.com"));
		System.out.println("-----------find customers with a certain type of creditcard ----------------");
		List<Customer> customers = customerRepository.findCustomerWithCreditCardType("Visa");
		for (Customer cust : customers){
			System.out.println(cust);
		}

		// Find the students with a certain name
		System.out.println("-----------Find the students with a certain name ----------------");
		List<Student> studentList = studentRepository.findByName("Kushal Shrestha");
		studentList.stream().forEach(s -> System.out.println(s));

		System.out.println("----------Find the Students with a certain phone number--------");
		List<Student> stuList = studentRepository.findByPhoneNumber(9813254103L);
		stuList.stream().forEach(s-> System.out.println(s));

		System.out.println("----------Find the Students with a certain city--------");
		List<Student> studentListByCity = studentRepository.findStudentWithCity("Lalitpur");
		studentListByCity.stream().forEach(s -> System.out.println(s));




		System.out.println("------Find the Students that took a certain course with a given name---");
		List<Student> studentListByCourse = studentRepository.findStudentWithCourse("Computer");
		studentListByCourse.stream().forEach(s -> System.out.println(s));


		System.out.println("------Find the Students with an A+ for a certain course name---");
		List<Student> studentListByAGrade= studentRepository.findStudentWithAPlus("A+");
		studentListByAGrade.stream().forEach(s -> System.out.println(s));

	}

}

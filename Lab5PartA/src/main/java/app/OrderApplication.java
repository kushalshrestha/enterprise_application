package app;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.OrderRepository;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class OrderApplication implements CommandLineRunner{
	@Autowired
	OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product = new CD("John Lennon");
		product.setName("Hibernate 3");
		product.setDescription("Good book on Hibernate");
		product.setPrice(35.50);
		OrderLine ol1 = new OrderLine(2, product);

		Product product2 = new DVD("Classical Rocke");
		product2.setName("The best of Queen");
		product2.setDescription("Album from 1995");
		product2.setPrice(12.98);
		OrderLine ol2 = new OrderLine(4, product2);

		Product product3 = new Book("21-32-32432-1");
		product3.setName("The Jungle Book");
		product3.setDescription("Stories for Children");
		product3.setPrice(2.98);
		OrderLine ol3 = new OrderLine(1, product3);

		Order o1 = new Order(1, "12/10/06", "open");
		o1.addOrderLine(ol1);
		o1.addOrderLine(ol2);
		o1.addOrderLine(ol3);

		Customer c1 = new Customer("Frank", "Brown", "Mainstreet 1",
				"New york", "43221", "USA");
		c1.addOrder(o1);
		o1.setCustomer(c1);


		printOrder(o1);
		System.out.println("-------Saving Order--------");
		orderRepository.save(o1);
		System.out.println("---------Fetching from Database ----------");
		for (Order order : orderRepository.findAll()) {
			System.out.println(order);
		}


	}

	public static void printOrder(Order order) {
		System.out.println("Order with orderNumber: " + order.getOrdernumber());
		System.out.println("Order date: " + order.getDate());
		System.out.println("Order status: " + order.getStatus());
		Customer cust = order.getCustomer();
		System.out.println("Customer: " + cust.getFirstname() + " "
				+ cust.getLastname());
		for (OrderLine orderline : order.getOrderlines()) {
			System.out.println("Order line: quantity= "
					+ orderline.getQuantity());
			Product product = orderline.getProduct();
			System.out.println("Product: " + product.getName() + " "
					+ product.getDescription() + " " + product.getPrice());
		}

	}
}

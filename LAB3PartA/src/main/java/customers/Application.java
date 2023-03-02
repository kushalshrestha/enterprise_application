package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerDAO customerDao;

	@Autowired
	private ProductDAO productDAO;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerDao.clearDB();
		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
		customer.setCreditCard(creditCard);
		customerDao.save(customer);
		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
		customer.setCreditCard(creditCard);
		customerDao.save(customer);
		System.out.println(customerDao.getCustomer(101));
//		System.out.println(customerDao.getCustomer(66));
//		System.out.println("-----------All customers ----------------");
//		System.out.println(customerDao.getAllCustomers());
//
//		System.out.println("============ ASSIGNMENT ===========");
//		productDAO.clearDB();
//		Product product = new Product(1, "Apple");
//		Supplier supplier = new Supplier(100, "Supplier 1", "123456789");
//		product.setSupplier(supplier);
//		productDAO.save(product);
//		Product product1 = new Product(2, "Banana");
//		Supplier supplier1 = new Supplier(101, "Supplier 2", "981234321");
//		product1.setSupplier(supplier1);
//		productDAO.save(product1);
//		System.out.println(productDAO.findByProductNumber(1));
//		System.out.println(productDAO.findByProductNumber(2));
//		System.out.println("-------All products-----");
//		System.out.println(productDAO.getAllProducts());
//		System.out.println(productDAO.findByProductName("Apple"));
//		System.out.println("-- REMOVE PRODUCT WITH PRODUCT NUMBER: 1 ----");
//		productDAO.removeProduct(1);
//		System.out.println("-- All Products after removing product number 1 ----");
//		System.out.println(productDAO.getAllProducts());


	}
}

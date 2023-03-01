package customers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


public class Application {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ICustomerService customerService = context.getBean("customerService",
				ICustomerService.class);
		customerService.addCustomer("Frank Brown", "fbrown@acme.com",
				"mainstreet 5", "Chicago", "60613");

		IProductService productService = context.getBean("productService", IProductService.class);
		String email = "kushalshr@gmail.com";
		productService.addProduct("1", "Apple", email);
		productService.addProduct("2","Banana", email);

	}
}


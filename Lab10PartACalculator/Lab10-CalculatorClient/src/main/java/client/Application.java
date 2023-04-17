package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	CalculatorClient calculatorClient;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Multiplication Output : " + calculatorClient.multiply(2,3));
		System.out.println("Addition Output : " + calculatorClient.add(2,3));
		System.out.println("Subtraction Output : " + calculatorClient.subtract(2,3));
	}

}



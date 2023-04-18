package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;


@SpringBootApplication
@EnableJms
public class SpringJmsPersonSenderApplication implements CommandLineRunner {
	@Autowired
	JmsTemplate jmsTemplate;


	public static void main(String[] args)  {
		ConfigurableApplicationContext context = SpringApplication.run(SpringJmsPersonSenderApplication.class, args);
		context.close();
	}

	@Override
	public void run(String... args) throws Exception {
//		Person person = new Person("Frank", "Brown");
//		//convert person to JSON string
//		ObjectMapper objectMapper = new ObjectMapper();
//		String personAsString = objectMapper.writeValueAsString(person);
//
//		System.out.println("Sending a JMS message:" + personAsString);
//		jmsTemplate.convertAndSend("testQueue",personAsString);

		System.out.println("----CALCULATOR ASSIGNMENT----");
		JMSCalculator jmsCalculator = new JMSCalculator("+", 23);
		ObjectMapper objectMapper1 = new ObjectMapper();
		String jmsCalculatorAsString = objectMapper1.writeValueAsString(jmsCalculator);

		System.out.println("Sending a JMS message: " + jmsCalculatorAsString);
		jmsTemplate.convertAndSend("calculatorQueue",jmsCalculatorAsString);

		JMSCalculator jmsCalculator2 = new JMSCalculator("-", 15);
		ObjectMapper objectMapper2 = new ObjectMapper();
		String jmsCalculatorAsString2 = objectMapper2.writeValueAsString(jmsCalculator2);

		System.out.println("Sending a JMS message: " + jmsCalculatorAsString2);
		jmsTemplate.convertAndSend("calculatorQueue",jmsCalculatorAsString2);

		JMSCalculator jmsCalculator3 = new JMSCalculator("*", 2);
		ObjectMapper objectMapper3 = new ObjectMapper();
		String jmsCalculatorAsString3 = objectMapper2.writeValueAsString(jmsCalculator3);

		System.out.println("Sending a JMS message: " + jmsCalculatorAsString3);
		jmsTemplate.convertAndSend("calculatorQueue",jmsCalculatorAsString3);



	}

}

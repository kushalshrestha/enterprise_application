package bank;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountDTO;
import bank.service.AccountEntryDTO;
import bank.service.CustomerDTO;
import bank.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Collection;

@SpringBootApplication
@EnableKafka
@EnableJms
//@EnableScheduling
public class Application implements CommandLineRunner {

	@Autowired
	private IAccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		accountService.createAccount(123, "Kushal Shrestha");
		accountService.createAccount(124, "Anil Shrestha");
		accountService.createAccount(125, "Bhim Shrestha");
		accountService.deposit(123, 10000);
		accountService.withdraw(123, 10);

	}
}

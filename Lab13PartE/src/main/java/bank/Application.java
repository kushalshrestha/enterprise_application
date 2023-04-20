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
import org.springframework.boot.actuate.context.ShutdownEndpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Collection;

@SpringBootApplication(exclude = { SolrAutoConfiguration.class })
@EnableKafka
@EnableJms
@EnableScheduling
public class Application {

	@Autowired
	private IAccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("\n\n\n\n=================== LOG DETAILS ================");
		System.out.println("LOGFILE PATH: src/main/java/logs");
		System.out.println("LOGFILENAME : application.logs");
		System.out.println("=================== NOTE: CONSOLE LOG DISABLED. SEE LOG FILE!!!!! ================");

	}


}

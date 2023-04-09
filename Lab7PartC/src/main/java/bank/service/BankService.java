package bank.service;

import bank.domain.Account;
import bank.domain.Customer;
import bank.domain.TraceRecord;
import bank.integration.EmailSender;
import bank.repositories.AccountRepository;
import bank.repositories.CustomerRepository;
import bank.repositories.TraceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class BankService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private EmailSender emailSender;

	@Autowired
	private TraceService traceService;

	@Transactional
	public void createCustomerAndAccount(int customerId, String customerName, String emailAddress,
										 String AccountNumber) {
		try {
			Account account = new Account(AccountNumber);
			accountRepository.save(account);
			Customer customer = new Customer(customerId, customerName);
			customer.setAccount(account);
			customerRepository.saveCustomer(customer);
			emailSender.sendEmail(emailAddress, "Welcome "+customerName);
			traceService.saveTraceRecord(new TraceRecord(LocalDateTime.now(),
					"Customer " + customerName + " created with account " + AccountNumber));

		} catch (RuntimeException re) {
			emailSender.sendEmail(emailAddress, "We could not create your account " + AccountNumber);
			traceService.saveTraceRecord(new TraceRecord(LocalDateTime.now(),
					"Could not create customer " + customerName + " with account " + AccountNumber));
			throw re;
		}
	}
}

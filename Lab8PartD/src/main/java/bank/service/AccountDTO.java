package bank.service;

import java.util.ArrayList;
import java.util.Collection;


public class AccountDTO {
	private String accountnumber;
	private double balance;
	private Collection<AccountEntryDTO> entryList = new ArrayList<AccountEntryDTO>();
	private CustomerDTO customer;

	public AccountDTO() {
	}

	public AccountDTO(String accountnr){
		this.accountnumber = accountnr;
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public Collection<AccountEntryDTO> getEntryList() {
		return entryList;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}

package bank.service;

import bank.domain.AccountEntry;
import bank.domain.Customer;

import java.util.Collection;

public class AccountDTO {

    private long accountNumber;
    private Collection<AccountEntry> accountEntryList;

    private Customer customer;

    protected AccountDTO(){}

    public AccountDTO(long accountNumber, Collection<AccountEntry> accountEntryList, Customer customer) {
        this.accountNumber = accountNumber;
        this.accountEntryList = accountEntryList;
        this.customer = customer;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Collection<AccountEntry> getAccountEntryList() {
        return accountEntryList;
    }

    public void setAccountEntryList(Collection<AccountEntry> accountEntryList) {
        this.accountEntryList = accountEntryList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public double getBalance() {
        double balance=0;
        for (AccountEntry entry : accountEntryList) {
            balance+=entry.getAmount();
        }
        return balance;
    }
}

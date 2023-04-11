package bank.service;

import bank.domain.Account;

import java.util.Collection;


public interface IAccountService {
    public AccountDTO createAccount(String accountNumber, String customerName);
    public AccountDTO getAccount(String accountNumber);
    public Collection<AccountDTO> getAllAccounts();
    public void deposit (String accountNumber, double amount);
    public void withdraw (String accountNumber, double amount);
    public void depositEuros (String accountNumber, double amount);
    public void withdrawEuros (String accountNumber, double amount);
    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
}

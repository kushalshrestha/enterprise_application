package bank.service;

import bank.domain.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountAdapter {

    public static Account getAccountFromAccountDTO(AccountDTO accountdto) {
        return new Account(accountdto.getAccountNumber(), accountdto.getAccountEntryList(), accountdto.getCustomer());
    }
}

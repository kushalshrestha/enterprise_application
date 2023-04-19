package bank.domain;

import bank.dao.IAccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class BankStatementPrinter {
    @Autowired
    private IAccountDAO accountDAO;

    @Scheduled(fixedRate = 5000)
    public void displayAccountDetails(){
        System.out.println("----------printing account details at " + LocalDateTime.now() + "----------");
        List<Account> accountList = accountDAO.findAll();
        accountList.stream().forEach(accountDetails -> System.out.println(accountDetails));
    }

}
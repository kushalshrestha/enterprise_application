package accounts.service;

import accounts.domain.Account;
import accounts.repositories.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
public class AccountServiceTest {
    @TestConfiguration
    static class AccountServiceTestConfiguration{
        @Bean
        public AccountService accountService(){
            return new AccountService();
        }
    }

    @Autowired
    private AccountService accountService;
    @MockBean
    private AccountRepository accountRepository;
    @MockBean
    private AccountDTO accountDTO;

    @Before
    public void setUp() {
//        Account acc = new Account("12341234", 124332.32, "Lionel Messi");
//        Mockito.when(accountRepository.findByAccountNumber("12341234")).thenReturn(acc);
    }

    @Test
    public void getAccount(){
        String accountNumber = "123456";
        Account account = new Account(accountNumber, 100.0, "Lionel Messi");
        AccountDTO expectedDto = AccountAdapter.getAccountDto(account);
        Mockito.when(accountRepository.findById(accountNumber)).thenReturn(Optional.of(account));

        // Act
        AccountDTO actualDto = accountService.getAccount(accountNumber);
        assert(actualDto.getAccountNumber().equals(expectedDto.getAccountNumber()));
        assert(actualDto.getAccountHolder().equals(expectedDto.getAccountHolder()));
        assert(Double.valueOf(actualDto.getBalance()).equals(Double.valueOf(expectedDto.getBalance())));
    }

    @Test
    public void createAccount(){
        String accountNumber = "14324";
        double amount = 32432.12;
        String accountHolder = "Lionel Messi";
        Account mockedAccount = new Account(accountNumber,amount, accountHolder);
        Mockito.when(accountRepository.save(mockedAccount)).thenReturn(mockedAccount);
        accountService.createAccount(accountNumber,amount,accountHolder);
        assert(accountNumber).equals(mockedAccount.getAccountNumber());
        assert(accountHolder).equals(mockedAccount.getAccountHolder());
        assert(Double.valueOf(amount)).equals(mockedAccount.getBalance());

    }

}

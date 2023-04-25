package accounts.repository;

import accounts.domain.Account;
import accounts.repositories.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void findByAccountHolder(){
        Account account = new Account("123123",10023.00, "Kushal");
        testEntityManager.persist(account);
        testEntityManager.flush();
        Account acc = accountRepository.findByAccountHolder("Kushal");
        assertThat(acc.getAccountNumber()).isEqualTo(account.getAccountNumber());
    }

    @Test
    public void findByAccountNumber(){
        Account account = new Account("1231234",10023.00, "Kushal");
        testEntityManager.persist(account);
        testEntityManager.flush();
        Account acc = accountRepository.findByAccountNumber("1231234");
        assertThat(acc.getAccountNumber()).isEqualTo(account.getAccountNumber());
    }

    @Test
    public void findByStartingWith(){
        Account account = new Account("123123", 34984.12, "Messi");
        testEntityManager.persist(account);
        Account account1 = new Account("124124", 3423423.2, "Maradona");
        testEntityManager.persist(account1);
        testEntityManager.flush();
        List<Account> accountList = accountRepository.findByAccountHolderStartingWith("M");
        assertThat(accountList).hasSize(2);
    }



}

import bank.domain.Account;
import bank.domain.AccountEntry;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    private Account account;
    @BeforeEach
    public void setup(){
        account = new Account();
    }

    @Test
    public void testIncrement(){
        account.deposit(100.0);
        assertThat(account.getBalance(), closeTo(100.0, 0.01));
    }

    @Test
    public void getBalance(){

        account.deposit(100.0);
        double expectedBalance = 100.0;
        double actualBalance = account.getBalance();
        assertEquals(expectedBalance, actualBalance, 0.001);

    }

    @Test
    public void withdraw(){

        account.deposit(100.0);
        double expectedBalance = 90;
        account.withdraw(10.0);
        assertEquals(90.0, account.getBalance(), 0.001);

    }

    @AfterEach
    public void tearDown() throws Exception {
        account=null;
    }


}

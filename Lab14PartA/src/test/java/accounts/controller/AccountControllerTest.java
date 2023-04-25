package accounts.controller;

import accounts.repositories.AccountRepository;
import accounts.service.AccountDTO;
import accounts.service.AccountService;
import accounts.service.AccountServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import javax.servlet.ServletContext;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {
    @Autowired
    MockMvc mock;
    @MockBean
    AccountService accountService;
    @MockBean
    AccountRepository accountRepository;

    @Test
    public void getAccountFromAccountNumber() throws Exception {
        AccountDTO mockedAccount = new AccountDTO("12341234", 200.00, "Lionel Messi");
        Mockito.when(accountService.getAccount("12341234"))
                .thenReturn(new AccountDTO("12341234", 200.00, "Lionel Messi"));
        mock.perform(MockMvcRequestBuilders.get("/account/12341234"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountNumber").value(mockedAccount.getAccountNumber()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.balance").value(mockedAccount.getBalance()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountHolder").value(mockedAccount.getAccountHolder()));
    }
}

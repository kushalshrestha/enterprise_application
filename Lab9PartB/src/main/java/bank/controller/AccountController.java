package bank.controller;

import bank.domain.Account;
import bank.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;
    private Map<String, Object> responseObject = new HashMap<>();
//		accountService.createAccount(1263862, "Frank Brown");
//		accountService.createAccount(4253892, "John Doe");

    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody AccountCreateDTO accountDTO) {
//        return new ResponseEntity<>(HttpStatus.OK);
//        System.out.println(accountDTO);
        accountService.createAccount(accountDTO.getAccountnumber(), accountDTO.getAccountName());
        return new ResponseEntity<AccountCreateDTO>(accountDTO, HttpStatus.OK);
    }

//		accountService.deposit(1263862, 240);
//		accountService.deposit(1263862, 529);
    @PostMapping("/deposit")
    public ResponseEntity<?> depositAmount(@RequestParam(value="currency", required = false) String currency, @RequestBody DepositDTO depositDTO) {
        if(currency == "euro"){
            accountService.depositEuros(depositDTO.getAccountNumber(), depositDTO.getAmount());
        } else {
            accountService.deposit(depositDTO.getAccountNumber(), depositDTO.getAmount());
        }
        return new ResponseEntity<CustomMessage>(new CustomMessage("Deposit Process Completed"), HttpStatus.OK);
    }

//		accountService.withdrawEuros(1263862, 230);
    @PostMapping("/withdraw")
    public ResponseEntity<?> withdrawAmount(@RequestParam(value="currency", required = false) String currency,@RequestBody DepositDTO depositDTO) {
        if(currency == "euro"){
            accountService.withdrawEuros(depositDTO.getAccountNumber(), depositDTO.getAmount());
        } else {
            accountService.withdraw(depositDTO.getAccountNumber(), depositDTO.getAmount());
        }
        return new ResponseEntity<CustomMessage>(new CustomMessage("Withdraw Process Completed"), HttpStatus.OK);
    }



//		accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
    @PostMapping("/transfer")
    public ResponseEntity<?> transferFunds(@RequestBody TransferFundDTO transferFundDTO){
        accountService.transferFunds(transferFundDTO.getFromAccountNumber(), transferFundDTO.getToAccountNumber(), transferFundDTO.getAmount(), transferFundDTO.getDescription());
        return new ResponseEntity<CustomMessage>(new CustomMessage("Transfer Process Completed"), HttpStatus.OK);

    }




//		// show balances
//
//		Collection<AccountDTO> accountlist = accountService.getAllAccounts();
    @GetMapping
    public Collection<AccountDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }

//		CustomerDTO customer = null;
//		for (AccountDTO account : accountlist) {
//			customer = account.getCustomer();
//			System.out.println("Statement for Account: " + account.getAccountnumber());
//			System.out.println("Account Holder: " + customer.getName());
//			System.out.println(
//					"-Date-------------------------" + "-Description------------------" + "-Amount-------------");
//			for (AccountEntryDTO entry : account.getEntryList()) {
//				System.out.printf("%30s%30s%20.2f\n", entry.getDate().toString(), entry.getDescription(),
//						entry.getAmount());
//			}
//			System.out.println("----------------------------------------" + "----------------------------------------");
//			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
//		}
}

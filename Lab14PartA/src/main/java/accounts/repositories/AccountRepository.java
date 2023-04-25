package accounts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import accounts.domain.Account;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account, String>{
   public Account findByAccountHolder(String accountHolder);
   public Account findByAccountNumber(String accountNumber);
   List<Account> findByAccountHolderStartingWith(String prefix);
}

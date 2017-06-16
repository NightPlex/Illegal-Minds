package nightplex.services.account;

import nightplex.model.Account;
import nightplex.services.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by steven.tihomirov on 16.6.2017.
 */

@Service
public class AccountInformationService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getCurrentAccount() {
        return accountRepository.getByUsername(getCurrentUsername());
    }

    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    private String getCurrentUsername() {
        //Use security context to get current user
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return username;
    }
}


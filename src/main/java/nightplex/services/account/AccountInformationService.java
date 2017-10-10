package nightplex.services.account;

import nightplex.model.Account;
import nightplex.model.UserData;
import nightplex.model.skills.barkeeping.Barkeeping;
import nightplex.model.skills.cooking.Cooking;
import nightplex.services.repository.AccountRepository;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by steven.tihomirov on 16.6.2017.
 */

@Service
public class AccountInformationService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getCurrentAccount() {
        //return getCurrentUserWithOutDb();
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

    public Account getCurrentUserWithOutDb() {
        return accountRepository.getById(1L);
    }

    public List<Account> getAll() {
        return Lists.newArrayList(accountRepository.findAll());
    }

    public void registerNewAccount(String username, String password, String email) {
        UserData d = new UserData(0, 10000, 0, 0, 0);
        Barkeeping b = new Barkeeping(1, 0, 5000, false, true, 30000);
        Account l = new Account(username, password, email, "USER", d, b, new Cooking());
        accountRepository.save(l);
    }
}


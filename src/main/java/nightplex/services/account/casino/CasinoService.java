package nightplex.services.account.casino;

import nightplex.model.Account;
import nightplex.services.account.AccountInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by steven.tihomirov on 26.6.2017.
 */
@Service
public class CasinoService {

    @Autowired
    private AccountInformationService accountInformationService;

    @ModelAttribute("userAccount")
    public Account getAccount() {
        return accountInformationService.getCurrentAccount();
    }

    public String getCasinoPage() {

        return "game/account/casino";

    }

}

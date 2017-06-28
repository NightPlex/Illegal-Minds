package nightplex.controller;

import nightplex.model.Account;
import nightplex.services.account.AccountInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by steven.tihomirov on 28.6.2017.
 */
@Controller
public class AdminController {

    @Autowired
    private AccountInformationService accountInformationService;

    @ModelAttribute("userAccount")
    public Account getAccount() {
        return accountInformationService.getCurrentAccount();
    }



}

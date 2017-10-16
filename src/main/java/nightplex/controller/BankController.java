package nightplex.controller;

import nightplex.model.Account;
import nightplex.model.template.bank.ReturnInteger;
import nightplex.services.account.AccountInformationService;
import nightplex.services.account.bank.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by NightPlex
 * Github: https://github.com/NightPlex
 *
 * @author NightPlex
 */
@Controller
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private AccountInformationService accountInformationService;

    @Autowired
    private BankService bankService;

    @ModelAttribute("userAccount")
    public Account getAccount() {
        return accountInformationService.getCurrentAccount();
    }

    //Input handler
    @ModelAttribute("inputHandler")
    public ReturnInteger getAmount() {
        return new ReturnInteger();
    }

    @GetMapping
    public String getBankPage() {
        return "game/bank/bank";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public String withdrawMoney(@ModelAttribute("inputHandler") ReturnInteger returnInteger) {

        bankService.withdrawMoney(returnInteger.getAmount());
        returnInteger.setAmount(0);

        return "game/bank/bank";
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public String depositMoney(@ModelAttribute("inputHandler") ReturnInteger returnInteger) {
        bankService.depositMoney(returnInteger.getAmount());
        returnInteger.setAmount(0);

        return "game/bank/bank";
    }

}

package nightplex.services.account.bank;

import nightplex.model.Account;
import nightplex.services.account.AccountInformationService;
import nightplex.services.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by steven.tihomirov on 20.6.2017.
 */
@Service
public class BankService {

    @Autowired
    private AccountInformationService accountInformationService;

    @Autowired
    private NotificationService notificationService;

    public void withdrawMoney(int amount) {
        Account account = accountInformationService.getCurrentAccount();
        if(BankLogic.performAddMoneyToBankTransaction(account, amount)) {
            notificationService.addInfoMessage("Sucess", "Added " + account + " to your bank!");
        } else {
            notificationService.addErrorMessage("Error", "You do not have enough money.");
        }
    }
}

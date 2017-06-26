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
        String[] outcome = BankLogic.performWithdrawMoneyToBankTransaction(account, amount);
        if(outcome == null) {
            notificationService.addInfoMessage("Success", "You take " + amount + " from your bank!");
            accountInformationService.saveAccount(account);
        } else {
            notificationService.addErrorMessage(outcome[0] , outcome[1]);
        }
    }

    public void depositMoney(int amount) {
        Account account = accountInformationService.getCurrentAccount();
        String[] outcome = BankLogic.performAddMoneyToBankTransaction(account, amount);
        if(outcome == null) {
            notificationService.addInfoMessage("Success", "You put " + amount + " to your bank!");
            accountInformationService.saveAccount(account);
            return;
        }
        notificationService.addErrorMessage(outcome[0] , outcome[1]);

    }
}

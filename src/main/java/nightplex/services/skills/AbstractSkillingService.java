package nightplex.services.skills;

import nightplex.model.Account;
import nightplex.services.GeneralService;
import nightplex.services.account.AccountInformationService;
import nightplex.services.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by steven.tihomirov on 10.10.2017
 */
public class AbstractSkillingService {

    @Autowired
    protected AccountInformationService accountInformationService;

    @Autowired
    protected GeneralService generalService;

    @Autowired
    protected NotificationService notificationService;

    protected void handleAccountStatusMessage(Account account, String[] message) {
        if (message == null) {
            accountInformationService.saveAccount(account);
        } else {
            //Returned array of string will populate the error messages
            notificationService.addErrorMessage(message[0], message[1]);
        }
    }

}

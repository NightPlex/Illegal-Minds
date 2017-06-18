package nightplex.services.skills.barkeeping;

import nightplex.ServerCONF;
import nightplex.model.Account;
import nightplex.services.GeneralService;
import nightplex.services.account.AccountInformationService;
import nightplex.services.notification.NotificationService;
import nightplex.services.skills.barkeeping.logic.DrinkTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * "Busines logic" for barkeeping skill
 * 
 * NightPlex
 * */
@Service
public class BarKeepingServiceImpl implements BarKeepingService {

    @Autowired
    private AccountInformationService accountInformationService;

    @Autowired
    private GeneralService generalService;

    @Autowired
    private NotificationService notificationService;

    /**
     * Buy bar for fixed price.
     */
    public boolean buyBar() {

        Account account = accountInformationService.getCurrentAccount();

        if (account.getUserData().getMoney() >= ServerCONF.BAR_PRICE) {

            account.getUserData().setMoney(account.getUserData().getMoney() - ServerCONF.BAR_PRICE);
            account.getBarkeeping().setHasBoughtBar(true);
            accountInformationService.saveAccount(account);
            return true;
        } else {
            notificationService.addErrorMessage("Not enough money", "You do not have enough money to buy own bar!");
            return false;
        }
    }

    @Override
    public boolean buyRawMaterial(int amount, int id) {

        Account account = accountInformationService.getCurrentAccount();

        if (DrinkTasks.changeRawMaterial(account, id, amount, true)) {
            accountInformationService.saveAccount(account);
            return true;
        } else {
            notificationService.addErrorMessage("Not enough room", "You cannot store more than: " + account.getBarkeeping().getStorageCapacity());
            return false;
        }
    }

    @Override
    public boolean makeDrink(int id) {

        Account account = accountInformationService.getCurrentAccount();

        if (DrinkTasks.makeDrink(generalService.getDrink(id), account)) {
            accountInformationService.saveAccount(account);
            return true;
        } else {
            notificationService.addErrorMessage("No material", "Make sure you have all the necessary material!");
            return false;
        }
    }


    @Override
    public boolean toggleBar() {

        Account account = accountInformationService.getCurrentAccount();

        if (!account.getBarkeeping().isBarIsClosed()) {

            account.getBarkeeping().setBarIsClosed(true);

            notificationService.addInfoMessage("Success", "You closed your bar");

            return true;

        } else {

            account.getBarkeeping().setBarIsClosed(false);
            notificationService.addInfoMessage("Success", "You opened your bar");

            return true;

        }

    }
}
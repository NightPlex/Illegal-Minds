package nightplex.services.skills.barkeeping;

import nightplex.ServerCONF;
import nightplex.model.Account;
import nightplex.services.account.AccountInformationService;
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
            return false;
        }
    }

    @Override
    public boolean buyRawMaterial(int amount, int id) {

        Account account = accountInformationService.getCurrentAccount();

        if (DrinkTasks.buyRawMaterial(account, id, amount)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean makeDrink(int id) {

        Account account = accountInformationService.getCurrentAccount();

        if (account.getBarkeeping().getBarStorage().getWater() > 0) {

            account.getBarkeeping().getBarStorage()
                    .setWater(account.getBarkeeping().getBarStorage().getWater() - 1);

            account.getBarkeeping().getKitchenStorage()
                    .setFilteredWater(account.getBarkeeping().getKitchenStorage().getFilteredWater() + 1);
            // check for xp and lvl change.

            //repo.save(account);

            return true;

        } else {

            return false;
        }
    }


    @Override
    public boolean toggleBar() {

        Account account = accountInformationService.getCurrentAccount();

        if (!account.getBarkeeping().isBarIsClosed()) {

            account.getBarkeeping().setBarIsClosed(true);

            return true;


        } else {

            account.getBarkeeping().setBarIsClosed(false);
            return true;

        }

    }
}
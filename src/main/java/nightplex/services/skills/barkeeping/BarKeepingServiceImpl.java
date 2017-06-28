package nightplex.services.skills.barkeeping;

import nightplex.ServerCONF;
import nightplex.model.Account;
import nightplex.model.template.skills.barkeeping.DrinkData;
import nightplex.model.template.skills.barkeeping.Material;
import nightplex.services.GeneralService;
import nightplex.services.account.AccountInformationService;
import nightplex.services.notification.NotificationService;
import nightplex.services.skills.barkeeping.logic.DrinkTasks;
import nightplex.services.skills.barkeeping.logic.ReadyDrinks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
    public boolean buyRawMaterial(int amount, String ingredient) {

        Account account = accountInformationService.getCurrentAccount();

        String[] response = DrinkTasks.addRawMaterial(account, generalService.getMaterial(ingredient), amount);

        if (response == null) {
            accountInformationService.saveAccount(account);
            return true;
        } else {
            notificationService.addErrorMessage(response[0], response[1]);
            return false;
        }
    }

    @Override
    public boolean removeRawMaterial(int amount, String ingredients) {
        Account account = accountInformationService.getCurrentAccount();

        if (DrinkTasks.removeRawMaterial(account, ingredients, amount)) {
            accountInformationService.saveAccount(account);
            return true;
        } else {
            notificationService.addErrorMessage("Not enough ingredient", "You don't have enough ingredients: " + account.getBarkeeping().getStorageCapacity());
            return false;
        }
    }

    @Override
    public List<DrinkData> getAllDrinks() {
        List<DrinkData> allDrinks = new LinkedList<>();
        for (int id : generalService.getDrinks().keySet()) {
            if(id == 1337) continue;
            allDrinks.add(generalService.getDrink(id));
        }
        return allDrinks;
    }

    @Override
    public List<Material> getAllMaterial() {
        return generalService.getMaterials();
    }

    @Override
    public List<Material> getPlayersMaterial() {
        Account account = accountInformationService.getCurrentAccount();
        List<Material> playersDrink = new LinkedList<>();
        Map<String, Integer> drinkMap = account.getBarkeeping().getIngredients();
        for(String name : drinkMap.keySet()) {
            playersDrink.add(new Material(name, drinkMap.get(name)));
        }
        return playersDrink;
    }

    @Override
    public boolean makeDrink(int id) {

        Account account = accountInformationService.getCurrentAccount();

        String[] response = DrinkTasks.makeDrink(generalService.getDrink(id), account);

        if (response == null) {
            accountInformationService.saveAccount(account);
            return true;
        } else {
            //Returned array of string will populate the error messages
            notificationService.addErrorMessage(response[0], response[1]);
            return false;
        }
    }


    @Override
    public void toggleBar() {

        Account account = accountInformationService.getCurrentAccount();

        if (!account.getBarkeeping().isBarIsClosed()) {

            account.getBarkeeping().setBarIsClosed(true);

            notificationService.addInfoMessage("Success", "You closed your bar");
            accountInformationService.saveAccount(account);

        } else {

            account.getBarkeeping().setBarIsClosed(false);
            notificationService.addInfoMessage("Success", "You opened your bar");
            accountInformationService.saveAccount(account);

        }
    }

    @Override
    public void sellDrinks(Account account) {
        //Get the amount of drinks that can be sold and try to sell them.
        int sellAmount = ReadyDrinks.amountToSell(account);
        //Fetch all accounts drinks
        Map<Integer, Integer> readyDrinks = account.getBarkeeping().getReadyDrinks();
        //Iterate
        for (int integer : readyDrinks.keySet()) {
            //Get drink data for corresponding drink
            DrinkData drinkData = generalService.getDrink(integer);
            //If amount cant be sold sell it.
            if (readyDrinks.get(integer) - sellAmount >= 0) {
                //Add money based on level * amount
                account.getUserData().addMoney(sellAmount * ReadyDrinks.moneyRewarded(drinkData.getLevel()));
                //Add reputation
                account.getBarkeeping().setReputation(account.getBarkeeping().getReputation() + sellAmount * ReadyDrinks.reputationRewarded(drinkData.getLevel()));
                //remove the ingredients from map
                account.getBarkeeping().removeDrinkFromStorage(integer, sellAmount);
                break;
            } else {
                if (sellAmount - readyDrinks.get(integer) > 0) {
                    account.getUserData().addMoney(readyDrinks.get(integer) * ReadyDrinks.moneyRewarded(drinkData.getLevel()));
                    //Add reputation
                    account.getBarkeeping().setReputation(account.getBarkeeping().getReputation() + readyDrinks.get(integer) * ReadyDrinks.reputationRewarded(drinkData.getLevel()));
                    //remove the ingredients from map
                    account.getBarkeeping().removeDrinkFromStorage(drinkData.getId(), readyDrinks.get(integer));
                    sellAmount -= readyDrinks.get(integer);
                }

            }
        }
        account.getBarkeeping().removeReputation(sellAmount);
    }
}
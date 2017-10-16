package nightplex.services.skills.barkeeping;

import nightplex.ServerCONF;
import nightplex.model.Account;
import nightplex.model.template.skills.barkeeping.DrinkData;
import nightplex.model.template.skills.barkeeping.Material;
import nightplex.services.skills.AbstractSkillingService;
import nightplex.services.skills.barkeeping.logic.DrinkTaskService;
import nightplex.services.skills.barkeeping.logic.ReadyDrinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * "Busines logic" for barkeeping skill
 * 
 * NightPlex
 * */
@Service
public class BarKeepingService extends AbstractSkillingService {

    @Autowired
    private DrinkTaskService drinkTaskService;

    @Autowired
    private ReadyDrinksService readyDrinksService;

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

    public boolean buyRawMaterial(int amount, String ingredient) {

        if(amount <= 0) {
            notificationService.addErrorMessage("Error", "Invalid amount, must be more than 0");
            return false;
        }

        Account account = accountInformationService.getCurrentAccount();

        String[] response = drinkTaskService.addRawMaterial(account, generalService.getMaterial(ingredient), amount);

        if (response == null) {
            accountInformationService.saveAccount(account);
            return true;
        } else {
            notificationService.addErrorMessage(response[0], response[1]);
            return false;
        }
    }

    public void removeRawMaterial(int amount, String ingredients) {
        Account account = accountInformationService.getCurrentAccount();

        String[] messages = drinkTaskService.removeRawMaterial(account, ingredients, amount);

        handleAccountStatusMessage(account, messages);
    }

    public List<DrinkData> getAllDrinks() {
        List<DrinkData> allDrinks = new LinkedList<>();
        for (int id : generalService.getDrinks().keySet()) {
            if(id == 1337) continue;
            allDrinks.add(generalService.getDrink(id));
        }
        return allDrinks;
    }

    public List<Material> getAllMaterial() {
        return generalService.getMaterials();
    }

    public List<Material> getPlayersMaterial() {
        Account account = accountInformationService.getCurrentAccount();
        List<Material> playersDrink = new LinkedList<>();
        Map<String, Integer> drinkMap = account.getBarkeeping().getIngredients();
        for(String name : drinkMap.keySet()) {
            playersDrink.add(new Material(name, drinkMap.get(name)));
        }
        return playersDrink;
    }

    public List<DrinkData> getAllPlayerDrinks() {
        Account account = accountInformationService.getCurrentAccount();
        List<DrinkData> playerDrinks = new LinkedList<>();
        Map<Integer, Integer> readyDrinks = account.getBarkeeping().getReadyDrinks();
        for(int id : readyDrinks.keySet()) {
            DrinkData drinkToAdd = generalService.getDrink(id);
            drinkToAdd.setAmount(readyDrinks.get(id));
            playerDrinks.add(drinkToAdd);
        }
        return playerDrinks;
    }

    public void makeDrink(int id) {

        Account account = accountInformationService.getCurrentAccount();

        String[] response = drinkTaskService.makeDrink(generalService.getDrink(id), account);

        handleAccountStatusMessage(account, response);
    }


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

    /**
     *
     * Sell all current drinks for account
     *
     * @param account
     */
    public void sellDrinks(Account account) {
        //Get the amount of drinks that can be sold and try to sell them.
        int sellAmount = readyDrinksService.amountToSell(account);
        //Fetch all accounts drinks
        Map<Integer, Integer> readyDrinks = account.getBarkeeping().getReadyDrinks();
        //Iterate
        for (int integer : readyDrinks.keySet()) {
            //Get drink data for corresponding drink
            DrinkData drinkData = generalService.getDrink(integer);
            //If amount cant be sold sell it.
            if (readyDrinks.get(integer) - sellAmount >= 0) {
                //Add money based on level * amount
                account.getUserData().addMoney(sellAmount * readyDrinksService.moneyRewarded(drinkData.getLevel()));
                //Add reputation
                account.getBarkeeping().setReputation(account.getBarkeeping().getReputation() + sellAmount * readyDrinksService.reputationRewarded(drinkData.getLevel()));
                //remove the ingredients from map
                account.getBarkeeping().removeDrinkFromStorage(integer, sellAmount);
                break;
            } else {
                if (sellAmount - readyDrinks.get(integer) > 0) {
                    account.getUserData().addMoney(readyDrinks.get(integer) * readyDrinksService.moneyRewarded(drinkData.getLevel()));
                    //Add reputation
                    account.getBarkeeping().setReputation(account.getBarkeeping().getReputation() + readyDrinks.get(integer) * readyDrinksService.reputationRewarded(drinkData.getLevel()));
                    //remove the ingredients from map
                    account.getBarkeeping().removeDrinkFromStorage(drinkData.getId(), readyDrinks.get(integer));
                    sellAmount -= readyDrinks.get(integer);
                }
            }
        }
        account.getBarkeeping().removeReputation(sellAmount);
    }
}
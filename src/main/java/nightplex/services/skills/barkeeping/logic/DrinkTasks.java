package nightplex.services.skills.barkeeping.logic;

import nightplex.model.Account;
import nightplex.model.template.skills.barkeeping.DrinkData;
import nightplex.model.template.skills.barkeeping.Material;

/**
 * Created by steven.tihomirov on 16.6.2017.
 * <p>
 * Generate some dummy method
 */
public class DrinkTasks {


    private static boolean hasRoom(Account account, int amount) {
        //Storage capacity check here
        return true;
    }

    private static boolean hasLevel(Account account, int level) {
        if (account.getBarkeeping().getLevel() >= level) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean makeDrink(DrinkData drinkData, Account account) {
        //Has level required?
        if (!hasLevel(account, drinkData.getLevel())) {
            return false;
        }
        //First check that there are ingredients
        for (Material material : drinkData.getMaterial()) {
            if (!removeRawMaterial(account, material.getName(), material.getAmount())) {
              return false;
            }
        }
        account.getBarkeeping().addExp(drinkData.getExperience());
        account.getBarkeeping().setDrinks(account.getBarkeeping().getDrinks() + 1);
        return true;
    }

    //Change raw material
    //Ignore the design here, it's just dummy change.
    public static boolean addRawMaterial(Account account, String ingredient, int amount) {
        account.getBarkeeping().addIngredient(ingredient, amount);
        return true;
    }

    public static boolean removeRawMaterial(Account account, String ingredient, int amount) {
        if (account.getBarkeeping().removeIngredient(ingredient, amount)) {
            return true;
        } else {
            return false;
        }
    }

    public static void addDrink(int id, Account account) {
        switch (id) {
            case 1:
        }
    }
}

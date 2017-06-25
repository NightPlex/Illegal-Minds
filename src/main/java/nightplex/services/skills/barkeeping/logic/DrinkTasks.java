package nightplex.services.skills.barkeeping.logic;

import nightplex.model.Account;
import nightplex.model.template.skills.barkeeping.DrinkData;
import nightplex.model.template.skills.barkeeping.Material;
import nightplex.util.StringUtils;

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

    /**
     *
     * Returns array of string with the title being at 0 position and text at  1
     *
     * */
    public static String[] makeDrink(DrinkData drinkData, Account account) {
        //Has level required?
        if (!hasLevel(account, drinkData.getLevel())) {
            return new String[]{"Low level", "You need at least barkeeping level of " + drinkData.getLevel() + " to make this drink"};
        }
        //First check that there are ingredients
        for (Material material : drinkData.getMaterial()) {
            if (!removeRawMaterial(account, material.getName(), material.getAmount())) {
              return new String[]{"Lack of material", "You are missing " + material.getAmount() + "x " + StringUtils.convertFromIdToName(material.getName())};

            }
        }
        account.getBarkeeping().addExp(drinkData.getExperience());
        account.getBarkeeping().addDrinkToStorage(drinkData.getId(), 1);
        return null;
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

}

package nightplex.services.skills.barkeeping.logic;

import nightplex.model.Account;
import nightplex.model.template.skills.barkeeping.DrinkData;
import nightplex.model.template.skills.barkeeping.Material;
import nightplex.util.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Created by steven.tihomirov on 16.6.2017.
 * <p>
 * Generate some dummy method
 */
@Service
public class DrinkTaskService {

    private boolean hasRoom(Account account, int amount) {
        //Storage capacity check here
        return true;
    }

    private boolean hasLevel(Account account, int level) {
        if (account.getBarkeeping().getLevel() >= level) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param drinkData
     * @param account
     * @return Returns array of string with the title being at 0 position and text at  1
     */
    public String[] makeDrink(DrinkData drinkData, Account account) {
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

    /**
     *
     * @param account
     * @param material
     * @param amount
     * @return Returns array of string with the title being at 0 position and text at  1
     */
    public String[] addRawMaterial(Account account, Material material, int amount) {
        if(hasRoom(account, amount)) {
            int totalAmount = material.getPrice() * amount;
            System.out.println(totalAmount);
            if(account.getUserData().getMoney() - totalAmount >= 0) {
                account.getBarkeeping().addIngredient(material.getName(), amount);
                account.getUserData().removeMoney(totalAmount);
                return null;
            }
            return new String[]{"Error", "You do not have enough money"};
        }
        return new String[]{"Error", "Not enough storage room for these products"};
    }

    /**
     *
     * @param account
     * @param ingredient
     * @param amount
     * @return
     */
    public String[] removeRawMaterial(Account account, String ingredient, int amount) {
        if (account.getBarkeeping().removeIngredient(ingredient, amount)) {
            return null;
        } else {
            return new String[]{"Not enough ingredient", "You don't have enough ingredients: " + account.getBarkeeping().getStorageCapacity()};
        }
    }

}

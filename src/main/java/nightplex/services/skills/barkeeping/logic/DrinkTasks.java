package nightplex.services.skills.barkeeping.logic;

import nightplex.model.Account;
import nightplex.model.template.skills.barkeeping.DrinkData;
import nightplex.model.template.skills.barkeeping.Material;

/**
 * Created by steven.tihomirov on 16.6.2017.
 *
 * Generate some dummy method
 *
 */
public class DrinkTasks {


    private static boolean hasRoom(Account account, int amount) {
        //Storage capacity check here
        return true;
    }

    private static boolean hasLevel(Account account, int level) {
        if(account.getBarkeeping().getLevel() >= level) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean makeDrink(DrinkData drinkData, Account account) {
        //Has level required?
        if(!hasLevel(account, drinkData.getLevel())) {
            return false;
        }
        //First check that there are ingredients
        System.out.println("test");
        for(Material material : drinkData.getMaterial()) {
            if(!changeRawMaterial(account, material.getId(), material.getAmount(), false)) {
                return false;
            }
        }
        account.getBarkeeping().addExp(drinkData.getExperience());
        account.getBarkeeping().setDrinks(account.getBarkeeping().getDrinks() + 1);
        return true;
    }

    //Change raw material
    //Ignore the design here, it's just dummy change.
    public static boolean changeRawMaterial(Account account, int id, int amount, boolean toAdd) {
        switch (id) {
            //water
            case 1:
                if(toAdd) {
                    if (hasRoom(account, amount))
                        account.getBarkeeping().getBarStorage().setWater(account.getBarkeeping().getBarStorage().getWater() + amount);
                }else {
                    account.getBarkeeping().getBarStorage().setWater(account.getBarkeeping().getBarStorage().getWater() - amount);

                }
                return true;
            case 2:
                if(toAdd) {
                    if (hasRoom(account, amount))
                        account.getBarkeeping().getBarStorage().setRawMilk(account.getBarkeeping().getBarStorage().getRawMilk() + amount);
                }else {
                    account.getBarkeeping().getBarStorage().setRawMilk(account.getBarkeeping().getBarStorage().getRawMilk() - amount);

                }
                return true;
            default:
                return false;
        }
    }
}

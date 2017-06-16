package nightplex.services.skills.barkeeping.logic;

import nightplex.model.Account;

/**
 * Created by steven.tihomirov on 16.6.2017.
 *
 * Generate some dummy method
 *
 */
public class DrinkTasks {

    public static boolean buyRawMaterial(Account account, int id, int amount) {
        switch (id) {
            //water
            case 1:
                if(hasRoom(account, amount)) account.getBarkeeping().getBarStorage().setWater(account.getBarkeeping().getBarStorage().getWater() + amount);
                return true;
            default:
                return false;
        }
    }

    private static boolean hasRoom(Account account, int amount) {
        //Storage capacity check here
        return true;
    }
}

package nightplex.services.skills.barkeeping.logic;

import nightplex.ServerCONF;
import nightplex.model.Account;
import nightplex.model.template.skills.barkeeping.DrinkData;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by steven.tihomirov on 19.6.2017.
 */
public class ReadyDrinks {


    //Money rewarded per each drink
    public static int moneyRewarded(int drinkLevel) {
        return drinkLevel * ServerCONF.MONEY_PER_DRINK_MULTIPLIER;
    }

    //Money rewarded per each drink
    public static int reputationRewarded(int drinkLevel) {
        return drinkLevel * ServerCONF.MONEY_PER_DRINK_MULTIPLIER;
    }

    public static int amountToSell(Account account) {

        int percentage = 0;
        return 5;

    }

}

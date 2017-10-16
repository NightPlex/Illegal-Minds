package nightplex.services.skills.barkeeping.logic;

import nightplex.ServerCONF;
import nightplex.model.Account;
import org.springframework.stereotype.Service;

/**
 * Created by steven.tihomirov on 19.6.2017.
 */
@Service
public class ReadyDrinksService {


    //Money rewarded per each drink
    public int moneyRewarded(int drinkLevel) {
        return drinkLevel * ServerCONF.MONEY_PER_DRINK_MULTIPLIER;
    }

    //Money rewarded per each drink
    public int reputationRewarded(int drinkLevel) {
        return drinkLevel * ServerCONF.MONEY_PER_DRINK_MULTIPLIER;
    }

    public int amountToSell(Account account) {

        int percentage = 0;
        return 5;

    }

}

package nightplex.services.account.bank;

import nightplex.model.Account;

/**
 * Created by steven.tihomirov on 20.6.2017.
 */
public class BankLogic {

    public static boolean hasMoney(Account account, int amount) {
        if(account.getUserData().getMoney() - amount >= 0) {
            return true;
        }
        return false;
    }

    public static boolean performAddMoneyToBankTransaction(Account account, int amount) {
        if(hasMoney(account, amount)) {
            account.getUserData().setMoney(account.getUserData().getMoney() - amount);
            account.getUserData().setMoneyInBank(account.getUserData().getMoneyInBank() + amount);
            return true;
        }
        return false;
    }
}

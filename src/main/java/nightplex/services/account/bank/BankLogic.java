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

    public static boolean hasMoneyInBank(Account account, int amount) {
        if(account.getUserData().getMoneyInBank() - amount >= 0) {
            return true;
        }
        return false;
    }

    public static String[] performAddMoneyToBankTransaction(Account account, int amount) {
        if(hasMoney(account, amount)) {
            account.getUserData().setMoney(account.getUserData().getMoney() - amount);
            account.getUserData().setMoneyInBank(account.getUserData().getMoneyInBank() + amount);
            return null;
        }
        return new String[]{"Lack of money", "You do not have enough money on you"};
    }

    public static String[] performWithdrawMoneyToBankTransaction(Account account, int amount) {
        if(hasMoneyInBank(account, amount)) {
            account.getUserData().setMoney(account.getUserData().getMoney() + amount);
            account.getUserData().setMoneyInBank(account.getUserData().getMoneyInBank() - amount);
            return null;
        }
        return new String[]{"Lack of money", "You do not have enough money in your bank"};
    }
}

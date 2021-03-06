package nightplex.services.scheduling;

import nightplex.ServerCONF;
import nightplex.model.Account;
import nightplex.services.account.AccountInformationService;
import nightplex.services.skills.barkeeping.BarKeepingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Objects;

/**
 * Created by NightPlex
 * Github: https://github.com/NightPlex
 *
 * Scheduling tasks for Account, eg: selling drinks and so on.
 *
 * @author NightPlex
 */
@Component
public class AccountScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private AccountInformationService accountInformationService;

    @Autowired
    private BarKeepingService barKeepingService;

    private int nextCustomers;

    @Scheduled(fixedRate = 1000)
    public void oneSecondCounter() {
        nextCustomers++;
    }

    /**
     * Every 15 minutes new batch of customers come.
     * */
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        //Check and calculate drinks and profit.

        //System.out.println(dateFormat.format(new Date()) + " time");
    }

    @Scheduled(fixedRate = ServerCONF.DRINK_UPDATE_TIME * 1000)
    public void updateDrinks() {
        accountInformationService.getAll().stream()
                .filter(Objects::nonNull)
                .forEach(this::updateDrinks);
        nextCustomers = 0;
    }
    private void updateDrinks(Account account) {
        if(!account.getBarkeeping().isBarIsClosed()) {
            barKeepingService.sellDrinks(account);
            accountInformationService.saveAccount(account);
        }
    }

    public int getNextCustomers() {
        return nextCustomers;
    }

    public void setNextCustomers(int nextCustomers) {
        this.nextCustomers = nextCustomers;
    }
}
